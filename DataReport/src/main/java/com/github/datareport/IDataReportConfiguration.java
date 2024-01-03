package com.github.datareport;

/**
 * 打点上报SDK初始化配置接口
 */
public interface IDataReportConfiguration {

    int getVersionCode();

    String getVersionName();

    String getDeviceId();

    String getServerUrl();
}
