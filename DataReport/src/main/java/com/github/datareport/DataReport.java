package com.github.datareport;

import android.app.Application;

/**
 * SDK配置类，只声明功能，隐藏具体实现细节
 * 包括初始化，创建新打点事件，注册生命周期监听
 */
public class DataReport {

    public static void init(Application context) {
        DataReportImpl.init(context);
    }
}
