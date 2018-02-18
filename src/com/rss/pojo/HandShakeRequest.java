package com.rss.pojo;

import com.rss.common.ErrorObj;

public class HandShakeRequest
{

    private String gameConfigId;

    public String getGameConfigId() {
        return gameConfigId;
    }

    public void setGameConfigId(String gameConfigId) {
        this.gameConfigId = gameConfigId;
    }

    public HandShakeRequest() {
    }

    public HandShakeRequest(String gameConfigId) {
        this.gameConfigId = gameConfigId;
    }
}
