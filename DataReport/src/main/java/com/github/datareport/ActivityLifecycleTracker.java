package com.github.datareport;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * activity生命周期监听处理
 */
public class ActivityLifecycleTracker implements Application.ActivityLifecycleCallbacks {
    /**
     * 线程安全的前台Activity的计数器。
     */
    private AtomicInteger allActivityCount = new AtomicInteger(0);

    /**
     * 开始监听Activity生命周期
     */
    public static void registerLifecycle(Application application) {
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleTracker());
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }
}
