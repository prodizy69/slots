package com.rss.common;

import com.rss.logger.LoggerAppenders;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.logging.Logger;

public class JsonUtil
{
    private static final Logger log = Logger.getLogger(LoggerAppenders.REST_PLAYER);
    public static String decodeToString(Object obj,String className){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            log.info("obj:"+obj+":className:"+className);
            String payload = objectMapper.writeValueAsString(obj);
            log.info("obj:"+obj+":className:"+className+":payload:"+payload);
            return payload;
        }catch (Exception e){
            log.info("obj:"+obj+":className:"+className+":error:"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static Object encodeToObj(String str,Class className){
        try {
            log.info("Str:"+str+":className:"+className);
            Object obj = new ObjectMapper().readValue(str, className);
            log.info("Str:"+str+":className:"+className+":obj:"+obj);
            return obj;
        }catch (Exception e){
            log.info("Str:"+str+":className:"+className+":error:"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return null;
    }
}
