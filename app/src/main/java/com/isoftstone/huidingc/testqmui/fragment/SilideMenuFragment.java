package com.isoftstone.huidingc.testqmui.fragment;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.isoftstone.huidingc.testqmui.R;
import com.isoftstone.huidingc.testqmui.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @auther huidingc
 * @date 2018/1/29 16:18
 * @description SilideMenuFragment
 */

public class SilideMenuFragment extends BaseFragment {
    private Unbinder unbinder;
    private Activity activity;
    @BindView(R.id.ll_menu1)
    LinearLayout llMenu1;
    @BindView(R.id.ll_menu2)
    LinearLayout llMenu2;
    @BindView(R.id.ll_menu3)
    LinearLayout llMenu3;
    @BindView(R.id.ll_menu4)
    LinearLayout llMenu4;
    @BindView(R.id.iv_head)
    ImageView ivHead;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.silide_menu_layout;
    }

    @Override
    protected void initViews(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    protected void initListener() {
        llMenu1.setOnClickListener(onClickListener);
        llMenu2.setOnClickListener(onClickListener);
        llMenu3.setOnClickListener(onClickListener);
        llMenu4.setOnClickListener(onClickListener);
    }

    @Override
    protected void initData() {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .circleCrop();
        Glide.with(activity)
                .load("http://10.65.93.57:8088/2018/02/06/6b753bf5d8c341d1a41f8babcab28a98.png")
                .apply(options)
                .into(ivHead);
    }

    /**
     * 点击监听
     */
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ll_menu1:
                    break;
                case R.id.ll_menu2:
                    break;
                case R.id.ll_menu3:
                    break;
                case R.id.ll_menu4:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null != unbinder){
            unbinder.unbind();
        }
    }
}
