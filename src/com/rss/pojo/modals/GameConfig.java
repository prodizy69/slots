package com.rss.pojo.modals;

import org.codehaus.jackson.map.util.JSONPObject;

/**

 */
public class GameConfig {
    private int id;
    private String producerId;
    private String name;
    private String gameOrder;
    private String state;
    private JSONPObject stateComments;
    private int coinsMax;
    private JSONPObject maxWindow;
    private JSONPObject playWindow;
    private JSONPObject playLines;
    private JSONPObject symbolPaytable;
    private JSONPObject symbolPaytableCommon;
    private JSONPObject paylinesPaytable;
    private JSONPObject patternPaytable;
    private JSONPObject paytableCommonRules;
    private JSONPObject reelSetConfigArray;
    private JSONPObject currenciesAndDenominations;
    private JSONPObject foConfig;
    private JSONPObject fgConfig;
    private boolean gambleEnabled;
    private boolean disabled;
    private int revision;
    private boolean logoUploaded;
    private boolean payOnce;

    public GameConfig() {
    }

    public GameConfig(int id, String producerId, String name, String gameOrder, String state, JSONPObject stateComments, int coinsMax, JSONPObject maxWindow, JSONPObject playWindow, JSONPObject playLines, JSONPObject symbolPaytable, JSONPObject symbolPaytableCommon, JSONPObject paylinesPaytable, JSONPObject patternPaytable, JSONPObject paytableCommonRules, JSONPObject reelSetConfigArray, JSONPObject currenciesAndDenominations, JSONPObject foConfig, JSONPObject fgConfig, boolean gambleEnabled, boolean disabled, int revision, boolean logoUploaded, boolean payOnce) {
        this.id = id;
        this.producerId = producerId;
        this.name = name;
        this.gameOrder = gameOrder;
        this.state = state;
        this.stateComments = stateComments;
        this.coinsMax = coinsMax;
        this.maxWindow = maxWindow;
        this.playWindow = playWindow;
        this.playLines = playLines;
        this.symbolPaytable = symbolPaytable;
        this.symbolPaytableCommon = symbolPaytableCommon;
        this.paylinesPaytable = paylinesPaytable;
        this.patternPaytable = patternPaytable;
        this.paytableCommonRules = paytableCommonRules;
        this.reelSetConfigArray = reelSetConfigArray;
        this.currenciesAndDenominations = currenciesAndDenominations;
        this.foConfig = foConfig;
        this.fgConfig = fgConfig;
        this.gambleEnabled = gambleEnabled;
        this.disabled = disabled;
        this.revision = revision;
        this.logoUploaded = logoUploaded;
        this.payOnce = payOnce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameOrder() {
        return gameOrder;
    }

    public void setGameOrder(String gameOrder) {
        this.gameOrder = gameOrder;
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

    public int getCoinsMax() {
        return coinsMax;
    }

    public void setCoinsMax(int coinsMax) {
        this.coinsMax = coinsMax;
    }

    public JSONPObject getMaxWindow() {
        return maxWindow;
    }

    public void setMaxWindow(JSONPObject maxWindow) {
        this.maxWindow = maxWindow;
    }

    public JSONPObject getPlayWindow() {
        return playWindow;
    }

    public void setPlayWindow(JSONPObject playWindow) {
        this.playWindow = playWindow;
    }

    public JSONPObject getPlayLines() {
        return playLines;
    }

    public void setPlayLines(JSONPObject playLines) {
        this.playLines = playLines;
    }

    public JSONPObject getSymbolPaytable() {
        return symbolPaytable;
    }

    public void setSymbolPaytable(JSONPObject symbolPaytable) {
        this.symbolPaytable = symbolPaytable;
    }

    public JSONPObject getSymbolPaytableCommon() {
        return symbolPaytableCommon;
    }

    public void setSymbolPaytableCommon(JSONPObject symbolPaytableCommon) {
        this.symbolPaytableCommon = symbolPaytableCommon;
    }

    public JSONPObject getPaylinesPaytable() {
        return paylinesPaytable;
    }

    public void setPaylinesPaytable(JSONPObject paylinesPaytable) {
        this.paylinesPaytable = paylinesPaytable;
    }

    public JSONPObject getPatternPaytable() {
        return patternPaytable;
    }

    public void setPatternPaytable(JSONPObject patternPaytable) {
        this.patternPaytable = patternPaytable;
    }

    public JSONPObject getPaytableCommonRules() {
        return paytableCommonRules;
    }

    public void setPaytableCommonRules(JSONPObject paytableCommonRules) {
        this.paytableCommonRules = paytableCommonRules;
    }

    public JSONPObject getReelSetConfigArray() {
        return reelSetConfigArray;
    }

    public void setReelSetConfigArray(JSONPObject reelSetConfigArray) {
        this.reelSetConfigArray = reelSetConfigArray;
    }

    public JSONPObject getCurrenciesAndDenominations() {
        return currenciesAndDenominations;
    }

    public void setCurrenciesAndDenominations(JSONPObject currenciesAndDenominations) {
        this.currenciesAndDenominations = currenciesAndDenominations;
    }

    public JSONPObject getFoConfig() {
        return foConfig;
    }

    public void setFoConfig(JSONPObject foConfig) {
        this.foConfig = foConfig;
    }

    public JSONPObject getFgConfig() {
        return fgConfig;
    }

    public void setFgConfig(JSONPObject fgConfig) {
        this.fgConfig = fgConfig;
    }

    public boolean isGambleEnabled() {
        return gambleEnabled;
    }

    public void setGambleEnabled(boolean gambleEnabled) {
        this.gambleEnabled = gambleEnabled;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public boolean isLogoUploaded() {
        return logoUploaded;
    }

    public void setLogoUploaded(boolean logoUploaded) {
        this.logoUploaded = logoUploaded;
    }

    public boolean isPayOnce() {
        return payOnce;
    }

    public void setPayOnce(boolean payOnce) {
        this.payOnce = payOnce;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "id=" + id +
                ", producerId='" + producerId + '\'' +
                ", name='" + name + '\'' +
                ", gameOrder='" + gameOrder + '\'' +
                ", state='" + state + '\'' +
                ", stateComments=" + stateComments +
                ", coinsMax=" + coinsMax +
                ", maxWindow=" + maxWindow +
                ", playWindow=" + playWindow +
                ", playLines=" + playLines +
                ", symbolPaytable=" + symbolPaytable +
                ", symbolPaytableCommon=" + symbolPaytableCommon +
                ", paylinesPaytable=" + paylinesPaytable +
                ", patternPaytable=" + patternPaytable +
                ", paytableCommonRules=" + paytableCommonRules +
                ", reelSetConfigArray=" + reelSetConfigArray +
                ", currenciesAndDenominations=" + currenciesAndDenominations +
                ", foConfig=" + foConfig +
                ", fgConfig=" + fgConfig +
                ", gambleEnabled=" + gambleEnabled +
                ", disabled=" + disabled +
                ", revision=" + revision +
                ", logoUploaded=" + logoUploaded +
                ", payOnce=" + payOnce +
                '}';
    }
}
