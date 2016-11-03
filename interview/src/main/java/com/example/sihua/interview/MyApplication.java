package com.example.sihua.interview;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sihua on 2016/11/2.
 */
public class MyApplication extends Application {
    List<Activity> activities=new ArrayList<Activity>();
    public void exit(){
        for (Activity a : activities) {
            a.finish();
        }
        activities.clear();
    }
}
