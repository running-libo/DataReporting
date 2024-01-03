package com.github.datareport;

import android.os.Bundle;

/**
 * 点位上报过滤器
 */
public class ReportFilter {

    /**
     * 是否匹配打点
     */
    public boolean isMatch(int eventName, Bundle parameters) {

        return true;
    }
}
