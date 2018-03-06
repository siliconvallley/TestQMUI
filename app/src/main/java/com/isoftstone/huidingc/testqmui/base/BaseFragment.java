package com.isoftstone.huidingc.testqmui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @auther huidingc
 * @date 2018/1/26 17:30
 * @description BaseFragment
 */

public abstract class BaseFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        initViews(view);
        initListener();
        initData();
    }

    /**
     * 获取布局
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View
     * @param view
     */
    protected abstract void initViews(View view);

    /**
     * 初始化监听器
     */
    protected abstract void initListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();
}
