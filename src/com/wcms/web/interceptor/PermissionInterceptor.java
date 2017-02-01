package com.wcms.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.wcms.entity.UsersEntity;
import com.wcms.model.Result;

/**
 * Created by mugu on 16-4-25.
 */
public class PermissionInterceptor extends BaseInterceptor {
    private String type;
    private int authority;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        super.intercept(actionInvocation);
        UsersEntity usersEntity = (UsersEntity) getSession().get("UsersEntity");
        int au = 0;
        switch (type) {
            case "basic":
                au = usersEntity.getAuBasic();
                break;
            case "store":
                au = usersEntity.getAuStore();
                break;
            case "order":
                au = usersEntity.getAuOrder();
                break;
            case "business":
                au = usersEntity.getAuBusiness();
                break;
            case "financial":
                au = usersEntity.getAuFinancial();
                break;
            case "admin":
                if ("admin".equals(usersEntity.getUsername())) {
                    au = 3;
                }
                break;
        }

        if (usersEntity != null && type != null && au >= authority) {
            return actionInvocation.invoke();
        } else {
            Result result = new Result();
            result.setCode(1);
            result.setMsg("您没有权限执行本操作");
            sendResult(result);
            return ActionSupport.NONE;
        }

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }
}
