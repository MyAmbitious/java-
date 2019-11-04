package com.alex.concurrency.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序 开启三个线程 这三个线程的ID分别是 A.B.C 每个线程将自己的ID在屏幕上打印10遍
 * 要求输出的结果必须按照顺序显示
 * 如： ABCABCABC..... 依次递归
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        ALternateDemo ad = new ALternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        ad.loopA(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        ad.loopB(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        ad.loopC(i);
                        System.out.println("---------------------------------");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "C").start();
    }
}

class ALternateDemo {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int totalLoop) throws InterruptedException {
        //totalLoop 表示打印的是第几轮
        lock.lock();
        try {
            //1 判断
            if (number != 1) {
                condition1.await();
            }
            //    打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            //    3 唤醒
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop) throws InterruptedException {
        lock.lock();
        try {
            //1 判断
            if (number != 2) {
                condition2.await();
            }
            //    打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            //    3 唤醒
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop) throws InterruptedException {
        lock.lock();
        try {
            //1 判断
            if (number != 3) {
                condition3.await();
            }
            //    打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            //    3 唤醒
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}