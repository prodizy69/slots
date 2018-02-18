package com.rss.games.slots;

import com.rss.common.Constants;
import com.rss.pojo.GameConfig;
import com.rss.pojo.MaxWild;
import com.rss.pojo.OfAKindObj;
import com.rss.util.NodeObject;
import com.rss.util.UtilService;

import java.lang.reflect.Array;
import java.util.*;

public class RankingService {
    private Map<Integer,ArrayList<String>> combinationsObj;
    private GameConfig gameConfig;
    private String orderType;
    private UtilService utilService;
    private int numberOfColumns;

    public RankingService(Map<Integer, ArrayList<String>> combinationsObj, GameConfig gameConfig, String orderType, UtilService utilService, int numberOfColumns) {
        this.combinationsObj = combinationsObj;
        this.gameConfig = gameConfig;
        this.orderType = orderType;
        this.utilService = utilService;
        this.numberOfColumns = numberOfColumns;
    }

    public Map<Integer,Map<Integer,ArrayList<OfAKindObj>>> find(){
        Map<Integer,Map<Integer,ArrayList<OfAKindObj>>> payLineVsOfAKinds = new HashMap<>();
        List<Integer> payLineNumbers=new ArrayList(combinationsObj.keySet());
        for(int payLineNumber=0;payLineNumber<payLineNumbers.size();payLineNumber++)
        {
            ArrayList<String> combinationsPerPayLine = this.combinationsObj.get(payLineNumber);
            payLineVsOfAKinds.put(payLineNumber,new HashMap<>());
            for(int combinationNumber=0;combinationNumber<combinationsPerPayLine.size();combinationNumber++)
            {
                String arrayStrings = combinationsPerPayLine.get(combinationNumber);
                String[] nodeObjArrays = arrayStrings.split(";");
                NodeObject[] combination_copy = new NodeObject[nodeObjArrays.length];
                int index=0;
                for(String nodeObj : nodeObjArrays){
                    String[] nodeObjStr = nodeObj.split(":");
                    NodeObject obj = new NodeObject();
                    obj.setValue(nodeObjStr[0]);
                    if(nodeObjStr.length > 1){
                        obj.setWild(nodeObjStr[1]);
                    }
                    combination_copy[index]=obj;
                    index++;
                }
                ArrayList<OfAKindObj> ofAKinds = new ArrayList();
                if(this.orderType.equalsIgnoreCase(Constants.ORDER_TYPE_L2R) || this.orderType.equalsIgnoreCase(Constants.ORDER_TYPE_BOTH)){
                    ofAKinds.add(this.findL2R(combination_copy,Constants.ORDER_TYPE_L2R));
                }

                if(this.orderType.equalsIgnoreCase(Constants.ORDER_TYPE_R2L) || this.orderType.equalsIgnoreCase(Constants.ORDER_TYPE_BOTH)){
                    List<NodeObject> tmpList = Arrays.asList(combination_copy);
                    Collections.reverse(tmpList);
                    ofAKinds.add(this.findL2R((NodeObject[])tmpList.toArray(),Constants.ORDER_TYPE_R2L));
                }

                if(this.orderType.equalsIgnoreCase(Constants.ORDER_TYPE_ANYWHERE)){
                    ofAKinds.addAll(this.findAnyWhere(combination_copy));
                }
                payLineVsOfAKinds.get(payLineNumber).put(combinationNumber,ofAKinds);
            }
        }
        return payLineVsOfAKinds;

    }

    public OfAKindObj findL2R(NodeObject[] combination,String type){
        NodeObject firstEntry = null;
        int count=0;
        ArrayList wildsUsed=new ArrayList();
        ArrayList indexes=new ArrayList();
        for(int index=0;index<combination.length;index++){
            NodeObject element = combination[index];
            if(firstEntry == null){
                firstEntry = element;
            }
            if(firstEntry.getValue().equalsIgnoreCase(element.getValue())){
                if(element.getWild() != null){
                    wildsUsed.add(element.getWild());
                }
                count++;
                if(type.equalsIgnoreCase(Constants.ORDER_TYPE_R2L)) {
                    indexes.add(this.numberOfColumns-1-index);
                }else{
                    indexes.add(index);
                }
            }else{
                break;
            }
        }

        OfAKindObj ofAkind = new OfAKindObj();
        ofAkind.setSymbol(firstEntry.getValue());
        ofAkind.setCount(count);
        ofAkind.setType(this.orderType);
        ofAkind.setIndexes(indexes);
        if(wildsUsed.size() > 0){
            MaxWild wildHavingMaxMultipler = this.utilService.getWildHavingMaxMultiplier((String[]) wildsUsed.toArray(new String[wildsUsed.size()]));
            ofAkind.setWildObj(wildHavingMaxMultipler);
        }
        return ofAkind;
    }

    public ArrayList<OfAKindObj> findAnyWhere(NodeObject[] combination) {
        Map<String,OfAKindObj> symbolVsOfAKindObj = new HashMap<>();
        for(int index=0;index<combination.length;index++){
            NodeObject element = combination[index];
            OfAKindObj ofAKindObj = symbolVsOfAKindObj.get(element.getValue());
            if(ofAKindObj == null){
                OfAKindObj ofAKindObjTmp = new OfAKindObj();
                ofAKindObjTmp.setWilds(new ArrayList());
                ofAKindObjTmp.setCount(0);
                ofAKindObjTmp.setIndexes(new ArrayList());
            }
            if(element.getWild() != null){
                ofAKindObj.getWilds().add(element.getWild());
            }
            ofAKindObj.setCount(ofAKindObj.getCount()+1);
            ofAKindObj.getIndexes().add(index);
            symbolVsOfAKindObj.put(element.getValue(),ofAKindObj);
        }

        ArrayList<OfAKindObj> ofAKinds = new ArrayList();

        for (Map.Entry<String,OfAKindObj> entry : symbolVsOfAKindObj.entrySet()){
            OfAKindObj object = symbolVsOfAKindObj.get(entry.getKey());
            OfAKindObj ofAkind = new OfAKindObj();
            ofAkind.setSymbol(entry.getKey());
            ofAkind.setCount(object.getCount());
            ofAkind.setType(this.orderType);
            ofAkind.setIndexes(object.getIndexes());

            if(object.getWilds().size() > 0){
                MaxWild wildHavingMaxMultipler = this.utilService.getWildHavingMaxMultiplier((String[]) object.getWilds().toArray());
                ofAkind.setWildObj(wildHavingMaxMultipler);
            }
            ofAKinds.add(ofAkind);
        }

        return ofAKinds;
    }
}
