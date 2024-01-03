package com.github.datareport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

/**
 * 包管理工具类
 */
public class PackageUtils {

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo info = null;
        try {
            PackageManager manager = context.getPackageManager();
            info = manager.getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
        } catch (Exception e) {

        }
        return info;
    }

    /**
     * 获取应用第一次安装时间
     * @param context
     * @return
     */
    public static long getPackageInstallTime(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        return packageInfo != null ? packageInfo.firstInstallTime : 0;
    }

    /**
     * 获取上次包安装更新时间
     * @param context
     * @return
     */
    @SuppressWarnings("unused")
    static long getPackageUpdateTime(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        return packageInfo != null ? packageInfo.lastUpdateTime : 0;
    }

    /**
     * 获取应用签名
     * @param context
     * @return
     */
    public static byte[] getSignHash(Context context) {
        try {
            byte[] result = new byte[16];
            @SuppressLint("PackageManagerGetSignatures") PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            Signature[] signatures = packageInfo.signatures;
            if (signatures != null) {
                System.arraycopy(signatures[0].toByteArray(), 0, result, 0, 16);
                return result;
            }
        } catch (PackageManager.NameNotFoundException e) {

        }
        return null;
    }

    /**
     * 判断是否为新安装用户
     * 用第一次安装时间和上次安装更新时间判断是否相等
     * @param context
     * @return
     */
    public static boolean isNewUser(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            long firstInstallTime = packageInfo.firstInstallTime;
            long lastUpdateTime = packageInfo.lastUpdateTime;

            return firstInstallTime == lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {

        }

        return false;
    }
}