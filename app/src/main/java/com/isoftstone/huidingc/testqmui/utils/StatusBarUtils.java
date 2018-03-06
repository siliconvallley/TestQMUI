package com.isoftstone.huidingc.testqmui.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;


/**
 * @auther huidingc
 * @date 2017/12/1
 * @description StatusBarUtils 设置5.0之后状态栏
 */

public class StatusBarUtils {
    /**
     * 5.0之后的状态栏颜色修改
     * @param activity
     * @param statusColor 状态栏颜色
     * @param isGray
     */
    public static void setStatusBarColor(Activity activity,int statusColor,boolean isGray){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //注意要清除 FLAG_TRANSLUCENT_STATUS flag
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置状态栏颜色
            window.setStatusBarColor(statusColor);
            //设置底部导航栏透明
            window.setNavigationBarColor(Color.TRANSPARENT);
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                if(isGray){
                    //设置6.0之后字体颜色变成灰色
                    window.getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }
            }
        }
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
