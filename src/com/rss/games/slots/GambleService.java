package com.rss.games.slots;

import com.rss.common.Constants;
import com.rss.config.Configuration;
import com.rss.pojo.GambleResponse;
import com.rss.pojo.GameConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GambleService {
    private GameConfig gameConfig;
    private RngService rngService;

    public GambleService(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
        this.rngService = new RngService(new int[]{4});
    }


    public GambleResponse processGamble(float betAmount,String gambleType,String answer){
        List<Integer> rngOutPut;
        if(!Configuration.getInstance().get("SETUP").equalsIgnoreCase(Constants.SETUP_TYPES.get("LIVE")) &&
                this.gameConfig.getFg_config() != null && this.gameConfig.getFg_config().get(gambleType) != null){
            rngOutPut = new ArrayList();
            rngOutPut.add(this.gameConfig.getFg_config().get(gambleType));
        }else {
            rngOutPut = Arrays.asList(this.rngService.generateRNG());
        }
        String expectedColorValue = null;
        String expectedSuiteValue = null;
        GambleResponse gambleResponse = new GambleResponse();
        gambleResponse.setWinAmount(0);
        switch (rngOutPut.get(0)) {
            case 0:
                expectedSuiteValue = Constants.GAMBLE_SUITE_VALUES.get("spade");
                expectedColorValue = Constants.GAMBLE_COLOR_VALUES.get("black");
                break;
            case 1:
                expectedSuiteValue = Constants.GAMBLE_SUITE_VALUES.get("club");
                expectedColorValue = Constants.GAMBLE_COLOR_VALUES.get("black");
                break;
            case 2:
                expectedSuiteValue = Constants.GAMBLE_SUITE_VALUES.get("heart");
                expectedColorValue = Constants.GAMBLE_COLOR_VALUES.get("red");
                break;
            case 3:
                expectedSuiteValue = Constants.GAMBLE_SUITE_VALUES.get("diamond");
                expectedColorValue = Constants.GAMBLE_COLOR_VALUES.get("red");
                break;
            default:
                return gambleResponse;
        }

        gambleResponse.setGambleTypeAnswerExpected(expectedSuiteValue);

        if(gambleType.equalsIgnoreCase(Constants.GAMBLE_TYPE_COLOR)){
            if (answer.equalsIgnoreCase(expectedColorValue)) {
                gambleResponse.setWinAmount( 2 * betAmount);
            }
        }else if(gambleType.equalsIgnoreCase(Constants.GAMBLE_TYPE_SUITE)){
            if (answer.equalsIgnoreCase(expectedSuiteValue)) {
                gambleResponse.setWinAmount( 4 * betAmount);
            }
        }
        return gambleResponse;
    }
}
