package com.github.datareport;

/**
 * SDK初始化配置实现类
 */
public class DataReportConfiguration implements IDataReportConfiguration {
    @Override
    public int getVersionCode() {
        return 0;
    }

    @Override
    public String getVersionName() {
        return null;
    }

    @Override
    public String getDeviceId() {
        return null;
    }

    @Override
    public String getServerUrl() {
        return null;
    }
}
