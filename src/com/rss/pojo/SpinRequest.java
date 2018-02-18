package com.rss.pojo;

public class SpinRequest
{

    private String gameConfigId;
    private String playerId;
    private float betAmount;
    private float playLines;

    public SpinRequest() {
    }

    public SpinRequest(String gameConfigId, String playerId, float betAmount, float playLines) {
        this.gameConfigId = gameConfigId;
        this.playerId = playerId;
        this.betAmount = betAmount;
        this.playLines = playLines;
    }

    public String getGameConfigId() {
        return gameConfigId;
    }

    public void setGameConfigId(String gameConfigId) {
        this.gameConfigId = gameConfigId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public float getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(float betAmount) {
        this.betAmount = betAmount;
    }

    public float getPlayLines() {
        return playLines;
    }

    public void setPlayLines(float playLines) {
        this.playLines = playLines;
    }

    @Override
    public String toString() {
        return "SpinRequest{" +
                "gameConfigId='" + gameConfigId + '\'' +
                ", playerId='" + playerId + '\'' +
                ", betAmount=" + betAmount +
                ", playLines=" + playLines +
                '}';
    }
}
