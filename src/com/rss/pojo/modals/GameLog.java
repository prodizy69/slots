package com.rss.pojo.modals;

import org.codehaus.jackson.map.util.JSONPObject;

/**

 */
public class GameLog {
    private int spinId;
    private int accountId;
    private String gameId;
    private float denomination;
    private float numberOfCoins;
    private int betLines;
    private boolean triggerGamble;
    private int reelSetIndex;
    private JSONPObject oldWilds;
    private JSONPObject oldWildsFree;
    private String outcome;
    private String elementMatrix;
    private String winningLines;
    private float betPerLine;
    private float totalBetAmount;
    private float totalWinAmount;
    private float lineWinAmount;
    private float freeSpinWinAmount;
    private float scatterWinAmount;
    private String spinType;
    private boolean amountType;

    public GameLog() {
    }

    public int getSpinId() {
        return spinId;
    }

    public void setSpinId(int spinId) {
        this.spinId = spinId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public float getDenomination() {
        return denomination;
    }

    public void setDenomination(float denomination) {
        this.denomination = denomination;
    }

    public float getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(float numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    public int getBetLines() {
        return betLines;
    }

    public void setBetLines(int betLines) {
        this.betLines = betLines;
    }

    public boolean isTriggerGamble() {
        return triggerGamble;
    }

    public void setTriggerGamble(boolean triggerGamble) {
        this.triggerGamble = triggerGamble;
    }

    public int getReelSetIndex() {
        return reelSetIndex;
    }

    public void setReelSetIndex(int reelSetIndex) {
        this.reelSetIndex = reelSetIndex;
    }

    public JSONPObject getOldWilds() {
        return oldWilds;
    }

    public void setOldWilds(JSONPObject oldWilds) {
        this.oldWilds = oldWilds;
    }

    public JSONPObject getOldWildsFree() {
        return oldWildsFree;
    }

    public void setOldWildsFree(JSONPObject oldWildsFree) {
        this.oldWildsFree = oldWildsFree;
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

    public float getBetPerLine() {
        return betPerLine;
    }

    public void setBetPerLine(float betPerLine) {
        this.betPerLine = betPerLine;
    }

    public float getTotalBetAmount() {
        return totalBetAmount;
    }

    public void setTotalBetAmount(float totalBetAmount) {
        this.totalBetAmount = totalBetAmount;
    }

    public float getTotalWinAmount() {
        return totalWinAmount;
    }

    public void setTotalWinAmount(float totalWinAmount) {
        this.totalWinAmount = totalWinAmount;
    }

    public float getLineWinAmount() {
        return lineWinAmount;
    }

    public void setLineWinAmount(float lineWinAmount) {
        this.lineWinAmount = lineWinAmount;
    }

    public float getFreeSpinWinAmount() {
        return freeSpinWinAmount;
    }

    public void setFreeSpinWinAmount(float freeSpinWinAmount) {
        this.freeSpinWinAmount = freeSpinWinAmount;
    }

    public float getScatterWinAmount() {
        return scatterWinAmount;
    }

    public void setScatterWinAmount(float scatterWinAmount) {
        this.scatterWinAmount = scatterWinAmount;
    }

    public String getSpinType() {
        return spinType;
    }

    public void setSpinType(String spinType) {
        this.spinType = spinType;
    }

    public boolean isAmountType() {
        return amountType;
    }

    public void setAmountType(boolean amountType) {
        this.amountType = amountType;
    }

    @Override
    public String toString() {
        return "GameLog{" +
                "spinId=" + spinId +
                ", accountId=" + accountId +
                ", gameId='" + gameId + '\'' +
                ", denomination=" + denomination +
                ", numberOfCoins=" + numberOfCoins +
                ", betLines=" + betLines +
                ", triggerGamble=" + triggerGamble +
                ", reelSetIndex=" + reelSetIndex +
                ", oldWilds=" + oldWilds +
                ", oldWildsFree=" + oldWildsFree +
                ", outcome='" + outcome + '\'' +
                ", elementMatrix='" + elementMatrix + '\'' +
                ", winningLines='" + winningLines + '\'' +
                ", betPerLine=" + betPerLine +
                ", totalBetAmount=" + totalBetAmount +
                ", totalWinAmount=" + totalWinAmount +
                ", lineWinAmount=" + lineWinAmount +
                ", freeSpinWinAmount=" + freeSpinWinAmount +
                ", scatterWinAmount=" + scatterWinAmount +
                ", spinType='" + spinType + '\'' +
                ", amountType=" + amountType +
                '}';
    }
}
