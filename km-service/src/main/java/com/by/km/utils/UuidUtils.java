package com.by.km.utils;

import java.util.UUID;

/**
 * UUID 工具类
 * @author bingyi
 */
public class UuidUtils {
    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
