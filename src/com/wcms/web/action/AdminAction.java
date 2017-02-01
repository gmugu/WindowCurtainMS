package com.wcms.web.action;

import com.wcms.entity.CustomerEntity;
import com.wcms.entity.UsersEntity;
import com.wcms.entity.UsersEntity;
import com.wcms.model.Result;
import com.wcms.service.AdminService;
import com.wcms.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2017/2/1.
 */
public class AdminAction extends BaseAction {
    private AdminService adminService;

    public String getall() throws Exception {
        Result<List<UsersEntity>> result = new Result();
        List<UsersEntity> list = adminService.findAll();
        result.setData(list);
        sendResult(result);
        return NONE;
    }

    public String add() throws Exception {
        UsersEntity entity = getRequest(UsersEntity.class);
        Result<UsersEntity> result = new Result();
        try {
            adminService.add(entity);
            result.setData(entity);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String remove() throws Exception {
        UsersEntity entity = getRequest(UsersEntity.class);
        Result result = new Result();
        try {
            adminService.delete(entity.getUsername());
        } catch (ServiceException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public String update() throws Exception {
        UsersEntity entity = getRequest(UsersEntity.class);
        Result result = new Result();
        try {
            adminService.update(entity);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg(e.getMessage());
        }
        sendResult(result);
        return NONE;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

}
