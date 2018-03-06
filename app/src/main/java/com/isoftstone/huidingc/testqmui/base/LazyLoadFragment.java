package com.isoftstone.huidingc.testqmui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by huidingc on 2017/7/31.
 */

public abstract class LazyLoadFragment extends Fragment {
    protected boolean isPrepared = false;
    protected boolean isLoadedOnce = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        init(view);
        isPrepared = true;
        // 数据加载
        loadData();
        return view;
    }
    
    protected abstract void init(View view);

    protected abstract int getLayoutId();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        loadData();
    }

    protected void loadData() {
        if(!isPrepared || !getUserVisibleHint() || isLoadedOnce){
            return;
        }
        // 懒加载
        lazyLoad();
        isLoadedOnce = true;
    }

    /**
     * 懒加载方法
     */
    protected abstract void lazyLoad();

    @Override
    public void onDetach() {
        super.onDetach();
        isPrepared = isLoadedOnce = false;
    }
}
