package com.lc.lib.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * Created by LiangCheng on 2018/4/11.
 * Activity管理
 */

public class AppManager {

    //实例化栈
    private Stack<Activity> activityStack = new Stack<>();

    private static AppManager appManager;

    private AppManager() {
    }

    public static AppManager getInstence() {
        if (appManager == null) {
            synchronized (AppManager.class) {
                if (appManager == null) {
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }

    /*入栈*/
    public void addActivity(Activity activity) {
        activityStack.add(activity);
    }

    /*出栈*/
    public void finishActivity(Activity activity) {
        activity.finish();
        activityStack.remove(activity);
    }

    /*获取栈顶Activity*/
    public Activity currentActivity() {
        return activityStack.lastElement();
    }

    /*清理栈*/
    public void finishAllActivity() {
        for (Activity a : activityStack) {
            a.finish();
        }
        activityStack.clear();
    }

    /*退出app*/
    public void exitApp(Context context) {
        finishAllActivity();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.killBackgroundProcesses(context.getPackageName());
        System.exit(0);
    }
}
