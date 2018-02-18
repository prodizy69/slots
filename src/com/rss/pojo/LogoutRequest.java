package com.rss.pojo;

public class LogoutRequest
{
    private String sid;
    public LogoutRequest() {
    }

    public LogoutRequest(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "LogoutRequest{" +
                "sid='" + sid + '\'' +
                '}';
    }
}
