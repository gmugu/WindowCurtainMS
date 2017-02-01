package com.wcms.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wcms.entity.UsersEntity;
import com.wcms.service.LoginService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by Administrator on 2017/2/1.
 */
public class LoginAction extends ActionSupport implements SessionAware {
    private LoginService loginService;
    private String username;
    private String password;
    private String msg;
    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        try {
            UsersEntity usersEntity = loginService.login(username, password);
            session.put("UsersEntity", usersEntity);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            msg = e.getMessage();
            return LOGIN;
        }
        return SUCCESS;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
