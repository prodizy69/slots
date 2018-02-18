package com.rss.pojo;

import java.util.ArrayList;
import java.util.Map;

public class SubstitutionResponse {
    private String[][] beforeSubstitution;
    private String[][] rng;
    private Map<Integer,ArrayList<SpecialWildObj>> oldWilds;

    public SubstitutionResponse() {
    }

    public SubstitutionResponse(String[][] beforeSubstitution, String[][] rng, Map<Integer, ArrayList<SpecialWildObj>> oldWilds) {
        this.beforeSubstitution = beforeSubstitution;
        this.rng = rng;
        this.oldWilds = oldWilds;
    }

    public String[][] getBeforeSubstitution() {
        return beforeSubstitution;
    }

    public void setBeforeSubstitution(String[][] beforeSubstitution) {
        this.beforeSubstitution = beforeSubstitution;
    }

    public String[][] getRng() {
        return rng;
    }

    public void setRng(String[][] rng) {
        this.rng = rng;
    }

    public Map<Integer, ArrayList<SpecialWildObj>> getOldWilds() {
        return oldWilds;
    }

    public void setOldWilds(Map<Integer, ArrayList<SpecialWildObj>> oldWilds) {
        this.oldWilds = oldWilds;
    }
}
