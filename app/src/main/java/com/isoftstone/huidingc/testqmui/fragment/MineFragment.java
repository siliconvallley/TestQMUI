package com.isoftstone.huidingc.testqmui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.isoftstone.huidingc.testqmui.R;
import com.isoftstone.huidingc.testqmui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @autor huidingc
 * @date 2018/1/26
 * @description MineFragment
 * @version
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.tv_name)
    TextView tvName;
    Unbinder unbinder;
    private Activity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    public static MineFragment getInstance(String data){
        MineFragment fragment = new MineFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name",data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_layout;
    }

    @Override
    protected void initViews(View view) {
        unbinder = ButterKnife.bind(this,view);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        if(null != bundle){
            String name = bundle.getString("name");
            tvName.setText(name);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
