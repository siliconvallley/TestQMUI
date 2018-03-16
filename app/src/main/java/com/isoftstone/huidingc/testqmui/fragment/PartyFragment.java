package com.isoftstone.huidingc.testqmui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.isoftstone.huidingc.testqmui.R;
import com.isoftstone.huidingc.testqmui.base.BaseFragment;
import com.isoftstone.huidingc.testqmui.thread.Priority;
import com.isoftstone.huidingc.testqmui.thread.PriorityExecutor;
import com.isoftstone.huidingc.testqmui.thread.PriorityRunnable;
import com.isoftstone.huidingc.testqmui.utils.LogUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @autor huidingc
 * @date 2018/1/26
 * @description PartyFragment
 * @version
 */
public class PartyFragment extends BaseFragment {
    private static final String TAG = "PartyFragment";
    @BindView(R.id.bt1)
    Button bt1;
    Unbinder unbinder;
    private Activity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    public static PartyFragment getInstance(String data){
        PartyFragment fragment = new PartyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name",data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.party_fragment_layout;
    }

    @Override
    protected void initViews(View view) {
        unbinder = ButterKnife.bind(this,view);
    }

    @Override
    protected void initListener() {
        bt1.setOnClickListener(onClickListener);
    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        if(null != bundle){
            String name = bundle.getString("name");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.bt1:
                    function1();
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue)
     * ThreadPoolExecutor(int corePoolSize, int maximumPoolSize,long keepAliveTime, TimeUnit unit,BlockingQueue workQueue,RejectedExecutionHandler handler)
     * ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,RejectedExecutionHandler handler)
     * ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory, RejectedExecutionHandler handler)
     *
     * corePoolSize： 线程池维护线程的最少数量
     * maximumPoolSize：线程池维护线程的最大数量
     * keepAliveTime： 线程池维护线程所允许的空闲时间
     * unit： 线程池维护线程所允许的空闲时间的单位
     * workQueue： 线程池所使用的缓冲队列
     * threadFactory：线程池用于创建线程
     * handler： 线程池对拒绝任务的处理策略
     */
    private void function1() {
        ExecutorService executorService = new PriorityExecutor(5,false);
        for (int i = 0; i < 20; i++) {
            PriorityRunnable priorityRunnable = new PriorityRunnable(Priority.NORMAL, new Runnable() {
                @Override
                public void run() {
                    LogUtils.e(TAG,Thread.currentThread().getName()+"优先级正常");
                }
            });

            if (i % 3 == 1) {
                priorityRunnable = new PriorityRunnable(Priority.HIGH, new Runnable() {
                    @Override
                    public void run() {
                        LogUtils.e(TAG, Thread.currentThread().getName()+"优先级高");
                    }
                });
            } else if (i % 5 == 0) {
                priorityRunnable = new PriorityRunnable(Priority.LOW, new Runnable() {
                    @Override
                    public void run() {
                        LogUtils.e(TAG, Thread.currentThread().getName()+"优先级低");
                    }
                });
            }
            executorService.execute(priorityRunnable);
        }
    }
}
