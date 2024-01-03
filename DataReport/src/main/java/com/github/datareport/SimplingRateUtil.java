package com.github.datareport;

import java.util.Random;

/**
 * 打点上报采样率
 */
public class SimplingRateUtil {

    /**
     * 传入rate采样率，获取打点上报的几率
     * @param rate
     * @return
     */
    public static boolean simplingRate(int rate) {
        if (rate < 0 || rate > 100) {
            throw new IllegalArgumentException("Rate must be between 0 and 100 inclusive.");
        }

        int randomNumber = new Random().nextInt(100); // 生成一个0到99的随机整数

        return randomNumber < rate;
    }
}
