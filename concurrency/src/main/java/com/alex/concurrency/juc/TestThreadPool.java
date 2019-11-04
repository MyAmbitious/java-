package com.alex.concurrency.juc;

import java.util.ArrayList;
import java.util.List;
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
public class TestThreadPool {
    public static void main(String[] args) {
        //    1 创建线程池
        final ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i < 100; i++) {
                        sum += i;
                    }
                    return sum;
                }
            });
            list.add(future);
        }
        try {
            for(Future<Integer> future:list){
                final Integer integer = future.get();
                System.out.println(integer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }

        // //    为线程池中的线程分配任务
        //     final ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        //     for(int i = 0;i<10;i++){
        //         pool.submit(threadPoolDemo);
        //     }
        // //3 关闭线程池
        //     pool.shutdown();//以一种平和的方式去关闭线程池 等待线程池中的任务都完成了 才会关闭线程池
    }
}

class ThreadPoolDemo implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (i <= 100) {
            System.out.println(Thread.currentThread().getName() + ":" + i++);
        }
    }
}