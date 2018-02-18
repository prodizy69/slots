package com.rss.pojo.modals;

import org.codehaus.jackson.map.util.JSONPObject;

public class Producers {
    private String id;
    private JSONPObject forgotPasswordCode;
    private String uid;
    private String companyName;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private char password;
    private JSONPObject associatedGameConfigs;
    private JSONPObject customData;
    private JSONPObject sessionInfo;
    private int revision;
    private String role;

    public Producers() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JSONPObject getForgotPasswordCode() {
        return forgotPasswordCode;
    }

    public void setForgotPasswordCode(JSONPObject forgotPasswordCode) {
        this.forgotPasswordCode = forgotPasswordCode;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public char getPassword() {
        return password;
    }

    public void setPassword(char password) {
        this.password = password;
    }

    public JSONPObject getAssociatedGameConfigs() {
        return associatedGameConfigs;
    }

    public void setAssociatedGameConfigs(JSONPObject associatedGameConfigs) {
        this.associatedGameConfigs = associatedGameConfigs;
    }

    public JSONPObject getCustomData() {
        return customData;
    }

    public void setCustomData(JSONPObject customData) {
        this.customData = customData;
    }

    public JSONPObject getSessionInfo() {
        return sessionInfo;
    }

    public void setSessionInfo(JSONPObject sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Producers{" +
                "id='" + id + '\'' +
                ", forgotPasswordCode=" + forgotPasswordCode +
                ", uid='" + uid + '\'' +
                ", companyName='" + companyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password=" + password +
                ", associatedGameConfigs=" + associatedGameConfigs +
                ", customData=" + customData +
                ", sessionInfo=" + sessionInfo +
                ", revision=" + revision +
                ", role='" + role + '\'' +
                '}';
    }
}
