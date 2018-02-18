package com.rss.pojo.modals;

import org.codehaus.jackson.map.util.JSONPObject;

/**

 */
public class Notifications {
    private int id;
    private String firstName;
    private String lastName;
    private String producerId;
    private String requesterProducerId;
    private JSONPObject gameName;
    private String gameId;
    private String state;
    private JSONPObject stateComments;

    public Notifications() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getRequesterProducerId() {
        return requesterProducerId;
    }

    public void setRequesterProducerId(String requesterProducerId) {
        this.requesterProducerId = requesterProducerId;
    }

    public JSONPObject getGameName() {
        return gameName;
    }

    public void setGameName(JSONPObject gameName) {
        this.gameName = gameName;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public JSONPObject getStateComments() {
        return stateComments;
    }

    public void setStateComments(JSONPObject stateComments) {
        this.stateComments = stateComments;
    }

    @Override
    public String toString() {
        return "Notifications{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", producerId='" + producerId + '\'' +
                ", requesterProducerId='" + requesterProducerId + '\'' +
                ", gameName=" + gameName +
                ", gameId='" + gameId + '\'' +
                ", state='" + state + '\'' +
                ", stateComments=" + stateComments +
                '}';
    }
}
