package com.rss.pojo;

import com.rss.common.ErrorObj;

public class HandShakeResponse extends BaseResponse
{

    private GameConfig gameConfig;

    public HandShakeResponse(boolean success, ErrorObj error, GameConfig gameConfig) {
        super(success, error);
        this.gameConfig = gameConfig;
    }

    public HandShakeResponse(boolean isSuccess, ErrorObj error) {
        super(isSuccess, error);
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    @Override
    public String toString() {
        return "HandShakeResponse{" +
                "gameConfig=" + gameConfig +
                '}';
    }
}
