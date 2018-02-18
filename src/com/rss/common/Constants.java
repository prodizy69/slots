package com.rss.common;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static String EMPTY = "EMPTY";
    public static String MIN_LENGTH = "MIN_LENGTH";
    public static String MAX_LENGTH = "MIN_LENGTH";

    public static String USERNAME = "USERNAME";
    public static int USERNAME_MIN_LENGTH = 5;
    public static int USERNAME_MAX_LENGTH = 10;

    public static String PASSWORD = "PASSWORD";
    public static int PASSWORD_MIN_LENGTH = 5;
    public static int PASSWORD_MAX_LENGTH = 10;

    public static String EMAIL = "EMAIL";
    public static String CONTACT = "CONTACT";
    public static String FIRST_NAME = "FIRST_NAME";
    public static String LAST_NAME = "LAST_NAME";

    public static String AWARDED = "AWARDED";
    public static String SELECTED = "SELECTED";
    public static String INPROGRESS = "INPROGRESS";
    public static String COMPLETED = "COMPLETED";

    public static String USER_TYPE_PLAYER="PLAYER";
    public static String USER_TYPE_ADMIN="ADMIN";
    public static Map<String,String> SETUP_TYPES=new HashMap<String, String>() {{
        put("TEST","TEST");
        put("STAGING","STAGING");
        put("LIVE","LIVE");
    }};

    public static String REGULAR="Regular Symbol";
    public static String WILD="Wild Symbol";
    public static String SCATTER="Scatter Symbol";
    public static String FREESPIN="FreeSpin Symbol";

    public static String ORDER_TYPE_L2R = "L2R";
    public static String ORDER_TYPE_R2L = "R2L";
    public static String ORDER_TYPE_BOTH = "BOTH";
    public static String ORDER_TYPE_ANYWHERE = "ANYWHERE";
    public static int WINDOW_DEFAULT = 0;
    public static int WINDOW_PLAY = 1;
    public static int WINDOW_PAY_LINE = 2;
    public static String SPIN_TYPE_NORMAL = "NORMAL";
    public static String SPIN_TYPE_FREE = "FREE";
    public static String WILD_TYPE_SPECIAL_NONE = "Standard Wild";
    public static String WILD_TYPE_SPECIAL_EXPANDING = "Expanding Wild";
    public static String WILD_TYPE_SPECIAL_STICKY = "Sticky Wild";
    public static String WILD_TYPE_SPECIAL_SHIFTING = "Shifting Wild";
    public static String WILD_TYPE_SPECIAL_EXPANDINGSHIFTING = "Expanding Shifting Wild";
    public static String WILD_TYPE_SPECIAL_EXPANDINGSTICKY = "Expanding Sticky Wild";


    public static Map<String, Integer> SPECIAL_WILD_ORDER=new HashMap<String, Integer>() {{
        put("Expanding Shifting Wild",0);
        put("Expanding Sticky Wild",1);
        put("Expanding Wild",2);
        put("Shifting Wild",3);
        put("Sticky Wild",4);
    }};

    public static String GAMBLE_TYPE_COLOR = "color";
    public static String GAMBLE_TYPE_SUITE = "suit";

    public static Map<String,String> GAMBLE_COLOR_VALUES=new HashMap<String, String>() {{
        put("black","black");
        put("red","red");
    }};

    public static Map<String,String> GAMBLE_SUITE_VALUES=new HashMap<String, String>() {{
        put("spade","spade");
        put("club","club");
        put("heart","heart");
        put("diamond","diamond");
    }};

    public static Map<String,String> SCATTER_PAYOUT_TYPE=new HashMap<String, String>() {{
        put("SUM_OF_ALL_PAYS","SUM_OF_ALL_PAYS");
        put("MAX_OF_ALL_PAYS","MAX_OF_ALL_PAYS");
        put("PAY_BY_PRIORITY","PAY_BY_PRIORITY");
    }};

    public static Map<String,Integer> FREESPIN_STATES=new HashMap<String, Integer>() {{
        put("AWARDED",0);
        put("SELECTED",1);
        put("INPROGRESS",2);
        put("COMPLETED",3);
    }};

    public static Map<String,Integer> BONUS_GAME_STATES=new HashMap<String, Integer>() {{
        put("AWARDED",0);
        put("SELECTED",1);
        put("INPROGRESS",2);
        put("COMPLETED",3);
    }};
    public static int MONEYTYPE_FREE=     0;
    public static int MONEYTYPE_CASH=     1;
    public static int MONEYTYPE_BBS=      2;
    public static int MONEYTYPE_BOTH=     3;
    public static int MONEYTYPE_FREE_BBS= 12;
    public static int MONEYTYPE_DEMO=     16;
    public static int CASINO_WAGER=       1;
    public static int CASINO_WINNING=     2;
    public static Map MONEY_TYPES=new HashMap<String, Integer>() {{
        put("free",0);
        put("cash",1);
        put("bbs",2);
    }};

    public static Map ALWAYS_SLOTS=new HashMap<String, Boolean>() {{
        put("3x3" , true);
        put("3x4" , true);
        put("3x5" , true);
        put("3x6" , true);
        put("4x3" , true);
        put("4x4" , true);
        put("4x5" , true);
        put("5x3" , true);
        put("5x4" , true);
        put("6x3" , true);
        put("6x4" , true);
        put("7x3" , true);
    }};

    public static Map NOTIFICATION_STATES=new HashMap<String, Integer>() {{
        put("NEW",0);
        put("READ",1);
    }};
}
