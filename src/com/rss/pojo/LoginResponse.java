package com.rss.pojo;


import com.rss.common.ErrorObj;

public class LoginResponse extends BaseResponse{
    private String sid = null;
    private PlayerObject user=new PlayerObject();
    public LoginResponse(boolean isSuccess, ErrorObj error) {
        super(isSuccess, error);
    }

    public LoginResponse(boolean isSuccess, ErrorObj error, PlayerObject user) {
        super(isSuccess, error);
        this.user = user;
    }

    public PlayerObject getUser() {
        return user;
    }

    public void setUser(PlayerObject user) {
        this.user = user;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "user=" + user +
                ", success=" + success +
                ", error=" + error +
                '}';
    }
}
