package com.rss.games.slots.combinations;

import com.rss.pojo.GameConfig;
import com.rss.pojo.LinePatternObj;
import com.rss.pojo.SymbolOccurance;
import com.rss.util.UtilService;

import javax.rmi.CORBA.Util;
import java.util.*;

public class OrderCombinations {
    private GameConfig gameConfig;
    private UtilService utilService;
    private L2R l2r;
    private AnyWhere anyWhere;
    private Map<String,ArrayList<String>> wildVsRegularMap;
    private SymbolLinePattern symbolLinePattern;

    public OrderCombinations(GameConfig gameConfig, UtilService utilService) {
        this.gameConfig = gameConfig;
        this.utilService = utilService;
        this.l2r = new L2R(utilService);
        this.anyWhere = new AnyWhere(utilService);
        this.wildVsRegularMap = this.utilService.getWildVsRegularMap();;
        this.symbolLinePattern = new SymbolLinePattern(gameConfig,utilService);
    }

    public Map<Integer,ArrayList<String>> findL2R(String[][] rngOutPut){
        Map<Integer,ArrayList<String>> indexVsCombinations = new HashMap<>();
        for(int index=0;index<rngOutPut.length;index++){
            String[] line = rngOutPut[index];
            String[] lineCopy = line.clone();
            ArrayList<String>  outPut = this.l2r.findCombinations(lineCopy,true);
            indexVsCombinations.put(index,outPut);
        }
        return indexVsCombinations;
    }

    public Map<Integer,ArrayList<String>> findR2L(String[][] rngOutPut){
        Map<Integer,ArrayList<String>> indexVsCombinations = new HashMap<>();
        for(int index=0;index<rngOutPut.length;index++){
            String[] line = rngOutPut[index];
            String[] lineCopy = line.clone();
            List<String> tmpList = Arrays.asList(lineCopy);
            Collections.reverse(tmpList);
            ArrayList<String>  outPut = this.l2r.findCombinations((String[]) tmpList.toArray(),false);
            indexVsCombinations.put(index,outPut);
        }
        return indexVsCombinations;

    }


    public Map<Integer,ArrayList<String>> findL2RAndR2L(String[][] rngOutPut){
        Map<Integer,ArrayList<String>> l2ROutPut = this.findL2R(rngOutPut);
        Map<Integer,ArrayList<String>> r2LOutPut = this.findR2L(rngOutPut);

        for(Map.Entry<Integer,ArrayList<String>> entry : l2ROutPut.entrySet()){
            int key = entry.getKey();
            ArrayList<String> fromR2L = r2LOutPut.get(key);
            if(fromR2L != null && fromR2L.size() > 0){
                l2ROutPut.get(key).addAll(fromR2L);
            }
        }
        return l2ROutPut;
    }


    public Map<Integer,ArrayList<String>> findAnyWhere(String[][] rngOutPut){
        Map<Integer,ArrayList<String>> indexVsCombinations = new HashMap<>();

        for(int index=0;index<rngOutPut.length;index++){
            String[] line = rngOutPut[index];
            String[] lineCopy = line.clone();
            ArrayList<String>  outPut = this.anyWhere.find(lineCopy);
            indexVsCombinations.put(index,outPut);
        }
        return indexVsCombinations;
    }

    public Map<Integer,LinePatternObj> findSymbolLinePatternsMatches(String[][] rngOutPut){
        Map<Integer,LinePatternObj>  indexVsCombinations = new HashMap<>();
        for(int index=0;index<rngOutPut.length;index++){
            String[] line = rngOutPut[index];
            String[] lineCopy = line.clone();
            LinePatternObj outPut = this.symbolLinePattern.findMatches(lineCopy);
            if(outPut != null) {
                indexVsCombinations.put(index,outPut);
            }
        }
        return indexVsCombinations;
    }

    public Map<String,ArrayList<SymbolOccurance>> findGivenTypeOnPlayWindow(String[][] rngOutPut,String type){
        Map<String,ArrayList<SymbolOccurance>> symbols = new HashMap<>();
        for(int row=0;row<rngOutPut.length;row++){
            String[] line = rngOutPut[row];
            for(int column=0;column<line.length;column++){
                String symbol = line[column].toLowerCase();
                if(this.utilService.isGivenType(symbol,type)){
                    SymbolOccurance obj  =
                            new SymbolOccurance(symbol,row,column);
                    ArrayList<SymbolOccurance> occurances = symbols.get(symbol);
                    if( occurances == null){
                        occurances= new ArrayList<>();
                    }
                    if(occurances.size() < line.length) {
                        occurances.add(obj);
                        symbols.put(symbol,occurances);
                    }
                }
            }
        }
        return symbols;
    }

}
