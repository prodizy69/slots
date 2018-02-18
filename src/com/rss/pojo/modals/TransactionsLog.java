package com.rss.pojo.modals;

import org.codehaus.jackson.map.util.JSONPObject;

import java.util.Date;

public class TransactionsLog {
    private int serialId;
    private int accountId;
    private String gameType;
    private int gameId;
    private Date dateTime;
    private float amount;
    private String streamId;
    private int transType;
    private int amountType;
    private JSONPObject note;
    private int parentId;
    private String trackId;
    private int systemId;
    private int miscId;
    private String currency;
    private int processed;
    private int error;
    private float realSub;
    private float bonusSub;

    public TransactionsLog() {
    }

    public int getSerialId() {
        return serialId;
    }

    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public int getTransType() {
        return transType;
    }

    public void setTransType(int transType) {
        this.transType = transType;
    }

    public int getAmountType() {
        return amountType;
    }

    public void setAmountType(int amountType) {
        this.amountType = amountType;
    }

    public JSONPObject getNote() {
        return note;
    }

    public void setNote(JSONPObject note) {
        this.note = note;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public int getMiscId() {
        return miscId;
    }

    public void setMiscId(int miscId) {
        this.miscId = miscId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getProcessed() {
        return processed;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public float getRealSub() {
        return realSub;
    }

    public void setRealSub(float realSub) {
        this.realSub = realSub;
    }

    public float getBonusSub() {
        return bonusSub;
    }

    public void setBonusSub(float bonusSub) {
        this.bonusSub = bonusSub;
    }

    @Override
    public String toString() {
        return "TransactionsLog{" +
                "serialId=" + serialId +
                ", accountId=" + accountId +
                ", gameType='" + gameType + '\'' +
                ", gameId=" + gameId +
                ", dateTime=" + dateTime +
                ", amount=" + amount +
                ", streamId='" + streamId + '\'' +
                ", transType=" + transType +
                ", amountType=" + amountType +
                ", note=" + note +
                ", parentId=" + parentId +
                ", trackId='" + trackId + '\'' +
                ", systemId=" + systemId +
                ", miscId=" + miscId +
                ", currency='" + currency + '\'' +
                ", processed=" + processed +
                ", error=" + error +
                ", realSub=" + realSub +
                ", bonusSub=" + bonusSub +
                '}';
    }
}
