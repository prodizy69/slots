package com.rss.pojo.modals;

/**

 */
public class FreeSpinsLogs {
    private int id;
    private String gameId;
    private int accountId;
    private int numberOfSpins;
    private int numberOfSpinsLeft;
    private float multiplier;
    private String source;
    private int state;
    private float denomination;
    private int numberOfCoins;
    private int betlines;
    private int spinId;
    private float winAmount;
    private String details;
    private String reelsetId;
    private String symbolAlias;
    private int reelSetIndex;

    public FreeSpinsLogs() {
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

    public int getNumberOfSpins() {
        return numberOfSpins;
    }

    public void setNumberOfSpins(int numberOfSpins) {
        this.numberOfSpins = numberOfSpins;
    }

    public int getNumberOfSpinsLeft() {
        return numberOfSpinsLeft;
    }

    public void setNumberOfSpinsLeft(int numberOfSpinsLeft) {
        this.numberOfSpinsLeft = numberOfSpinsLeft;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
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

    public float getDenomination() {
        return denomination;
    }

    public void setDenomination(float denomination) {
        this.denomination = denomination;
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    public int getBetlines() {
        return betlines;
    }

    public void setBetlines(int betlines) {
        this.betlines = betlines;
    }

    public int getSpinId() {
        return spinId;
    }

    public void setSpinId(int spinId) {
        this.spinId = spinId;
    }

    public float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(float winAmount) {
        this.winAmount = winAmount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getReelsetId() {
        return reelsetId;
    }

    public void setReelsetId(String reelsetId) {
        this.reelsetId = reelsetId;
    }

    public String getSymbolAlias() {
        return symbolAlias;
    }

    public void setSymbolAlias(String symbolAlias) {
        this.symbolAlias = symbolAlias;
    }

    public int getReelSetIndex() {
        return reelSetIndex;
    }

    public void setReelSetIndex(int reelSetIndex) {
        this.reelSetIndex = reelSetIndex;
    }

    @Override
    public String toString() {
        return "FreeSpinsLogs{" +
                "id=" + id +
                ", gameId='" + gameId + '\'' +
                ", accountId=" + accountId +
                ", numberOfSpins=" + numberOfSpins +
                ", numberOfSpinsLeft=" + numberOfSpinsLeft +
                ", multiplier=" + multiplier +
                ", source='" + source + '\'' +
                ", state=" + state +
                ", denomination=" + denomination +
                ", numberOfCoins=" + numberOfCoins +
                ", betlines=" + betlines +
                ", spinId=" + spinId +
                ", winAmount=" + winAmount +
                ", details='" + details + '\'' +
                ", reelsetId='" + reelsetId + '\'' +
                ", symbolAlias='" + symbolAlias + '\'' +
                ", reelSetIndex=" + reelSetIndex +
                '}';
    }
}
