package com.alex.concurrency.juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 一,线程池 提供了一个线程队列 队列中保存着所有等待状态的线程 避免了创建于晓辉额外开销 提高了相应的速度
 * 二 线程池的体系结构
 * java.util.concurrent.Executor:负责线程的使用与调度的根接口
 *      |-- **ExcutorService 子接口:线程池的主要接口
 *            |--ThreadPoolExcutor 线程池的实现类
 *             |--ScheduledExecutorService 子接口:负责线程的调度
 *                  |--ScheduledThreadPoolExecutor：继承ThreadPoolExecutor，实现ScheduledExecutorService
 * <p>
 * 三。工具类：Executors
 * ExecutorService Executors.newFixedThreadPool(int):创建固定大小的线程池
 * ExecutorService Executors.newCachedThreadPool​(ThreadFactory threadFactory) :缓存线程池，线程池的数量不固定  可以根据需求自动的更改数量
 * ExecutorService Executors.newSingleThreadExecutor​(ThreadFactory threadFactory) 创建单个线程池 线程池中只有一个线程供人使用
 * ScheduledExecutorService newScheduledThreadPool():创建固定大小的线程 可以延迟火定时的执行任务
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        for (int i=0;i<10;i++) {
            final ScheduledFuture<Integer> schedule = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);//生成随机数
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    return num;
                }
            }, 1, TimeUnit.SECONDS);
            System.out.println(schedule.get());

        }
        pool.shutdown();

    }
}
