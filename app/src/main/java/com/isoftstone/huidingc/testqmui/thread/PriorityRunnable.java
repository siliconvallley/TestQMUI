package com.isoftstone.huidingc.testqmui.thread;

/**
 * @auther huidingc
 * @date 2018/3/16 14:56
 * @description PriorityRunnable
 * 带有优先级的Runnable对象
 */

public class PriorityRunnable implements Runnable {
    public Priority priority;
    private Runnable runnable;
    /**
     * 任务唯一标示
     */
    long SEQ;

    public PriorityRunnable(Priority priority,Runnable runnable){
        this.priority = priority == null ? Priority.NORMAL : priority;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        this.runnable.run();
    }
}
