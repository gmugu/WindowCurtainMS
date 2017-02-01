package com.wcms.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by Administrator on 2017/2/1.
 */
public class LogoutAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        session.clear();
        return LOGIN;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
