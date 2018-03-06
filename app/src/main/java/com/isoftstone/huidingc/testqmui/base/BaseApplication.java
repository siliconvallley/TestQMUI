package com.isoftstone.huidingc.testqmui.base;

import android.app.Activity;
import android.app.Application;

import com.isoftstone.huidingc.testqmui.utils.Utils;

import java.lang.ref.WeakReference;
import java.util.Stack;

/**
 * @auther huidingc
 * @date 2018/1/25 14:56
 * @description BaseApplication
 */

public class BaseApplication extends Application {
    /**
     * 用于装所有的activity
     */
    private Stack<WeakReference<Activity>> activitys = new Stack<>();
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        Utils.init(baseApplication);
    }

    /**
     * 将Activity压入Application栈
     *
     * @param task 将要压入栈的Activity对象
     */
    public void pushTask(WeakReference<Activity> task) {
        activitys.push(task);
    }

    /**
     * 将传入的Activity对象从栈中移除
     *
     * @param task
     */
    public void removeTask(WeakReference<Activity> task) {
        activitys.remove(task);
    }

    /**
     * 根据指定位置从栈中移除Activity
     *
     * @param taskIndex Activity栈索引
     */
    public void removeTask(int taskIndex) {
        if (activitys.size() > taskIndex){
            activitys.remove(taskIndex);
        }
    }

    /**
     * 移除全部（用于整个应用退出）
     */
    public void removeAll() {
        //finish所有的Activity
        for (WeakReference<Activity> task : activitys) {
            if (!task.get().isFinishing()) {
                task.get().finish();
            }
        }
        // 杀死该应用进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static synchronized BaseApplication getInstance(){
        return baseApplication;
    }
}
