package com.rss.services;

import com.rss.exceptions.InvalidSessionException;
import com.rss.pojo.PlayerObject;
import snaq.db.ConnectionPoolManager;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SessionService {
    private Map<String,PlayerObject> sessions = new ConcurrentHashMap<>();
    private Map<Integer,String> userIdVsSession = new ConcurrentHashMap<>();

    private static SessionService instance;

    private SessionService()
    {

    }

    public static SessionService getInstance()
    {
        if (instance == null) {
            instance = new SessionService();
        }
        return instance;
    }

    public String createSession(PlayerObject userObject){
        String sid = UUID.randomUUID().toString().replace("-", "");
        sessions.put(sid,userObject);
        userIdVsSession.put(userObject.getId(),sid);
        return sid;
    }

    public PlayerObject validateSession(String sid) throws InvalidSessionException {
        PlayerObject playerObject = sessions.get(sid);
        if(playerObject == null){
            throw new InvalidSessionException("Session Expired:"+sid);
        }
        return playerObject;
    }

    public String hasSession(int userId){
        return userIdVsSession.get(userId);
    }

    public void doLogOut(String sid){
        PlayerObject playerObject = sessions.remove(sid);
        if(playerObject != null){
            userIdVsSession.remove(playerObject.getId());
        }
    }
}

