package com.wcms.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wcms.service.Server;

/**
 * Created by Administrator on 2017/1/19.
 */
public class BaseAction extends ActionSupport {

    private Server server;
    @Override
    public String execute() throws Exception {
        System.out.println(server.test());
        return NONE;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
