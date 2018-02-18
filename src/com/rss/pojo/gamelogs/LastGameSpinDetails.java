package com.rss.pojo.gamelogs;

import java.util.Date;

/**

 */
public class LastGameSpinDetails {

    private int logid;
    private int accountId;
    private int configId;
    private int denomination;
    private int noofcoins;
    private int betlines;
    private String outcome;
    private String elementMatrix;
    private String winningLines;
    private float amountWon;
    private Date timeStamp;
    private int pjpId;
    private float pjpAmount;
    private int amountType;
    private int spinType;
    private int pjpWinStatus;
    private float pjpWinAmount;

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
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

    public int getNoofcoins() {
        return noofcoins;
    }

    public void setNoofcoins(int noofcoins) {
        this.noofcoins = noofcoins;
    }

    public int getBetlines() {
        return betlines;
    }

    public void setBetlines(int betlines) {
        this.betlines = betlines;
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

    public String getWinningLines() {
        return winningLines;
    }

    public void setWinningLines(String winningLines) {
        this.winningLines = winningLines;
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

    public LastGameSpinDetails() {
    }

    @Override
    public String toString() {
        return "LastGameSpinDetails{" +
                "logid=" + logid +
                ", accountId=" + accountId +
                ", configId=" + configId +
                ", denomination=" + denomination +
                ", noofcoins=" + noofcoins +
                ", betlines=" + betlines +
                ", outcome='" + outcome + '\'' +
                ", elementMatrix='" + elementMatrix + '\'' +
                ", winningLines='" + winningLines + '\'' +
                ", amountWon=" + amountWon +
                ", timeStamp=" + timeStamp +
                ", pjpId=" + pjpId +
                ", pjpAmount=" + pjpAmount +
                ", amountType=" + amountType +
                ", spinType=" + spinType +
                ", pjpWinStatus=" + pjpWinStatus +
                ", pjpWinAmount=" + pjpWinAmount +
                '}';
    }
}
