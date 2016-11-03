package com.example.sihua.matthewplay.Utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.example.sihua.matthewplay.global.BaseApplication;

/**
 * Created by Sihua on 2016/5/29.
 */
public class UIUtils {

    /**
     * Application相关方法
     * @return
     */
    public static Context getContext(){
        return BaseApplication.getContext();
    }

    public static Handler getHandler(){
        return BaseApplication.getHandler();
    }

    public static  int getMainThreadId(){
        return BaseApplication.getMainThreadId();
    }

    //加载字符串
    public static String getString(int id){
        return getContext().getResources().getString(id);
    }

    //加载字符串数组
    public static String[] getStringArray(int id){
        return getContext().getResources().getStringArray(id);
    }

    //加载图片
    public static Drawable getDrawable(int id){
        return getContext().getResources().getDrawable(id);
    }

    //加载颜色
    public static int  getColor(int id){
        return getContext().getResources().getColor(id);
    }

    public static int getDimen(int id){
        return getContext().getResources().getDimensionPixelSize(id);//获取对应像素值
    }

    //dp转px，px转dp
    public static int dip2px(float dp){
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int)(dp*density+0.5f);
    }

    public static float px2dip(int px){
        float density = getContext().getResources().getDisplayMetrics().density;
        return px/density;
    }

    //加载布局
    public static View inflate(int layoutId){
        return View.inflate(getContext(),layoutId,null);
    }

    //判断当前是否在主线程运行
    public static boolean isRunOnUiThread(){
        //获取当前线程ID的等于主线程ID
        return android.os.Process.myTid()==getMainThreadId();
    }

    //运行在主线程
    public static void runOnUiThread(Runnable r){
        //判断当前是否是主线程
        if(isRunOnUiThread()){
            //当前是主线程
            r.run();
        }else{
            //不是主线程(发送runnable对象)
            getHandler().post(r);
        }
    }

    //加载颜色状态选择器
    public static ColorStateList getColorStateList(int mTabTextColorResId) {
       return getContext().getResources().getColorStateList(mTabTextColorResId);
    }
}
