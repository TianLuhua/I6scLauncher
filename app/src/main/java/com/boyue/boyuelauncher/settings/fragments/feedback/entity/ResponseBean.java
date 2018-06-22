package com.boyue.boyuelauncher.settings.fragments.feedback.entity;

public class ResponseBean {

    private String msg;
    private String ret;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "msg='" + msg + '\'' +
                ", ret='" + ret + '\'' +
                '}';
    }
}
