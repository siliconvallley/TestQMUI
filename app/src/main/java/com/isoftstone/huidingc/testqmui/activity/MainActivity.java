package com.isoftstone.huidingc.testqmui.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.isoftstone.huidingc.testqmui.R;
import com.isoftstone.huidingc.testqmui.base.BaseActivity;
import com.isoftstone.huidingc.testqmui.fragment.HeartFragment;
import com.isoftstone.huidingc.testqmui.fragment.MineFragment;
import com.isoftstone.huidingc.testqmui.fragment.NewsFragment;
import com.isoftstone.huidingc.testqmui.fragment.PartyFragment;
import com.isoftstone.huidingc.testqmui.utils.SizeUtils;
import com.isoftstone.huidingc.testqmui.utils.StatusBarHelper;
import com.isoftstone.huidingc.testqmui.view.ForkPopupWindow;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainActivity extends BaseActivity {
    @BindView(R.id.rl_content)
    RelativeLayout rlContent;
    @BindView(R.id.ll_tab1)
    LinearLayout llTab1;
    @BindView(R.id.ll_tab2)
    LinearLayout llTab2;
    @BindView(R.id.ll_tab3)
    LinearLayout llTab3;
    @BindView(R.id.ll_tab4)
    LinearLayout llTab4;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_title)
    LinearLayout llTiltle;
    @BindView(R.id.iv_tab1)
    ImageView ivTab1;
    @BindView(R.id.tv_tab1)
    TextView tvTab1;
    @BindView(R.id.iv_tab2)
    ImageView ivTab2;
    @BindView(R.id.tv_tab2)
    TextView tvTab2;
    @BindView(R.id.iv_tab3)
    ImageView ivTab3;
    @BindView(R.id.tv_tab3)
    TextView tvTab3;
    @BindView(R.id.iv_tab4)
    ImageView ivTab4;
    @BindView(R.id.tv_tab4)
    TextView tvTab4;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.drawer)
    DrawerLayout drawer;

    private Activity activity;
    private static final String TAG = "MainActivity";
    private Unbinder unbinder;
    private List<Fragment> fragments;
    private int mIndex;
    /**
     * 记录当前文字
     */
    private TextView tvCurrent;
    /**
     * 记录当前图片
     */
    private ImageView ivCurrent;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);
        activity = MainActivity.this;
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void initListener() {
        llTab1.setOnClickListener(onClickListener);
        llTab2.setOnClickListener(onClickListener);
        llTab3.setOnClickListener(onClickListener);
        llTab4.setOnClickListener(onClickListener);
        ivAdd.setOnClickListener(clickListener);
        ivMenu.setOnClickListener(clickListener);
    }

    @Override
    protected void initData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            llTiltle.setPadding(0, StatusBarHelper.getStatusbarHeight(activity), 0, 0);
        }
    }

    @Override
    protected void doBusiness() {
        initFragment();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        HeartFragment heartFragment = HeartFragment.getInstance(getResources().getString(R.string.main_tab1));
        NewsFragment newsFragment = NewsFragment.getInstance(getResources().getString(R.string.main_tab2));
        PartyFragment partyFragment = PartyFragment.getInstance(getResources().getString(R.string.main_tab3));
        MineFragment mineFragment = MineFragment.getInstance(getResources().getString(R.string.main_tab4));
        fragments.add(heartFragment);
        fragments.add(newsFragment);
        fragments.add(partyFragment);
        fragments.add(mineFragment);
        //开启事务
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //添加首页
        ft.add(R.id.rl_content, heartFragment).commit();
        //默认设置为第0个
        setIndexSelected(0);
        ivTab1.setSelected(true);
        tvTab1.setSelected(true);
        //tvTab1.setTypeface(Typeface.DEFAULT_BOLD);
        //tvTab1.setTextSize(16f);
        ivCurrent = ivTab1;
        tvCurrent = tvTab1;
        tvTitle.setText(getResources().getString(R.string.main_tab1));
    }

    /**
     * View的点击事件
     */
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ivCurrent.setSelected(false);
            tvCurrent.setSelected(false);
            //tvCurrent.setTypeface(Typeface.DEFAULT);
            //tvCurrent.setTextSize(14f);
            switch (v.getId()) {
                case R.id.ll_tab1:
                    setIndexSelected(0);
                    tvTab1.setSelected(true);
                    //tvTab1.setTypeface(Typeface.DEFAULT_BOLD);
                    //tvTab1.setTextSize(16f);
                    ivTab1.setSelected(true);
                    tvCurrent = tvTab1;
                    ivCurrent = ivTab1;
                    tvTitle.setText(getResources().getString(R.string.main_tab1));
                    break;
                case R.id.ll_tab2:
                    setIndexSelected(1);
                    tvTab2.setSelected(true);
                    //tvTab2.setTypeface(Typeface.DEFAULT_BOLD);
                    //tvTab2.setTextSize(16f);
                    ivTab2.setSelected(true);
                    tvCurrent = tvTab2;
                    ivCurrent = ivTab2;
                    tvTitle.setText(getResources().getString(R.string.main_tab2));
                    break;
                case R.id.ll_tab3:
                    setIndexSelected(2);
                    tvTab3.setSelected(true);
                    //tvTab3.setTypeface(Typeface.DEFAULT_BOLD);
                    //tvTab3.setTextSize(16f);
                    ivTab3.setSelected(true);
                    tvCurrent = tvTab3;
                    ivCurrent = ivTab3;
                    tvTitle.setText(getResources().getString(R.string.main_tab3));
                    break;
                case R.id.ll_tab4:
                    setIndexSelected(3);
                    tvTab4.setSelected(true);
                    //tvTab4.setTypeface(Typeface.DEFAULT_BOLD);
                    //tvTab4.setTextSize(16f);
                    ivTab4.setSelected(true);
                    tvCurrent = tvTab4;
                    ivCurrent = ivTab4;
                    tvTitle.setText(getResources().getString(R.string.main_tab4));
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 中心加号点击事件
     */
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_add:
                    ForkPopupWindow.getInstance().show(activity,ivAdd);
                    break;
                case R.id.iv_menu:
                    //打开侧边栏
                    drawer.openDrawer(Gravity.START,true);
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 设置Fragment选中
     * @param index
     */
    private void setIndexSelected(int index) {
        //判断是否是相同的下标，就是为了排除重复点击
        if (mIndex == index) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        //隐藏前一个页面
        ft.hide(fragments.get(mIndex));
        //判断是否添加
        if (!fragments.get(index).isAdded()) {
            ft.add(R.id.rl_content, fragments.get(index)).show(fragments.get(index));
        } else {
            ft.show(fragments.get(index));
        }
        ft.commit();
        //再次赋值
        mIndex = index;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != unbinder){
            unbinder.unbind();
        }
    }

    @Override
    public void onBackPressed() {
        if(ForkPopupWindow.getInstance().isShowing()){
            ForkPopupWindow.getInstance().closePopAnim();
        }else{
            super.onBackPressed();
        }
    }
}
