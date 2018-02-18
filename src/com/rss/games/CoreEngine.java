package com.rss.games;


import com.rss.common.*;
import java.security.SecureRandom;
import java.util.*;

public class CoreEngine {

    private String uuid;
    private Random random = new SecureRandom();

    private GameConfiguration gameConfiguration;

    public CoreEngine(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
        this.uuid = UUID.randomUUID().toString();
    }



    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    @Override
    public String toString() {
        return "CoreEngine{" +
                ", random=" + random +
                ", gameConfiguration=" + gameConfiguration +
                '}';
    }
}
