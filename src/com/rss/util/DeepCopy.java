package com.rss.util;

import com.rss.common.JsonUtil;

public class DeepCopy {
    public static Object deepCopy(Object obj,String classNameStr,Class className){
        return JsonUtil.encodeToObj(JsonUtil.decodeToString(obj,classNameStr),className);
    }
}
