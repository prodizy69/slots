package com.rss.games.slots;

import com.rss.common.Constants;
import com.rss.pojo.GameConfig;
import com.rss.pojo.ReplaceObject;
import com.rss.pojo.SpecialWildObj;
import com.rss.pojo.SubstitutionResponse;
import com.rss.util.UtilService;

import java.util.*;

public class SpecialWildsService {
    private GameConfig gameConfig;
    private UtilService utilService;
    private String[][] rngOutPut;
    private Map<Integer,ArrayList<SpecialWildObj>> oldWilds;
    private Map<Integer,ArrayList<ReplaceObject>> orderVsReplacedPositions;
    private Map<Integer,ArrayList<SpecialWildObj>> newOldWilds;


    public SpecialWildsService(GameConfig gameConfig, UtilService utilService, String[][] rngOutPut, Map<Integer, ArrayList<SpecialWildObj>> oldWilds) {
        this.gameConfig = gameConfig;
        this.utilService = utilService;
        this.rngOutPut = rngOutPut;
        this.oldWilds = oldWilds;
        this.orderVsReplacedPositions = new HashMap<>();
        this.newOldWilds = new HashMap<>();
    }

    public SubstitutionResponse doSubstitution(){
        SubstitutionResponse returnObject = new SubstitutionResponse();
        String[][] rngOutPutCopy = rngOutPut.clone();
        if(this.oldWilds != null && this.oldWilds.size() > 0) {
            this.orderVsReplacedPositions = new HashMap<>();
            this.doReplaceMents(this.oldWilds,false);
        }
        returnObject.setBeforeSubstitution(this.rngOutPut.clone());
        Map<Integer,ArrayList<SpecialWildObj>>  specialWildsFromRNGOutPut = this.utilService.getSpecialWildsFromRNGOutPut(rngOutPutCopy);
        //this.orderVsReplacedPositions = {};
        this.doReplaceMents(specialWildsFromRNGOutPut,true);

        returnObject.setRng(this.rngOutPut);

        returnObject.setOldWilds(this.newOldWilds);

        return returnObject;
    }

    public void doReplaceMents(Map<Integer,ArrayList<SpecialWildObj>> specialWilds, boolean fresh){
        List<Integer> keysSorted=new ArrayList(specialWilds.keySet());
        Collections.sort(keysSorted);
        for(int order : keysSorted){
            ArrayList<SpecialWildObj> occurances = specialWilds.get(order);
            for(SpecialWildObj object : occurances){
                if(object.getSpecialType().equalsIgnoreCase(Constants.WILD_TYPE_SPECIAL_EXPANDINGSHIFTING)){
                    boolean status = this.doExpandingShiftSubStitution(object,order,fresh);
                    this.constructOldWilds(object,order,fresh,status,false);
                }else if(object.getSpecialType().equalsIgnoreCase(Constants.WILD_TYPE_SPECIAL_EXPANDINGSTICKY)){
                    boolean status = this.doExpandingStickySubStitution(object,order,fresh);
                    this.constructOldWilds(object,order,fresh,status,true);
                }else if(object.getSpecialType().equalsIgnoreCase(Constants.WILD_TYPE_SPECIAL_EXPANDING)){
                    boolean status = this.doExpandingSubStitution(object,order,fresh);
                }else if(object.getSpecialType().equalsIgnoreCase(Constants.WILD_TYPE_SPECIAL_SHIFTING)){
                    boolean status = this.doShiftSubStitution(object,order,fresh);
                    this.constructOldWilds(object,order,fresh,status,false);
                }else if(object.getSpecialType().equalsIgnoreCase(Constants.WILD_TYPE_SPECIAL_STICKY)){
                    boolean status = this.doStickySubstitution(object,order,fresh);
                    this.constructOldWilds(object,order,fresh,status,true);
                }
            }
        }

    }

