package com.isoftstone.huidingc.testqmui.thread;

import android.support.annotation.NonNull;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @auther huidingc
 * @date 2018/3/16 15:00
 * @description PriorityExecutor
 * 创建线程池
 */
public class PriorityExecutor extends ThreadPoolExecutor {
    /**
     * 线程池维护线程的最少数量
     * 核心线程池大小
     */
    private static final int CORE_POOL_SIZE = 5;
    /**
     * 最大线程池队列大小
     */
    private static final int MAXIMUM_POOL_SIZE = 256;
    /**
     * 保持存活时间，当线程数大于corePoolSize的空闲线程能保持的最大时间。
     */
    private static final int KEEP_ALIVE_TIME = 1;
    /**
     * 主要获取添加任务
     */
    private static final AtomicLong SEQ_SEED = new AtomicLong(0);


    public PriorityExecutor(boolean fifo){
        this(CORE_POOL_SIZE,fifo);
    }

    /**
     * 常见几种BlockingQueue实现
     * 1. ArrayBlockingQueue :  有界的数组队列
     * 2. LinkedBlockingQueue : 可支持有界/无界的队列，使用链表实现
     * 3. PriorityBlockingQueue : 优先队列，可以针对任务排序
     * 4. SynchronousQueue : 队列长度为1的队列，和Array有点区别就是：client thread提交到block queue会是
     *    一个阻塞过程，直到有一个worker thread连接上来poll task。
     * @param poolSize
     * @param fifo
     */
    public PriorityExecutor(int poolSize, boolean fifo) {
        this(poolSize, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>(MAXIMUM_POOL_SIZE, fifo ? FIFO : LIFO), threadFactory);
    }

    public PriorityExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public PriorityExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public PriorityExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public PriorityExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    /**
     * 创建线程工厂
     */
    private static ThreadFactory threadFactory = new ThreadFactory() {
        private AtomicInteger mCount = new AtomicInteger(1);

        @Override
        public Thread newThread(@NonNull Runnable r) {
            return new Thread(r,"download#"+mCount.getAndIncrement());
        }
    };

    /**
     * 线程队列方式，先进先出
     */
    private static Comparator<Runnable> FIFO = new Comparator<Runnable>() {
        @Override
        public int compare(Runnable runnable1, Runnable runnable2) {
            if(runnable1 instanceof PriorityRunnable && runnable2 instanceof PriorityRunnable){
                PriorityRunnable r1 = (PriorityRunnable) runnable1;
                PriorityRunnable r2 = (PriorityRunnable) runnable2;
                int result = r1.priority.ordinal() - r2.priority.ordinal();
                return result == 0 ? (int) (r1.SEQ - r2.SEQ) : result;
            }else{
                return 0;
            }
        }
    };

    /**
     * 线程队列方式，后进先出
     */
    private static Comparator<Runnable> LIFO = new Comparator<Runnable>() {
        @Override
        public int compare(Runnable runnable1, Runnable runnable2) {
            if(runnable1 instanceof PriorityRunnable && runnable2 instanceof PriorityRunnable){
                PriorityRunnable r1 = (PriorityRunnable) runnable1;
                PriorityRunnable r2 = (PriorityRunnable) runnable2;
                int result = r1.priority.ordinal() - r2.priority.ordinal();
                return result == 0 ? (int) (r2.SEQ - r1.SEQ) : result;
            }else{
                return 0;
            }
        }
    };

    /**
     * 判断当前线程是否繁忙
     * @return
     */
    public boolean isBusy(){
        return getActiveCount() >= getCorePoolSize();
    }

    /**
     * 提交任务
     * @param runnable
     */
    @Override
    public void execute(Runnable runnable) {
        if(runnable instanceof PriorityRunnable){
            ((PriorityRunnable) runnable).SEQ = SEQ_SEED.getAndIncrement();
        }
        super.execute(runnable);
    }
}
