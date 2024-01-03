package com.github.datareport;

import android.app.Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SDK配置类的实现类，
 * 包括初始化，创建新打点事件，注册生命周期监听
 */
public class DataReportImpl {

    /** 待处理点位缓存，将缓存10个点位到内存中 */
    private final List<Event> mLogDataCacheList = Collections.synchronizedList(new ArrayList());
    /** 打点待上传分片 */
    private final List<List<Event>> uploadLists = Collections.synchronizedList(new ArrayList());
    /** 打点上传失败缓存 */
    private final List<Event> failUploadLists = Collections.synchronizedList(new ArrayList());

    public static void init(Application context) {

        //1.在主进程下， 将各个子进程缓存文件合并入主进程缓存文件

        //

        //常驻进程任务初始化
        initTasks();
    }

    /**
     * 初始打点SDK各个任务
     */
    private static void initTasks() {
        //监听亮屏息屏广播

        //监听网络切换

        //心跳打点开启

    }


}
