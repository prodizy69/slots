package com.rss.pojo.modals;

import java.util.Date;

/**

 */
public class BonusGamesLogs {
    private int id;
    private String gameId;
    private int accountId;
    private int totalClicks;
    private int userClicks;
    private String source;
    private int state;
    private String position;
    private String prizeAmount;
    private float multiplier;
    private float winAmount;
    private Date expiryDate;

    public BonusGamesLogs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(int totalClicks) {
        this.totalClicks = totalClicks;
    }

    public int getUserClicks() {
        return userClicks;
    }

    public void setUserClicks(int userClicks) {
        this.userClicks = userClicks;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(String prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    public float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(float winAmount) {
        this.winAmount = winAmount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "BonusGamesLogs{" +
                "id=" + id +
                ", gameId='" + gameId + '\'' +
                ", accountId=" + accountId +
                ", totalClicks=" + totalClicks +
                ", userClicks=" + userClicks +
                ", source='" + source + '\'' +
                ", state=" + state +
                ", position='" + position + '\'' +
                ", prizeAmount='" + prizeAmount + '\'' +
                ", multiplier=" + multiplier +
                ", winAmount=" + winAmount +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
