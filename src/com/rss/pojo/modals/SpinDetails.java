package com.rss.pojo.modals;

import java.util.Date;

public class SpinDetails {
    private int logId;
    private int accountId;
    private int configId;
    private int denomination;
    private int numberOfCoins;
    private int betLines;
    private String outcome;
    private String elementMatrix;
    private String winningLiines;
    private float amountWon;
    private Date timeStamp;
    private int pjpId;
    private float pjpAmount;
    private int amountType;
    private int spinType;
    private int pjpWinStatus;
    private float pjpWinAmount;
    private int status;
    private String currency;

    public SpinDetails() {
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    public int getBetLines() {
        return betLines;
    }

    public void setBetLines(int betLines) {
        this.betLines = betLines;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getElementMatrix() {
        return elementMatrix;
    }

    public void setElementMatrix(String elementMatrix) {
        this.elementMatrix = elementMatrix;
    }

    public String getWinningLiines() {
        return winningLiines;
    }

    public void setWinningLiines(String winningLiines) {
        this.winningLiines = winningLiines;
    }

    public float getAmountWon() {
        return amountWon;
    }

    public void setAmountWon(float amountWon) {
        this.amountWon = amountWon;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getPjpId() {
        return pjpId;
    }

    public void setPjpId(int pjpId) {
        this.pjpId = pjpId;
    }

    public float getPjpAmount() {
        return pjpAmount;
    }

    public void setPjpAmount(float pjpAmount) {
        this.pjpAmount = pjpAmount;
    }

    public int getAmountType() {
        return amountType;
    }

    public void setAmountType(int amountType) {
        this.amountType = amountType;
    }

    public int getSpinType() {
        return spinType;
    }

    public void setSpinType(int spinType) {
        this.spinType = spinType;
    }

    public int getPjpWinStatus() {
        return pjpWinStatus;
    }

    public void setPjpWinStatus(int pjpWinStatus) {
        this.pjpWinStatus = pjpWinStatus;
    }

    public float getPjpWinAmount() {
        return pjpWinAmount;
    }

    public void setPjpWinAmount(float pjpWinAmount) {
        this.pjpWinAmount = pjpWinAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "SpinDetails{" +
                "logId=" + logId +
                ", accountId=" + accountId +
                ", configId=" + configId +
                ", denomination=" + denomination +
                ", numberOfCoins=" + numberOfCoins +
                ", betLines=" + betLines +
                ", outcome='" + outcome + '\'' +
                ", elementMatrix='" + elementMatrix + '\'' +
                ", winningLiines='" + winningLiines + '\'' +
                ", amountWon=" + amountWon +
                ", timeStamp=" + timeStamp +
                ", pjpId=" + pjpId +
                ", pjpAmount=" + pjpAmount +
                ", amountType=" + amountType +
                ", spinType=" + spinType +
                ", pjpWinStatus=" + pjpWinStatus +
                ", pjpWinAmount=" + pjpWinAmount +
                ", status=" + status +
                ", currency='" + currency + '\'' +
                '}';
    }
}

