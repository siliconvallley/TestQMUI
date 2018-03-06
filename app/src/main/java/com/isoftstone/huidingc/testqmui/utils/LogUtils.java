package com.isoftstone.huidingc.testqmui.utils;

import android.util.Log;

/**
 * @auther huidingc
 * @date 2018/1/31 17:37
 * @description LogUtils
 */

public class LogUtils {
    private LogUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static boolean isDebug = true;

    public static void setDebug(boolean debug) {
        isDebug = debug;
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag+"----->", msg);
        }
    }

    public static void d(Object object, String msg) {
        if (isDebug) {
            Log.d(object.getClass().getSimpleName(), msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag+"----->", msg);
        }
    }

    public static void i(Object object, String msg) {
        if (isDebug) {
            Log.i(object.getClass().getSimpleName(), msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag+"----->", msg);
        }
    }

    public static void w(Object object, String msg) {
        if (isDebug) {
            Log.w(object.getClass().getSimpleName(), msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag+"----->", msg);
        }
    }

    public static void e(Object object, String msg) {
        if (isDebug) {
            Log.e(object.getClass().getSimpleName(), msg);
        }
    }
}
