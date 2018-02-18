package com.rss.pojo;

public class GambleResponse {
    private float winAmount;
    private String gambleTypeAnswerExpected;

    public String getGambleTypeAnswerExpected() {
        return gambleTypeAnswerExpected;
    }

    public void setGambleTypeAnswerExpected(String gambleTypeAnswerExpected) {
        this.gambleTypeAnswerExpected = gambleTypeAnswerExpected;
    }

    public float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(float winAmount) {
        this.winAmount = winAmount;
    }
}
