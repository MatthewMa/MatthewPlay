package com.example.sihua.matthewplay.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * Created by Sihua on 2016/5/29.
 */
public class BaseApplication extends Application {

    private static Context context;
    private static Handler handler;
    private static int mainThreadId;

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }

    /**
     * 应用创建时调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = Process.myTid();//获取当前线程ID

    }
}
