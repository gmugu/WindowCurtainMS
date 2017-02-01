package com.wcms.web.interceptor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.wcms.util.gson.DateAdapter;
import com.wcms.util.gson.DoubleAdapter;
import com.wcms.util.gson.IntegerAdapter;
import com.wcms.util.gson.LongAdapter;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * Created by mugu on 16-4-25.
 */
public class BaseInterceptor implements Interceptor {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private Map<String, Object> session;
    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(Integer.class, new IntegerAdapter())
            .registerTypeAdapter(int.class, new IntegerAdapter())
            .registerTypeAdapter(Double.class, new DoubleAdapter())
            .registerTypeAdapter(double.class, new DoubleAdapter())
            .registerTypeAdapter(Long.class, new LongAdapter())
            .registerTypeAdapter(long.class, new LongAdapter())
            .registerTypeAdapter(Date.class, new DateAdapter("yyyy-MM-dd"))
//            .setDateFormat("yyyy-MM-dd")
            .create();
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext invocationContext = actionInvocation.getInvocationContext();
        request = (HttpServletRequest) invocationContext.get(ServletActionContext.HTTP_REQUEST);
        response = (HttpServletResponse) invocationContext.get(ServletActionContext.HTTP_RESPONSE);
        response.setCharacterEncoding("utf-8");
        session = invocationContext.getSession();
        return null;
    }

    public HttpServletRequest getRequest() {
        if (request == null) {
            throw new RuntimeException("You must invoke the super method of intercept()");
        }
        return request;
    }


    public HttpServletResponse getResponse() {
        if (response == null) {
            throw new RuntimeException("You must invoke the super method of intercept()");
        }
        return response;
    }

    public Map<String, Object> getSession() {
        if (session == null) {
            throw new RuntimeException("You must invoke the super method of intercept()");
        }
        return session;
    }

    protected <T> void sendResult(T result) {
        String resultStr = gson.toJson(result);
        PrintWriter out = null;
        try {
            out = getResponse().getWriter();
            out.print(resultStr);
            StackTraceElement stack[] = (new Throwable()).getStackTrace();
            System.out.println(getClass().getSimpleName() + "." + stack[1].getMethodName() + "(sendResult)---" + resultStr);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }

        }

    }
}
