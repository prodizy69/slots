package com.rss.services;

import com.rss.common.Constants;
import com.rss.common.ErrorObj;
import com.rss.logger.LoggerAppenders;
import com.rss.pojo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.logging.Logger;

public class CoreService {
    private static final Logger log = Logger.getLogger(LoggerAppenders.REST_PLAYER);

    private static final String[] HEADERS_TO_TRY = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR" };

    public String getUserIp(HttpServletRequest request) {

        log.info("getRemoteUser is:" + request.getRemoteUser() + "getRemoteAddr is:" + request.getRemoteAddr() + "getRemoteHost is:" + request.getRemoteHost() + "getServerName is:" + request.getServerName());
        Enumeration<String> list = request.getHeaderNames();
        while(list.hasMoreElements()){
            // log.info(""+list.nextElement());
            for(String str: Collections.list(list)){
                log.info("the value is: " + str + "::" + request.getHeader(str) + "::");
            }
        }
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                log.info("User IP:" + ip);
                return ip.split(",")[0].trim();
            }
        }
        return request.getRemoteAddr();
    }

    public boolean allowAccess(HttpServletRequest request){
        String origin = request.getHeader("origin");
        String referer = request.getHeader("referer");
        String xForwardedHost = request.getHeader("x-forwarded-host");
        log.info("origin:" + origin + ":referer:" + referer + ":xForwardedHost:" + xForwardedHost);
        if (referer == null || xForwardedHost == null || !referer.contains(xForwardedHost)) {
            log.info("origin:" + origin + ":referer:" + referer + ":xForwardedHost:" + xForwardedHost + ":ip:" + getUserIp(request) + ":useragent:" + getUserAgent(request));
            return false;
        }
        if (origin != null && !referer.contains(origin)) {
            log.info("origin not null condition:" + origin + ":referer:" + referer + ":xForwardedHost:" + xForwardedHost + ":ip:" + getUserIp(request) + ":useragent:" + getUserAgent(request));
            return false;
        }
        return true;
    }

    public String getUserAgent(HttpServletRequest request) {
        return request.getHeader("user-agent");
    }

    public ErrorObj validateString(String value,String key,int minLenght,int maxLength){
        if(value == null){
            return new ErrorObj(key+ Constants.EMPTY,key+ Constants.EMPTY);
        }else if(minLenght > 0 && value.length() < minLenght){
            return new ErrorObj(key+ Constants.MIN_LENGTH,key+ Constants.MIN_LENGTH);
        }else if(maxLength > 0 && value.length() > maxLength){
            return new ErrorObj(key+ Constants.MAX_LENGTH,key+ Constants.MAX_LENGTH);
        }
        return null;
    }


    public GameConfig getGameConfig(String gameConfigId){
        GameConfig gameConfig = new GameConfig();
        PlayWindow playWindow = new PlayWindow();
        playWindow.setCols(7);
        playWindow.setRows(7);

        int[][] windowMatrix = new int[playWindow.getRows()][playWindow.getCols()];
        for(int index=0;index<playWindow.getCols();index++){
            windowMatrix[index]=new int[]{1,1,1,1,1,1,1};
        }
        gameConfig.setPlay_window(playWindow);
        PlayLines playLines = new PlayLines();
        playLines.setAllWaysSlots(false);
        int[][][] windowMatrix_Array = new int[7][playWindow.getRows()][playWindow.getCols()];
        for(int x=0;x<7;x++) {
            windowMatrix_Array[x] =  new int[7][7];
            for (int index = 0; index < playWindow.getCols(); index++) {
                if(x == index){
                    windowMatrix_Array[x][index] = new int[]{2,2,2,2,2,2,2};
                }else {
                    windowMatrix_Array[x][index] = new int[]{1, 1, 1, 1, 1, 1, 1};
                }
            }
        }
        playLines.setWindowMatrix_Array(windowMatrix_Array);
        gameConfig.setPlay_lines(playLines);

        ArrayList<SymbolObj> symbol_paytable = new ArrayList<>();
        SymbolObj symbolObj = new SymbolObj();
        symbolObj.setSymbolAlias("r1");
        symbolObj.setSymbolType("Regular Symbol");

        OfAKindObj[] ofAKindPayConfigArray = new OfAKindObj[]{
                new OfAKindObj(1,0),
                new OfAKindObj(1,1),
                new OfAKindObj(1,2),
                new OfAKindObj(1,3),
                new OfAKindObj(1,4),
                new OfAKindObj(2,5),
                new OfAKindObj(4,6)
        };

        symbolObj.setOfAKindPayConfigArray(ofAKindPayConfigArray);
        symbolObj.setCommonPayConfig(new PayConfig(new HashMap<>()));
        symbol_paytable.add(symbolObj);


        symbolObj = new SymbolObj();
        symbolObj.setSymbolAlias("r2");
        symbolObj.setSymbolType("Regular Symbol");

        ofAKindPayConfigArray = new OfAKindObj[]{
                new OfAKindObj(1,0),
                new OfAKindObj(1,1),
                new OfAKindObj(1,2),
                new OfAKindObj(1,3),
                new OfAKindObj(1,4),
                new OfAKindObj(2,5),
                new OfAKindObj(4,6)
        };

        symbolObj.setOfAKindPayConfigArray(ofAKindPayConfigArray);
        symbolObj.setCommonPayConfig(new PayConfig(new HashMap<>()));
        symbol_paytable.add(symbolObj);

        symbolObj = new SymbolObj();
        symbolObj.setSymbolAlias("est1");
        symbolObj.setSymbolType("Wild Symbol");

        ofAKindPayConfigArray = new OfAKindObj[]{
                new OfAKindObj(20,0),
                new OfAKindObj(30,1),
                new OfAKindObj(40,2),
                new OfAKindObj(50,3),
                new OfAKindObj(60,4),
                new OfAKindObj(70,5),
                new OfAKindObj(80,6)
        };

        symbolObj.setOfAKindPayConfigArray(ofAKindPayConfigArray);
        //symbolObj.setCommonPayConfig(new PayConfig(new HashMap<>()));
        PayConfig payConfig = new PayConfig();
        payConfig.setSpecialWildType("Expanding Sticky Wild");
        payConfig.setStickySpinCount(3);
        payConfig.setWildSubstitutionMultiplierValue(3);
        symbolObj.setCommonPayConfig(payConfig);
        Map<String,Boolean> mapping = new HashMap<>();
        mapping.put("r1",true);
        mapping.put("r2",false);
        symbol_paytable.add(symbolObj);
        gameConfig.setSymbol_paytable(symbol_paytable);

        SymbolPayTable symbol_paytable_common = new SymbolPayTable();
        ScatterObj scatterObj = new ScatterObj();
        scatterObj.setPayMethod("SUM_OF_ALL_PAYS");
        scatterObj.setSymbolAliasPriorityArray(new String[]{"s1"});
        symbol_paytable_common.setSCATTERS(scatterObj);
        gameConfig.setSymbol_paytable_common(symbol_paytable_common);

        gameConfig.setPaylines_paytable(new ArrayList<LinePatternObj>());


        ArrayList<ReelSet> reel_set_config_array = new ArrayList<>();
        ReelSet reelSet = new ReelSet();
        reelSet.setReelSetName("Reel Set 1");
        reelSet.setReelStripLengths_Array(new int[]{20,7,7,7,7,7,7});
        String[][] reelStripsData_ArrayArray = new String[7][];
        reelStripsData_ArrayArray[0] = new String[]{"r1","r1","r1","r2","r2","r1","r1","r1","r1","est1","r1","est1","r2","r2","r1","r1","r2","r2","r2","est1"};
        reelStripsData_ArrayArray[1] = new String[]{"r1","est1","r1","r2","r2","r1","r1"};
        reelStripsData_ArrayArray[2] = new String[]{"est1","r1","r1","r2","r2","r1","r1"};
        reelStripsData_ArrayArray[3] = new String[]{"r1","r1","est1","r2","r2","r1","r1"};
        reelStripsData_ArrayArray[4] = new String[]{"est1","r1","r1","r2","r2","r1","r1"};
        reelStripsData_ArrayArray[5] = new String[]{"r1","est1","r1","r2","r2","r1","r1"};
        reelStripsData_ArrayArray[6] = new String[]{"r1","est1","r1","r2","r2","r1","r1"};

        reelSet.setReelStripsData_ArrayArray(reelStripsData_ArrayArray);
        reel_set_config_array.add(reelSet);
        gameConfig.setReel_set_config_array(reel_set_config_array);

        gameConfig.setFg_config(null);
        gameConfig.setFo_config(null);
        gameConfig.setGame_order("L2R");
        gameConfig.setGamble_enabled(true);
        gameConfig.setPay_once(false);

        return gameConfig;
    }
}
