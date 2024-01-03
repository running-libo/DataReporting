package com.github.datareport;

/**
 * SP操作工具类
 */
public class SharedPfUtil {

    /**
     * 获取指定进程的使用时长
     * @param processName
     * @return
     */
    private static long getProcessUsageTime(String processName) {
        return 0;
    }

    /**
     * 更新指定进程的使用时长
     * @param processName
     * @param processUsageTime
     */
    public static void updateProcessUsageTime(String processName, long processUsageTime) {

    }

    /**
     * 获取是否是老用户
     * @return
     */
    public synchronized static boolean isOldUser() {
        return false;
    }

    /**
     * 设置是否是老用户
     * @param isOldUser
     */
    public synchronized static void setOldUser(boolean isOldUser) {

    }

    /**
     * 获取常驻进程累计存活时长
     */
    public static long getPersistProcessLiveTime() {
        return 0;
    }

    /**
     * 设置常驻进程累计存活时长
     */
    public static void setPersistProcessLiveTime(long persistProcessLiveTime) {

    }
}
