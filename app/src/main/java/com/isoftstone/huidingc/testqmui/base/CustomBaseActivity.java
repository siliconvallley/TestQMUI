package com.isoftstone.huidingc.testqmui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @auther huidingc
 * @date 2018/1/25 15:52
 * @description CustomBaseActivity
 */

public abstract class CustomBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        initViews();
        initListener();
        initData();
        doBusiness();
    }

    /**
     * 初始化布局
     */
    protected abstract void initViews();

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    /**
     * 初始化静态数据
     */
    protected abstract void initData();

    /**
     * 具体的业务
     */
    protected abstract void doBusiness();
}
