package com.github.datareport;

import android.os.Bundle;

/**
 * 参数检查类，检查事件参数的Key和Value
 */
public class ParamsChecker {

    private static boolean checkParameterValueType(Object value) {
        if (value instanceof Number) {
            return true;
        } else if (value instanceof String) {
            return true;
        } else if (value instanceof Boolean) {
            return true;
        }
        return false;
    }

    /**
     * 检查key的合法性
     * @param eventName
     * @param key
     * @param value
     * @return
     */
    private static boolean checkParameterKey(String eventName, String key, Object value) {
        return true;
    }

    /**
     * 检查value的合法性
     * @return
     */
    private static boolean checkParameterValue(final String eventName, int eventId, final String key, Object value, Bundle parameters) {
        return true;
    }


}

