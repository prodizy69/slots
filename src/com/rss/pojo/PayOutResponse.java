package com.rss.pojo;

import java.util.ArrayList;
import java.util.Map;

public class PayOutResponse {
    private float payOut;
    private ArrayList<FreeSpinObj> freeSpins;
    private ArrayList<String> bonusGames;
    private ArrayList<SymbolOccurance> scatterOccurances;

    private String[][] rng;
    private String[][] beforeSubstitution;
    private Map<Integer, ArrayList<SpecialWildObj>> oldWildsFree;
    private Map<Integer, ArrayList<SpecialWildObj>> oldWilds;
    private String[][] rngOutPut;
    private int reel_set_index;
    private String spin_type;
    private boolean triggerGamble;

    private ArrayList<PayOutObject> payOutObject;
    private PayOutObject totalPayOutObj;

    public PayOutResponse() {
    }

    public PayOutResponse(float payOut, ArrayList<FreeSpinObj> freeSpins, ArrayList<String> bonusGames, ArrayList<SymbolOccurance> scatterOccurances) {
        this.payOut = payOut;
        this.freeSpins = freeSpins;
        this.bonusGames = bonusGames;
        this.scatterOccurances = scatterOccurances;
    }

    public String[][] getRng() {
        return rng;
    }

    public void setRng(String[][] rng) {
        this.rng = rng;
    }

    public String[][] getBeforeSubstitution() {
        return beforeSubstitution;
    }

    public void setBeforeSubstitution(String[][] beforeSubstitution) {
        this.beforeSubstitution = beforeSubstitution;
    }

    public Map<Integer, ArrayList<SpecialWildObj>> getOldWildsFree() {
        return oldWildsFree;
    }

    public void setOldWildsFree(Map<Integer, ArrayList<SpecialWildObj>> oldWildsFree) {
        this.oldWildsFree = oldWildsFree;
    }

    public Map<Integer, ArrayList<SpecialWildObj>> getOldWilds() {
        return oldWilds;
    }

    public void setOldWilds(Map<Integer, ArrayList<SpecialWildObj>> oldWilds) {
        this.oldWilds = oldWilds;
    }

    public String[][] getRngOutPut() {
        return rngOutPut;
    }

    public void setRngOutPut(String[][] rngOutPut) {
        this.rngOutPut = rngOutPut;
    }

    public int getReel_set_index() {
        return reel_set_index;
    }

    public void setReel_set_index(int reel_set_index) {
        this.reel_set_index = reel_set_index;
    }

    public String getSpin_type() {
        return spin_type;
    }

    public void setSpin_type(String spin_type) {
        this.spin_type = spin_type;
    }

    public boolean isTriggerGamble() {
        return triggerGamble;
    }

    public void setTriggerGamble(boolean triggerGamble) {
        this.triggerGamble = triggerGamble;
    }

    public ArrayList<PayOutObject> getPayOutObject() {
        return payOutObject;
    }

    public void setPayOutObject(ArrayList<PayOutObject> payOutObject) {
        this.payOutObject = payOutObject;
    }

    public PayOutObject getTotalPayOutObj() {
        return totalPayOutObj;
    }

    public void setTotalPayOutObj(PayOutObject totalPayOutObj) {
        this.totalPayOutObj = totalPayOutObj;
    }

    public float getPayOut() {
        return payOut;
    }

    public void setPayOut(float payOut) {
        this.payOut = payOut;
    }

    public ArrayList<FreeSpinObj> getFreeSpins() {
        return freeSpins;
    }

    public void setFreeSpins(ArrayList<FreeSpinObj> freeSpins) {
        this.freeSpins = freeSpins;
    }

    public ArrayList<String> getBonusGames() {
        return bonusGames;
    }

    public void setBonusGames(ArrayList<String> bonusGames) {
        this.bonusGames = bonusGames;
    }

    public ArrayList<SymbolOccurance> getScatterOccurances() {
        return scatterOccurances;
    }

    public void setScatterOccurances(ArrayList<SymbolOccurance> scatterOccurances) {
        this.scatterOccurances = scatterOccurances;
    }
}
