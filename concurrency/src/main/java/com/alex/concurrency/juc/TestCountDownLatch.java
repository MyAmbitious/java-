package com.alex.concurrency.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 参考文章 https://www.cnblogs.com/fengzheng/p/9153720.html
 * CountDownLatch:闭锁，在完成某些运算时 只用其它所有线程的运算全部完成 当前计算才继续执行
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        final LatchDemo id = new LatchDemo(countDownLatch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(id).start();
        }
        try {
            //一个countDownLatch 算完了 就await让它等着
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        //结果是统计的时间不对 因为这10个线程是并发执行的
        System.out.println("执行这十个线程所耗费的时间为:" + (end - start) + "ms");
    }
}

class LatchDemo implements Runnable {

    private CountDownLatch countDownLatch;

    public LatchDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 50; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                countDownLatch.countDown();
            }
        }
    }
}
