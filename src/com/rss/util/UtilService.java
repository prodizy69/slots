package com.rss.util;

import com.rss.common.Constants;
import com.rss.pojo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UtilService {
    private Map<String,SymbolObj> allSymbols = null;
    private Map<String,ArrayList<String>> wildVsRegular = null;
    private GameConfig gameConfig;
    private Map<String,SymbolObj> allWilds = null;
    private Map<String,SymbolObj> allSpecialWilds = null;
    private PlayLines alwaysSlotsPayLines;

    public UtilService(GameConfig gameConfig) {
        this.gameConfig=gameConfig;
        this.allSymbols = this.convertSymbolVsObject();
        this.wildVsRegular = this.getWildVsRegularMap();
        this.allWilds = this.getAllWilds();
        this.allSpecialWilds = this.getSpecialWilds();
        //if(alwaysSlotsPayLines != null) {
            //this.alwaysSlotsPayLines = alwaysSlotsPayLines.play_lines;
        //}
        this.alwaysSlotsPayLines = gameConfig.getAlwaysSlotsPayLines();
    }

    public Map<String,SymbolObj> getAllSymbols(){
        return this.allSymbols;
    }

    public String[] getAllRegulars(String[] payLine){
        ArrayList<String> regulars = new ArrayList<>();
        for(String symbol:payLine){
            if(!(regulars.indexOf(symbol) > -1)) {
                if (this.isGivenType(symbol, Constants.REGULAR)) {
                    if (!(regulars.indexOf(symbol) > -1)) {
                        regulars.add(symbol);
                    }
                }
            }
        }
        return (String[])regulars.toArray(new String[regulars.size()]);
    }

    public boolean isGivenType(String symbol,String type){
        symbol=symbol.toLowerCase();
        SymbolObj symbolObj = this.allSymbols.get(symbol);
        if(symbolObj != null) {
            if (symbolObj.getSymbolType().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }
    public Map<String,SymbolObj> getAllWilds(){
        if(this.allWilds != null){
            return this.allWilds;
        }
        this.allWilds = new HashMap<String,SymbolObj>();
        for(Map.Entry<String,SymbolObj> entry: allSymbols.entrySet()){
            String symbol = entry.getKey().toLowerCase();
            if(this.isGivenType(symbol,Constants.WILD)){
                this.allWilds.put(symbol,allSymbols.get(symbol));
            }
        }
        return this.allWilds;
    }

    public Map<String,SymbolObj> getSpecialWilds(){
        if(this.allSpecialWilds != null){
            return this.allSpecialWilds;
        }
        this.allSpecialWilds = new HashMap<String,SymbolObj>();
        Map<String,SymbolObj> wilds = this.getAllWilds();

        for(Map.Entry<String,SymbolObj> entry: wilds.entrySet()){
            String symbol = entry.getKey().toLowerCase();
            SymbolObj wildObj = entry.getValue();
            if(wildObj.getCommonPayConfig() != null) {
                String specialType = wildObj.getCommonPayConfig().getSpecialWildType();
                if (!specialType.equalsIgnoreCase(Constants.WILD_TYPE_SPECIAL_NONE)) {
                    this.allSpecialWilds.put(symbol,wildObj);
                }
            }
        }
        return this.allSpecialWilds;
    }

    public Map<Integer,ArrayList<SpecialWildObj>> getSpecialWildsFromRNGOutPut(String[][] rngOutPut){
        Map<Integer,ArrayList<SpecialWildObj>> specialWilds = new HashMap<>();
        Map<String,SymbolObj> wilds = this.getAllWilds();
        int rowNumber=0;
        for(String[] rowRecord : rngOutPut){
            int columnNumber=0;
            for(String symbol : rowRecord){
                symbol=symbol.toLowerCase();
                SymbolObj wildObj = wilds.get(symbol);
                if(this.isGivenType(symbol,Constants.WILD) && wildObj != null && wildObj.getCommonPayConfig() != null && wildObj.getCommonPayConfig().getSpecialWildType() != null) {
                    String specialType = wildObj.getCommonPayConfig().getSpecialWildType();
                    String specialWildTypeOrder = wildObj.getCommonPayConfig().getSpecialWildTypeOrder();
                    if (!specialType.equalsIgnoreCase(Constants.WILD_TYPE_SPECIAL_NONE)) {
                        int order = Constants.SPECIAL_WILD_ORDER.get(specialType);
                        ArrayList<SpecialWildObj> occurances = specialWilds.get(order);
                        if (occurances == null){
                            occurances = new ArrayList<>();
                        }
                        SpecialWildObj specialWildObj = new SpecialWildObj(
                                rowNumber,columnNumber,wildObj.getCommonPayConfig().getStickySpinCount(),specialType,specialWildTypeOrder,symbol
                        );
                        occurances.add(specialWildObj);
                        specialWilds.put(order,occurances);
                    }
                }
                columnNumber++;
            }
            rowNumber++;
        }
        return specialWilds;
    }

    public Map<String,ArrayList<String>> getWildVsRegularMap(){
        if(wildVsRegular != null){
            return wildVsRegular;
        }
        wildVsRegular = new HashMap<>();
        for(SymbolObj symbolObj : gameConfig.getSymbol_paytable()){
            if(symbolObj.getSymbolType().equalsIgnoreCase(Constants.WILD)){
                ArrayList<String> regularsArray = new ArrayList<>();
                if(symbolObj.getCommonPayConfig() != null && symbolObj.getCommonPayConfig().getSubstituteSymbolAliasMap() != null) {
                    Map<String,Boolean> symbolVsRegularMap = symbolObj.getCommonPayConfig().getSubstituteSymbolAliasMap();
                    for(Map.Entry<String,Boolean> entry : symbolVsRegularMap.entrySet()){
                        if(entry.getValue() != null && entry.getValue()){
                            regularsArray.add(entry.getKey().toLowerCase());
                        }
                    }
                }
                wildVsRegular.put(symbolObj.getSymbolAlias().toLowerCase(),regularsArray);
            }
        }
        return wildVsRegular;
    }

    public Map<String,SymbolObj> convertSymbolVsObject(){
        Map<String,SymbolObj> symbolVsObject = new HashMap<>();
        for(SymbolObj symbolObj : gameConfig.getSymbol_paytable()){
            symbolVsObject.put(symbolObj.getSymbolAlias().toLowerCase(),symbolObj);
        }
        return symbolVsObject;
    }

    public String getSymbolType(String syboml){
        if(this.isGivenType(syboml,Constants.REGULAR)){
            return Constants.REGULAR;
        }else if(this.isGivenType(syboml,Constants.WILD)){
            return Constants.WILD;
        }else if(this.isGivenType(syboml,Constants.SCATTER)){
            return Constants.SCATTER;
        }
        return null;
    }

    public DoublyLinkedListImpl<NodeObject> convertToLinkedList(String[] line){
        DoublyLinkedListImpl<NodeObject> pay_line = new DoublyLinkedListImpl();
        for(String item:line){
            NodeObject object= new NodeObject();
            object.setValue(item);
            if(this.isGivenType(item,Constants.WILD)){
                object.setWild(item);
            }
            pay_line.addLast(object);
        }
        return pay_line;

    }

    public ArrayList<String> stringifyPayline(DoublyLinkedListImpl payline,boolean combinationType,ArrayList<String> combinations){
        ArrayList<NodeObject> arrayObj = new ArrayList<>();
        String array_str = "";
        DoublyLinkedListImpl.Node node = combinationType ? payline.getHead() : payline.getTail();
        while(node != null){
            arrayObj.add((NodeObject) node.getElement());
            node = combinationType ? node.next : node.prev;
        }
        for(NodeObject obj : arrayObj){
            String tmp="";
            if(obj.getValue() != null){
                tmp = tmp + obj.getValue();
                if(obj.getWild() != null){
                    tmp = tmp + ":" + obj.getWild();
                }
            }
            array_str=array_str + tmp + ";";
        }
        if(!(combinations.contains(array_str))){
            combinations.add(array_str);
        }
        return combinations;
    }

    public ArrayList<String> stringifyArrayPayLine(ArrayList<NodeObject> arrayObj,ArrayList<String> combinations){
        String array_str = "";
        for(NodeObject obj : arrayObj){
            String tmp="";
            if(obj.getValue() != null){
                tmp = tmp + obj.getValue();
                if(obj.getWild() != null){
                    tmp = tmp + ":" + obj.getWild();
                }
            }
            array_str=array_str + tmp + ";";
            //array_str=array_str + obj.toString() + ";";
        }
        if(!(combinations.contains(array_str))){
            combinations.add(array_str);
        }
        return combinations;
    }
    public float getSymbolMultiplerForGivenOfAKind(String symbol,int ofAKind){
        OfAKindObj object = this.getSymbolOfAkindObject(symbol,ofAKind);
        if(object != null) {
            try {
                return object.getLineBetMultiplierValue();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return 0;
    }

    public OfAKindObj getSymbolOfAkindObject(String symbol,int ofAKind){
        symbol=symbol.toLowerCase();
        SymbolObj symbolObj = allSymbols.get(symbol);
        if(symbolObj != null) {
            try {
                OfAKindObj[] ofAKindConfig = symbolObj.getOfAKindPayConfigArray();
                return ofAKindConfig[(ofAKind - 1)];
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public float getWildMultipler(String symbol){
        symbol=symbol.toLowerCase();
        SymbolObj symbolObj = this.allSymbols.get(symbol);
        if(symbolObj != null) {
            if(this.isGivenType(symbol,Constants.WILD) && symbolObj.getCommonPayConfig() != null){
                Float wildMultipler = symbolObj.getCommonPayConfig().getWildSubstitutionMultiplierValue();
                if(wildMultipler != null){
                    return wildMultipler;
                }
            }
        }
        return 0;
    }

    public MaxWild getWildHavingMaxMultiplier(String[] wilds){
        String maxWildSymbol = null;
        float maxWildMultiplier = 0;
        for(String symbol:wilds){
            float wildMultipler = this.getWildMultipler(symbol);
            if(wildMultipler >= maxWildMultiplier){
                maxWildMultiplier = wildMultipler;
                maxWildSymbol = symbol;
            }
        }
        return new MaxWild(maxWildSymbol,maxWildMultiplier);
    }

    public int getReelSetIndex(String reelSetName){
        int index=0;
        for(ReelSet reelSetData: gameConfig.getReel_set_config_array()){
            if(reelSetData.getReelSetName().equalsIgnoreCase(reelSetName)) {
                return index;
            }
            index++;
        }
        return index;
    }

    public Object getSelectedPlaylines(int selectedCount){
        int[][][] payLinesToConsider = (
                this.alwaysSlotsPayLines != null && this.alwaysSlotsPayLines.getWindowMatrix_Array() != null && this.alwaysSlotsPayLines.getWindowMatrix_Array().length > 0)
                ? this.alwaysSlotsPayLines.getWindowMatrix_Array() : this.gameConfig.getPlay_lines().getWindowMatrix_Array();
        if(selectedCount != 0 && selectedCount < payLinesToConsider.length){
            return Arrays.copyOfRange(payLinesToConsider, 0, selectedCount);
        }
        return payLinesToConsider;
    }

    public void setAllSymbols(Map<String, SymbolObj> allSymbols) {
        this.allSymbols = allSymbols;
    }

    public Map<String, ArrayList<String>> getWildVsRegular() {
        return wildVsRegular;
    }

    public void setWildVsRegular(Map<String, ArrayList<String>> wildVsRegular) {
        this.wildVsRegular = wildVsRegular;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void setAllWilds(Map<String, SymbolObj> allWilds) {
        this.allWilds = allWilds;
    }

    public Map<String, SymbolObj> getAllSpecialWilds() {
        return allSpecialWilds;
    }

    public void setAllSpecialWilds(Map<String, SymbolObj> allSpecialWilds) {
        this.allSpecialWilds = allSpecialWilds;
    }

    public PlayLines getAlwaysSlotsPayLines() {
        return alwaysSlotsPayLines;
    }

    public void setAlwaysSlotsPayLines(PlayLines alwaysSlotsPayLines) {
        this.alwaysSlotsPayLines = alwaysSlotsPayLines;
    }
}
