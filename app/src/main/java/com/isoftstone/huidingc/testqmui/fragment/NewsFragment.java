package com.isoftstone.huidingc.testqmui.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.isoftstone.huidingc.testqmui.R;
import com.isoftstone.huidingc.testqmui.base.BaseFragment;
import com.isoftstone.huidingc.testqmui.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @autor huidingc
 * @date 2018/1/26
 * @description NewsFragment
 */
public class NewsFragment extends BaseFragment {

    private Activity activity;
    Unbinder unbinder;
    @BindView(R.id.wb)
    WebView wb;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    public static NewsFragment getInstance(String data) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.news_fragment_layout;
    }

    @Override
    protected void initViews(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        setDefaultWebSettings(wb);
        wb.loadUrl("https://www.baidu.com/?tn=39042058_30_oem_dg");
    }

    private void setDefaultWebSettings(WebView webView) {
        WebSettings settings = webView.getSettings();
        //5.0以上开启混合模式加载
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        //允许js代码
        settings.setJavaScriptEnabled(true);
        //允许SessionStorage/LocalStorage存储
        settings.setDomStorageEnabled(true);
        //禁用缩放
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        //禁用文字缩放 默认值就是100
        settings.setTextZoom(100);
        //10M缓存，api 18后，系统自动管理。
        settings.setAppCacheMaxSize(10*1024*1024);
        //允许缓存，设置缓存位置
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(activity.getDir("appcache",0).getPath());
        //允许webview使用File协议
        settings.setAllowFileAccess(true);
        //不保存密码
        settings.setSavePassword(false);
        //设置UA
        settings.setUserAgentString(settings.getUserAgentString()+"testqumi/"+getAppVersionName());
        //自动加载图片
        settings.setLoadsImagesAutomatically(true);
        //移除部分系统JavaScript接口
        removeJavascriptInterfaces(webView);
    }

    /**
     * 移除部分系统的JavaScript接口
     * @param webView
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void removeJavascriptInterfaces(WebView webView) {
        try {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB &&
                    Build.VERSION.SDK_INT<Build.VERSION_CODES.JELLY_BEAN_MR1){
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != unbinder) {
            unbinder.unbind();
        }
    }



    /**
     * 获取 App 版本号
     *
     * @return App 版本号
     */
    public static String getAppVersionName() {
        return getAppVersionName(Utils.getApp().getPackageName());
    }

    /**
     * 获取 App 版本号
     *
     * @param packageName 包名
     * @return App 版本号
     */
    public static String getAppVersionName(final String packageName) {
        if (isSpace(packageName)) {
            return null;
        }
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断是否为空
     * @param s
     * @return
     */
    private static boolean isSpace(final String s) {
        if (s == null) {
            return true;
        }
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
