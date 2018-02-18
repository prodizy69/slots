package com.rss.pojo;

import com.rss.common.ErrorObj;

public class PlayResponse extends BaseResponse {

    private String connectivityString;
    private String gameId;
    public PlayResponse(boolean isSuccess, ErrorObj error) {
        super(isSuccess, error);
    }

    public PlayResponse(boolean success, ErrorObj error, String connectivityString, String gameId) {
        super(success, error);
        this.connectivityString = connectivityString;
        this.gameId = gameId;
    }

    public String getConnectivityString() {
        return connectivityString;
    }

    public void setConnectivityString(String connectivityString) {
        this.connectivityString = connectivityString;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "PlayResponse{" +
                "connectivityString='" + connectivityString + '\'' +
                ", gameId=" + gameId +
                '}';
    }
}
