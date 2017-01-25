package com.wcms.web.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


/**
 * Created by Administrator on 2017/1/19.
 */
public class BaseAction extends ActionSupport implements SessionAware {


    protected Map<String, Object> session;
    private String data;
    private Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-dd").create();

    protected <T> T getRequest(Class<T> type) {
        System.out.println(getClass().getSimpleName() + ".getRequest---" + data);
        if (data == null) {
            return null;
        }
        return gson.fromJson(data, type);
    }

    protected <T> void sendResult(T result) {
        String resultStr = gson.toJson(result);
        PrintWriter out = null;
        try {
            out = getResponse().getWriter();
            out.print(resultStr);
            System.out.println(getClass().getSimpleName() + ".sendResult---" + resultStr);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }

        }

    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    protected ServletContext getServletContext() {
        return ServletActionContext.getServletContext();
    }

    protected HttpServletResponse getResponse() {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        return response;
    }

    protected HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    protected HttpSession getHttpSession() {
        return getRequest().getSession(true);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map<String, Object> getSession() {
        return session;
    }

}
