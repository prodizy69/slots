package com.rss.pojo;

import java.util.Map;

public class PayConfig {
    private String specialWildType;
    private String specialWildTypeOrder;
    private int stickySpinCount;
    private float wildSubstitutionMultiplierValue;
    private Map<String,Boolean> substituteSymbolAliasMap;

    public PayConfig() {
    }

    public PayConfig(Map<String, Boolean> substituteSymbolAliasMap) {
        this.substituteSymbolAliasMap = substituteSymbolAliasMap;
    }

    public String getSpecialWildType() {
        return specialWildType;
    }

    public void setSpecialWildType(String specialWildType) {
        this.specialWildType = specialWildType;
    }

    public String getSpecialWildTypeOrder() {
        return specialWildTypeOrder;
    }

    public void setSpecialWildTypeOrder(String specialWildTypeOrder) {
        this.specialWildTypeOrder = specialWildTypeOrder;
    }

    public int getStickySpinCount() {
        return stickySpinCount;
    }

    public void setStickySpinCount(int stickySpinCount) {
        this.stickySpinCount = stickySpinCount;
    }

    public Map<String, Boolean> getSubstituteSymbolAliasMap() {
        return substituteSymbolAliasMap;
    }

    public void setSubstituteSymbolAliasMap(Map<String, Boolean> substituteSymbolAliasMap) {
        this.substituteSymbolAliasMap = substituteSymbolAliasMap;
    }

    public float getWildSubstitutionMultiplierValue() {
        return wildSubstitutionMultiplierValue;
    }

    public void setWildSubstitutionMultiplierValue(float wildSubstitutionMultiplierValue) {
        this.wildSubstitutionMultiplierValue = wildSubstitutionMultiplierValue;
    }
}
