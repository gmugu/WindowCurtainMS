package com.wcms.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.wcms.entity.UsersEntity;
import com.wcms.model.Result;
import com.wcms.service.LoginService;
import com.wcms.service.exception.ServiceException;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by mugu on 16-4-25.
 */
public class LoginInterceptor extends BaseInterceptor {

    private LoginService loginService;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        super.intercept(actionInvocation);
        ActionContext invocationContext = actionInvocation.getInvocationContext();

        UsersEntity usersEntity = (UsersEntity) getSession().get("UsersEntity");
        if (usersEntity == null) {//未登录
            Result result = new Result();
            HttpServletRequest request = (HttpServletRequest) invocationContext.get(ServletActionContext.HTTP_REQUEST);
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String username = null;
                String password = null;
                for (Cookie c : cookies) {
                    if ("username".equals(c.getName())) {
                        username = c.getValue();
                    }
                    if ("password".equals(c.getName())) {
                        password = c.getValue();
                    }
                }
                if (username != null && password != null) {
                    try {
                        usersEntity = loginService.login(username, password);
                        getSession().put("UsersEntity", usersEntity);//登录成功
                        return actionInvocation.invoke();
                    } catch (ServiceException e) {
                        System.out.println(e.getMessage());
                        result.setCode(1);
                        result.setMsg("您未登录");
                        sendResult(result);
                        return ActionSupport.NONE;
                    }
                } else {
                    result.setCode(1);
                    result.setMsg("您未登录");
                    sendResult(result);
                    return ActionSupport.NONE;
                }
            }
            result.setCode(1);
            result.setMsg("您未登录");
            sendResult(result);
            return ActionSupport.NONE;
        } else {//已登录
            return actionInvocation.invoke();
        }

    }


    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
