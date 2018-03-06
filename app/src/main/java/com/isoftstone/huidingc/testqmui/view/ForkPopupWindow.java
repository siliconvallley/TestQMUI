package com.isoftstone.huidingc.testqmui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.isoftstone.huidingc.testqmui.R;
import com.isoftstone.huidingc.testqmui.utils.SizeUtils;
import com.isoftstone.huidingc.testqmui.utils.ToastUtils;

/**
 * @auther huidingc
 * @date 2018/1/29 10:29
 * @description ForkPopupWindow
 */

public class ForkPopupWindow {

    private View rootView;
    private PopupWindow popupWindow;
    /**
     * 第一排图 距离屏幕底部的距离
     */
    private int top = 0;
    /**
     * 第二排图 距离屏幕底部的距离
     */
    private int bottom = 0;
    /**
     * 动画执行的 属性值数组
     */
    float animatorProperty[] = null;
    private LinearLayout llBt1;
    private LinearLayout llBt2;
    private LinearLayout llBt3;
    private LinearLayout llBt4;
    private LinearLayout llBt5;
    private LinearLayout llBt6;
    private LinearLayout llBt7;
    private ImageView ivFork;

    public static ForkPopupWindow getInstance(){
        return ForkPopHelper.INSTANCE;
    }

    private static class ForkPopHelper{
        public static ForkPopupWindow INSTANCE = new ForkPopupWindow();
    }

    /**
     * 初始化PopupWindow布局
     * @param context
     */
    private void initPop(Context context){
        rootView = LayoutInflater.from(context).inflate(R.layout.fork_popupwindow_layout, null);
        popupWindow = new PopupWindow(rootView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        //设置为失去焦点 方便监听返回键的监听
        popupWindow.setFocusable(false);
        // 如果想要popupWindow 遮挡住状态栏可以加上这句代码
        popupWindow.setClippingEnabled(false);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置点击外部不消失
        popupWindow.setOutsideTouchable(false);

        if(null == animatorProperty){
            top = SizeUtils.dp2px(300);
            bottom = SizeUtils.dp2px(200);
            animatorProperty = new float[]{bottom, 60, -30, -20 - 10, 0};
        }

        initViews(context);
    }

    /**
     * 初始化所有控件
     * @param context
     */
    private void initViews(Context context) {
        ivFork = rootView.findViewById(R.id.iv_fork);

        llBt1 = rootView.findViewById(R.id.ll_bt1);
        llBt2 = rootView.findViewById(R.id.ll_bt2);
        llBt3 = rootView.findViewById(R.id.ll_bt3);
        llBt4 = rootView.findViewById(R.id.ll_bt4);
        llBt5 = rootView.findViewById(R.id.ll_bt5);
        llBt6 = rootView.findViewById(R.id.ll_bt6);
        llBt7 = rootView.findViewById(R.id.ll_bt7);

        ivFork.setOnClickListener(new MeOnClick(0,context));
        llBt1.setOnClickListener(new MeOnClick(1,context));
        llBt2.setOnClickListener(new MeOnClick(2,context));
        llBt3.setOnClickListener(new MeOnClick(3,context));
        llBt4.setOnClickListener(new MeOnClick(4,context));
        llBt5.setOnClickListener(new MeOnClick(5,context));
        llBt6.setOnClickListener(new MeOnClick(6,context));
        llBt7.setOnClickListener(new MeOnClick(7,context));
    }

    /**
     * 点击事件
     */
    private class MeOnClick implements View.OnClickListener {
        public int index;
        public Context context;

        public MeOnClick(int index,Context context){
            this.index = index;
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            if(index == 0){
                //加号按钮点击之后的执行
                closePopAnim();
            }else{
                ToastUtils.setBgColor(context.getResources().getColor(R.color.custom_status_color));
                ToastUtils.showShort("index:"+index);
            }
        }
    }

    /**
     * 刚打开popupWindow 执行的动画
     */
    private void openPopAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivFork, "rotation", 0f, 135f);
        objectAnimator.setDuration(200);
        objectAnimator.start();

        startAnimation(llBt1, 500, animatorProperty);
        startAnimation(llBt2, 450, animatorProperty);
        startAnimation(llBt3, 400, animatorProperty);
        startAnimation(llBt4, 350, animatorProperty);

        startAnimation(llBt5, 500, animatorProperty);
        startAnimation(llBt6, 450, animatorProperty);
        startAnimation(llBt7, 400, animatorProperty);
    }


    /**
     * PopupWindow关闭动画
     */
    public void closePopAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivFork, "rotation", 135f, 0f);
        objectAnimator.setDuration(300);
        objectAnimator.start();

        closeAnimation(llBt1, 200, top);
        closeAnimation(llBt2, 300, top);
        closeAnimation(llBt3, 400, top);
        closeAnimation(llBt4, 500, top);

        closeAnimation(llBt5, 200, bottom);
        closeAnimation(llBt6, 300, bottom);
        closeAnimation(llBt7, 400, bottom);

        ivFork.postDelayed(new Runnable() {
            @Override
            public void run() {
                close();
            }
        },500);
    }

    /**
     * 弹起 popupWindow
     *
     * @param context context
     * @param parent  parent
     */
    public void show(Context context, View parent) {
        initPop(context);
        if (popupWindow != null && !popupWindow.isShowing()) {
            popupWindow.showAtLocation(parent, Gravity.NO_GRAVITY, 0, 0);
            openPopAnim();
        }
    }

    /**
     * 关闭popupWindow
     */

    public void close() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            popupWindow = null;
        }
    }

    /**
     * 判断PopupWindow是否显示
     * @return popupWindow
     */
    public boolean isShowing() {
        if (popupWindow == null) {
            return false;
        } else {
            return popupWindow.isShowing();
        }
    }

    /**
     * 关闭 popupWindow 时的动画
     *
     * @param view     mView
     * @param duration 动画执行时长
     * @param next     平移量
     */
    private void closeAnimation(View view, int duration, int next) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationY", 0f, next);
        anim.setDuration(duration);
        anim.start();
    }

    /**
     * 启动动画
     *
     * @param view     view
     * @param duration 执行时长
     * @param distance 执行的轨迹数组
     */
    private void startAnimation(View view, int duration, float[] distance) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationY", distance);
        anim.setDuration(duration);
        anim.start();
    }
}
