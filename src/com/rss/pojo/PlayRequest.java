package com.rss.pojo;

public class PlayRequest
{
    private String sid;
    private String game;

    public PlayRequest() {
    }

    public PlayRequest(String sid, String game) {
        this.sid = sid;
        this.game = game;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "PlayRequest{" +
                "sid='" + sid + '\'' +
                ", game='" + game + '\'' +
                '}';
    }
}

