package com.rss.games.slots.combinations;

import com.rss.common.Constants;
import com.rss.pojo.SymbolObj;
import com.rss.util.NodeObject;
import com.rss.util.UtilService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class AnyWhere {
    private UtilService utilService;

    public AnyWhere(UtilService utilService) {
        this.utilService = utilService;
    }

    public ArrayList<String> find(String[] payline){
        Map<String,ArrayList<String>> wild_regular_map = this.utilService.getWildVsRegularMap();
        String[] regulars = this.utilService.getAllRegulars(payline);
        Map<String,SymbolObj>  wilds = this.utilService.getAllWilds();
        ArrayList<NodeObject> new_pay_line = new ArrayList<>();
        for(String item: payline){
            item = item.toLowerCase();
            NodeObject object = new NodeObject();
            object.setValue(item);
            if(this.utilService.isGivenType(item, Constants.WILD)){
                object.setWild(item);
            }
            new_pay_line.add(object);
        }
        ArrayList<String> combinations = new ArrayList<>();
        this.process(0,new_pay_line,wild_regular_map,regulars,wilds,combinations);
        return combinations;
    }

    public void process(int start,ArrayList<NodeObject> cur_payline,Map<String,ArrayList<String>> wild_regular_map,
                            String[] regulars,Map<String,SymbolObj> wilds,ArrayList<String> combinations){
        combinations = this.utilService.stringifyArrayPayLine(cur_payline,combinations);
        int index=0;
        for(NodeObject obj : cur_payline){
            ArrayList<NodeObject> new_payline = (ArrayList<NodeObject>) cur_payline.clone();
            String symbol = obj.getValue().toLowerCase();
            if(this.utilService.isGivenType(symbol,Constants.WILD)){
                ArrayList<String> wildsArray = wild_regular_map.get(symbol);
                int rex_sym=0;
                for (String wildSymbl: wildsArray) {
                    if (this.hasRegular(cur_payline,wildSymbl)) {
                        new_payline.get(index).setValue(wild_regular_map.get(symbol).get(rex_sym));
                        this.process((start + 1), new_payline, wild_regular_map, regulars, wilds,combinations);
                    }
                    rex_sym++;
                }
            }
            index++;
        }

    }

    public boolean hasRegular(ArrayList<NodeObject> cur_payline,String regSymbol){
        regSymbol = regSymbol.toLowerCase();
        for(NodeObject obj : cur_payline){
            if(obj.getValue().toLowerCase().equalsIgnoreCase(regSymbol)){
                return true;
            }
        }
        return false;
    }
}
