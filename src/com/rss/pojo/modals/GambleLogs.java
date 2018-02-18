package com.rss.pojo.modals;

/**

 */
public class GambleLogs {
    private int id;
    private int gameSpinId;
    private int accountId;
    private String gameId;
    private float betAmount;
    private float wonAmount;
    private String gambleQuestion;
    private String gambleAnswer;
    private String gambleRngResult;

    public GambleLogs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameSpinId() {
        return gameSpinId;
    }

    public void setGameSpinId(int gameSpinId) {
        this.gameSpinId = gameSpinId;
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

    public float getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(float betAmount) {
        this.betAmount = betAmount;
    }

    public float getWonAmount() {
        return wonAmount;
    }

    public void setWonAmount(float wonAmount) {
        this.wonAmount = wonAmount;
    }

    public String getGambleQuestion() {
        return gambleQuestion;
    }

    public void setGambleQuestion(String gambleQuestion) {
        this.gambleQuestion = gambleQuestion;
    }

    public String getGambleAnswer() {
        return gambleAnswer;
    }

    public void setGambleAnswer(String gambleAnswer) {
        this.gambleAnswer = gambleAnswer;
    }

    public String getGambleRngResult() {
        return gambleRngResult;
    }

    public void setGambleRngResult(String gambleRngResult) {
        this.gambleRngResult = gambleRngResult;
    }

    @Override
    public String toString() {
        return "GambleLogs{" +
                "id=" + id +
                ", gameSpinId=" + gameSpinId +
                ", accountId=" + accountId +
                ", gameId='" + gameId + '\'' +
                ", betAmount=" + betAmount +
                ", wonAmount=" + wonAmount +
                ", gambleQuestion='" + gambleQuestion + '\'' +
                ", gambleAnswer='" + gambleAnswer + '\'' +
                ", gambleRngResult='" + gambleRngResult + '\'' +
                '}';
    }
}
