package com.wcms.model;

/**
 * Created by Administrator on 2017/1/21.
 */
public class Result<T> {
    private int code = 0;
    private String msg = null;
    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
