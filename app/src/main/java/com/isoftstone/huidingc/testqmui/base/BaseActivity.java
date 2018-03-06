package com.isoftstone.huidingc.testqmui.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.gyf.barlibrary.ImmersionBar;
import com.isoftstone.huidingc.testqmui.utils.StatusBarHelper;
import com.isoftstone.huidingc.testqmui.utils.StatusBarUtils;

import java.lang.ref.WeakReference;

/**
 * @auther huidingc
 * @date 2018/1/25 14:55
 * @description BaseActivity
 */

public abstract class BaseActivity extends CustomBaseActivity {
    /**
     * 弱引用
     */
    public WeakReference<Activity> activitys;
    private BaseApplication baseApplication;
    private ImmersionBar immersionBar;
    private InputMethodManager imm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Application
        baseApplication = BaseApplication.getInstance();
        //将当前Activity压入栈
        activitys = new WeakReference<Activity>(this);
        //将Activity装入Application栈
        baseApplication.pushTask(activitys);
        //设置沉浸式状态栏
        //StatusBarHelper.translucent(BaseActivity.this,Color.TRANSPARENT);
        //setStatusBar();
        immersionBar = ImmersionBar.with(BaseActivity.this);
        immersionBar.init();
    }

    /**
     * 判断Activity是否存在
     *
     * @param packageName 包名
     * @param className   activity全路径类名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public boolean isActivityExists(@NonNull final String packageName,
                                           @NonNull final String className) {
        Intent intent = new Intent();
        intent.setClassName(packageName, className);
        return !(baseApplication.getPackageManager().resolveActivity(intent, 0) == null ||
                intent.resolveActivity(baseApplication.getPackageManager()) == null ||
                baseApplication.getPackageManager().queryIntentActivities(intent, 0).size() == 0);
    }

    /**
     * 跳转
     * @param clz
     */
    public void startActivity(@NonNull Class<?> clz){
        Intent intent = new Intent();
        intent.setClass(this,clz);
        startActivity(intent);
    }

    /**
     * Activity跳转
     * @param clz
     * @param bundle
     */
    public void startActivity(@NonNull Class<?> clz,Bundle bundle){
        Intent intent = new Intent();
        intent.setClass(this,clz);
        if(null != bundle){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * Activity跳转，带回结果
     * @param clz
     * @param requestCode
     */
    public void startActivityForResult(@NonNull Class<?> clz,int requestCode){
        Intent intent = new Intent();
        intent.setClass(this,clz);
        startActivityForResult(intent,requestCode);
    }

    /**
     * Activity跳转，带回结果
     * @param clz
     * @param bundle
     * @param requestCode
     */
    @SuppressLint("RestrictedApi")
    public void startActivityForResult(@NonNull Class<?> clz, Bundle bundle, int requestCode){
        Intent intent = new Intent();
        intent.setClass(this,clz);
        if(null != bundle){
            intent.putExtras(bundle);
        }
        startActivityForResult(intent,requestCode,bundle);
    }

    /**
     * 将值带回前一个Activity
     * @param bundle
     */
    public void setResult(Bundle bundle){
        Intent intent = new Intent();
        if(null != bundle){
            intent.putExtras(bundle);
        }
        setResult(RESULT_OK,intent);
        //finish页面
        finish();
    }

    /**
     * [沉浸状态栏]
     */
    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            StatusBarHelper.translucent(BaseActivity.this,Color.TRANSPARENT);
        }
    }

    @Override
    public void finish() {
        super.finish();
        hideSoftKeyBoard();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != baseApplication){
            baseApplication.removeTask(activitys);
        }
        if(null != immersionBar){
            //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
            immersionBar.destroy();
        }
        this.imm = null;
    }

    /**
     * 隐藏键盘
     */
    public void hideSoftKeyBoard() {
        View localView = getCurrentFocus();
        if(null == localView){
            localView = new View(this);
        }
        if (null == imm) {
            imm = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        }
        imm.hideSoftInputFromWindow(localView.getWindowToken(), 2);
    }
}