    public void addToReplacedPositions(int order,int rowIndex,int columnIndex){
        ArrayList<ReplaceObject> replacedPositions = this.orderVsReplacedPositions.get(order);
        if(replacedPositions == null){
            replacedPositions=new ArrayList<>();
        }
        replacedPositions.add(new ReplaceObject(rowIndex,columnIndex));
        this.orderVsReplacedPositions.put(order,replacedPositions);

    }
    public boolean canReplacePosition(int order,int rowIndex,int columnIndex,boolean fresh){
        if(fresh){
            order = Constants.SPECIAL_WILD_ORDER.get("Sticky Wild");
        }
        for(int number=order;number>=0;number--){
            ArrayList<ReplaceObject> replacedPositions = this.orderVsReplacedPositions.get(number);
            if(replacedPositions != null){
                for(ReplaceObject positionObject: replacedPositions){
                    if(positionObject.getRow() == rowIndex && positionObject.getColumn() == columnIndex){
                        return false;
                    }
                }
            }
        }
        return true;

    }
    public boolean doExpandingShiftSubStitution(SpecialWildObj specialWildObject,int order,boolean fresh){
        int colIndex = specialWildObject.getColIndex();
        int rowIndex = specialWildObject.getRowIndex();

        String symbol = specialWildObject.getSymbol();

        boolean isUsedToSubstitute=false;

        if(Constants.ORDER_TYPE_R2L.equalsIgnoreCase(specialWildObject.getSpecialWildTypeOrder())){
            if (specialWildObject.getColIndex() <= 0) {
                specialWildObject.setColIndex(specialWildObject.getColIndex()-1);
                return false;
            }
        }else {
            if (specialWildObject.getColIndex() >= this.gameConfig.getPlay_window().getCols()) {
                specialWildObject.setColIndex(specialWildObject.getColIndex()+1);
                return false;
            }
        }

        if(!this.canReplacePosition(order,rowIndex,colIndex,fresh)) {
            return isUsedToSubstitute;
        }

        for (int rowNumber = 0; rowNumber < this.rngOutPut.length; rowNumber++) {
            if(this.canReplacePosition(order,rowNumber,colIndex,fresh)) {
                this.addToReplacedPositions(order, rowNumber, colIndex);
                this.rngOutPut[rowNumber][colIndex] = symbol;
                isUsedToSubstitute=true;
            }
        }

        if(isUsedToSubstitute) {
            if(Constants.ORDER_TYPE_R2L.equalsIgnoreCase(specialWildObject.getSpecialWildTypeOrder())) {
                specialWildObject.setColIndex(specialWildObject.getColIndex()-1);
            }else{
                specialWildObject.setColIndex(specialWildObject.getColIndex()+1);
            }
        }
        return isUsedToSubstitute;

    }

    public boolean doExpandingStickySubStitution(SpecialWildObj specialWildObject,int order,boolean fresh){
        int colIndex = specialWildObject.getColIndex();
        int rowIndex = specialWildObject.getRowIndex();

        String symbol = specialWildObject.getSymbol();

        if(specialWildObject.getStickyCount() <= 0){
            specialWildObject.setStickyCount(specialWildObject.getStickyCount()-1);
            return false;
        }

        boolean isUsedToSubstitute=false;
        if(!this.canReplacePosition(order,rowIndex,colIndex,fresh)) {
            return isUsedToSubstitute;
        }
        for (int rowNumber = 0; rowNumber < this.rngOutPut.length; rowNumber++) {
            if(this.canReplacePosition(order,rowNumber,colIndex,fresh)) {
                this.addToReplacedPositions(order, rowNumber, colIndex);
                this.rngOutPut[rowNumber][colIndex] = symbol;
                isUsedToSubstitute=true;
            }
        }
        if(isUsedToSubstitute) {
            specialWildObject.setStickyCount(specialWildObject.getStickyCount()-1);
        }
        return isUsedToSubstitute;

    }

