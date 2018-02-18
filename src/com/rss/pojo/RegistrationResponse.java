package com.rss.pojo;

import com.rss.common.ErrorObj;

public class RegistrationResponse extends BaseResponse
{
    private PlayerObject user=new PlayerObject();

    public RegistrationResponse(boolean isSuccess, ErrorObj error) {
        super(isSuccess, error);
    }

    public RegistrationResponse(boolean isSuccess, ErrorObj error, PlayerObject user) {
        super(isSuccess, error);
        this.user = user;
    }

    public PlayerObject getUser() {
        return user;
    }

    public void setUser(PlayerObject user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "user=" + user +
                ", success=" + success +
                ", error=" + error +
                '}';
    }
}
