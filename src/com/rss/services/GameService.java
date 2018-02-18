package com.rss.services;

import com.rss.common.Constants;
import com.rss.common.Errors;
import com.rss.common.JsonUtil;
import com.rss.games.CoreEngine;
import com.rss.games.slots.SpinService;
import com.rss.logger.LoggerAppenders;
import com.rss.pojo.*;
import com.rss.util.UtilService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("/game")
public class GameService extends CoreService {
    private static final Logger log = Logger.getLogger(LoggerAppenders.REST_PLAYER);

    @POST
    @Path("/handShake")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON})
    public HandShakeResponse handShake(String jsonString, @Context final HttpServletRequest req) {
        log.info("jsonString:" + jsonString);
        HandShakeResponse response = new HandShakeResponse(false, Errors.TECHNICAL_ERROR);
        try {
            HandShakeRequest requestObj = (HandShakeRequest) JsonUtil.encodeToObj(jsonString, HandShakeRequest.class);
            response.setGameConfig(getGameConfig(requestObj.getGameConfigId()));
        } catch (Exception e) {
            log.info("jsonString:" + jsonString + ":error:" + e.getLocalizedMessage());
            e.printStackTrace();
        }
        log.info("jsonString:" + jsonString + ":response:" + response);
        return response;
    }

    @POST
    @Path("/processSpin")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON})
    public SpinResponse processSpin(String jsonString, @Context final HttpServletRequest req) {
        log.info("jsonString:" + jsonString);
        SpinResponse response = new SpinResponse(false, Errors.TECHNICAL_ERROR);
        try {
            SpinRequest requestObj = (SpinRequest) JsonUtil.encodeToObj(jsonString, SpinRequest.class);
            GameConfig gameConfig = getGameConfig(requestObj.getGameConfigId());
            UtilService utilService = new UtilService(gameConfig);
            int index=0;
            Map<Integer, ArrayList<SpecialWildObj>> oldWilds = new HashMap<>();
            Map<Integer, ArrayList<SpecialWildObj>> oldWildsFree = new HashMap<>();
            SpinService spinService = new SpinService(
                    gameConfig,utilService, oldWilds,oldWildsFree,gameConfig.getPlay_lines().getWindowMatrix_Array());
            PayOutResponse payOutOutPut = spinService.spin(index, Constants.SPIN_TYPE_NORMAL,
                    requestObj.getBetAmount(),
                    requestObj.getBetAmount() * requestObj.getPlayLines(),
                    1);
            response.setSpinOutCome(payOutOutPut);
        } catch (Exception e) {
            log.info("jsonString:" + jsonString + ":error:" + e.getLocalizedMessage());
            e.printStackTrace();
        }
        log.info("jsonString:" + jsonString + ":response:" + response);
        return response;
    }
}