    public boolean doExpandingSubStitution(SpecialWildObj specialWildObject,int order,boolean fresh){
        int colIndex = specialWildObject.getColIndex();
        int rowIndex = specialWildObject.getRowIndex();

        String symbol = specialWildObject.getSymbol();
        boolean isUsedToSubstitute=false;
        if(!this.canReplacePosition(order,rowIndex,colIndex,fresh)) {
            return isUsedToSubstitute;
        }
        for (int rowNumber = 0; rowNumber < this.rngOutPut.length; rowNumber++) {
            if(this.canReplacePosition(order,rowNumber,colIndex,fresh)) {
                this.addToReplacedPositions(order, rowNumber, colIndex);
                this.rngOutPut[rowNumber][colIndex] = symbol;
                isUsedToSubstitute=true;
            }
        }
        return isUsedToSubstitute;

    }

    public boolean doShiftSubStitution(SpecialWildObj specialWildObject,int order,boolean fresh){
        int colIndex = specialWildObject.getColIndex();
        int rowIndex = specialWildObject.getRowIndex();

        String symbol = specialWildObject.getSymbol();
        boolean isUsedToSubstitute=false;

        if(Constants.ORDER_TYPE_R2L.equalsIgnoreCase(specialWildObject.getSpecialWildTypeOrder())){
            if (specialWildObject.getColIndex() <= 0) {
                specialWildObject.setColIndex(specialWildObject.getColIndex()-1);
                return false;
            }
        }else {
            if (specialWildObject.getColIndex() >= this.gameConfig.getPlay_window().getCols()) {
                specialWildObject.setColIndex(specialWildObject.getColIndex()+1);
                return false;
            }
        }


        if(this.canReplacePosition(order,rowIndex,colIndex,fresh)) {
            this.addToReplacedPositions(order, rowIndex, colIndex);
            this.rngOutPut[rowIndex][colIndex] = symbol;
            isUsedToSubstitute=true;
        }
        if(isUsedToSubstitute) {
            if(Constants.ORDER_TYPE_R2L.equalsIgnoreCase(specialWildObject.getSpecialWildTypeOrder())) {
                specialWildObject.setColIndex(specialWildObject.getColIndex()-1);
            }else{
                specialWildObject.setColIndex(specialWildObject.getColIndex()+1);
            }
        }
        return isUsedToSubstitute;

    }

    public boolean doStickySubstitution(SpecialWildObj specialWildObject,int order,boolean fresh){
        int colIndex = specialWildObject.getColIndex();
        int rowIndex = specialWildObject.getRowIndex();

        String symbol = specialWildObject.getSymbol();
        boolean isUsedToSubstitute=false;

        if(specialWildObject.getStickyCount() <= 0){
            specialWildObject.setStickyCount(specialWildObject.getStickyCount()-1);
            return false;
        }

        if(this.canReplacePosition(order,rowIndex,colIndex,fresh)) {
            this.addToReplacedPositions(order, rowIndex, colIndex);
            this.rngOutPut[rowIndex][colIndex] = symbol;
            isUsedToSubstitute=true;
        }
        if(isUsedToSubstitute) {
            specialWildObject.setStickyCount(specialWildObject.getStickyCount()-1);
        }
        return isUsedToSubstitute;

    }

    public boolean constructOldWilds(SpecialWildObj object,int order,boolean fresh,boolean status,boolean isSticky){
        if(fresh && !status){
            return false;
        }
        ArrayList<SpecialWildObj> occurancesPerOrder = this.newOldWilds.get(order);
        if(occurancesPerOrder == null){
            occurancesPerOrder = new ArrayList<>();
        }


        String[] firstRow = this.rngOutPut[0];

        if(object.getColIndex() > -1){
            if(Constants.ORDER_TYPE_R2L.equalsIgnoreCase(object.getSpecialWildTypeOrder())){
                if (object.getColIndex() < 0) {
                    return false;
                }
            }else {
                if (object.getColIndex() > firstRow.length) {
                    return false;
                }
            }
        }

        if(isSticky){
            if(object.getStickyCount() < 0){
                return false;
            }
        }
        object.setUsedInCurrentRun(status);
        occurancesPerOrder.add(object);
        this.newOldWilds.put(order,occurancesPerOrder);

        return true;

    }
}
