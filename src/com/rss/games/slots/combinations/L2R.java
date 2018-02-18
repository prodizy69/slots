package com.rss.games.slots.combinations;

import com.rss.common.Constants;
import com.rss.util.DoublyLinkedListImpl;
import com.rss.util.NodeObject;
import com.rss.util.UtilService;

import java.util.ArrayList;
import java.util.Map;

public class L2R {
    private UtilService utilService;
    private Map<String,ArrayList<String>> wildVsRegularMap;

    public L2R(UtilService utilService) {
        this.utilService = utilService;
        this.wildVsRegularMap = this.utilService.getWildVsRegularMap();
    }

    public ArrayList<String>  findCombinations(String[] payLine, boolean direction){
        String[] allRegulars = this.utilService.getAllRegulars(payLine);
        DoublyLinkedListImpl<NodeObject> lineListObj = this.utilService.convertToLinkedList(payLine);
        ArrayList<String> combinations = new ArrayList<>();
        DoublyLinkedListImpl<NodeObject>.Node currentNode = lineListObj.getHead();
        combinations = this.utilService.stringifyPayline(lineListObj,direction,combinations);
        DoublyLinkedListImpl<NodeObject>.Node firstRegularNode = this.firstRegular(lineListObj.getHead());
        String firstSymbolToReplace = firstRegularNode != null ? firstRegularNode.getElement().getValue() : null;

        DoublyLinkedListImpl<NodeObject>.Node lastSymbolNode = this.lastRegular(lineListObj.getTail());
        String lastSymbolToReplace = lastSymbolNode != null ? lastSymbolNode.getElement().getValue() : null;
        String symbolToCheckFor = firstSymbolToReplace != null ? firstSymbolToReplace : lastSymbolToReplace;

        if(symbolToCheckFor != null && this.hasScatterInNextNodes(lineListObj.getHead()) == false) {
            if(this.hasWildsAndAllCanReplaceSymbol(currentNode,symbolToCheckFor)) {
                while (currentNode != null) {
                    String data = currentNode.getElement().getValue();
                    DoublyLinkedListImpl<NodeObject>.Node nextNode = currentNode.getNext();
                    if (this.utilService.isGivenType(data, Constants.SCATTER) || this.utilService.isGivenType(data, Constants.FREESPIN)) {
                        currentNode = currentNode.getNext();
                        combinations = this.utilService.stringifyPayline(lineListObj, direction, combinations);
                        symbolToCheckFor = null;
                    }else{
                        if (this.utilService.isGivenType(data, Constants.WILD)) {
                            if (symbolToCheckFor != null && this.wildVsRegularMap.get(data).contains(symbolToCheckFor)) {
                                currentNode.getElement().setValue(symbolToCheckFor);
                            }else if (lastSymbolToReplace != null && this.wildVsRegularMap.get(data).contains(lastSymbolToReplace)) {
                                currentNode.getElement().setValue(lastSymbolToReplace);
                                symbolToCheckFor = null;
                            }
                        }else{
                            if (!lineListObj.getHead().getElement().getValue().equalsIgnoreCase(currentNode.getElement().getValue())) {
                                symbolToCheckFor = null;
                            }
                        }
                        currentNode = currentNode.getNext();
                        combinations = this.utilService.stringifyPayline(lineListObj, direction, combinations);
                    }
                }
            }
        }
        return combinations;
    }

    public boolean hasWildsAndAllCanReplaceSymbol(DoublyLinkedListImpl<NodeObject>.Node currentNode,String symbolToCheckFor){
        while(currentNode != null){
            if(this.utilService.isGivenType(currentNode.getElement().getValue(),Constants.REGULAR)){
                return true;
            }else if(this.utilService.isGivenType(currentNode.getElement().getValue(),Constants.WILD)){
                if(this.wildVsRegularMap.get(currentNode.getElement().getValue()).contains(symbolToCheckFor)){
                    return false;
                }
            }
            currentNode = currentNode.getNext();
        }
        return true;
    }

    public boolean hasScatterInNextNodes(DoublyLinkedListImpl<NodeObject>.Node currentNode){
        while(currentNode != null){
            if(this.utilService.isGivenType(currentNode.getElement().getValue(),Constants.REGULAR)){
                return false;
            }else if(this.utilService.isGivenType(currentNode.getElement().getValue(),Constants.SCATTER)){
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public DoublyLinkedListImpl.Node firstRegular(DoublyLinkedListImpl<NodeObject>.Node currentNode){
        while(currentNode != null){
            if(this.utilService.isGivenType(currentNode.getElement().getValue(), Constants.REGULAR)){
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }


    public DoublyLinkedListImpl.Node lastRegular(DoublyLinkedListImpl<NodeObject>.Node currentNode){
        while(currentNode != null){
            if(this.utilService.isGivenType(currentNode.getElement().getValue(),Constants.REGULAR)){
                return currentNode;
            }
            currentNode = currentNode.getPrev();
        }
        return null;
    }

}
