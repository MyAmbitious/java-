package com.alex.concurrency.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class TestProductorAndCousumerForLock {
    public static void main(String[] args) {
        final Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        final Consumer consumer = new Consumer(clerk);
        //不使用等待唤醒机制的话 当生产者生产数据过快 接收方已经接收不到了 造成了数据丢失的情况
        // 消费者消费数据过快的话 可能就会消费重复或者错误的数据

        //增加上产者消费者数量 可能会出现卖出负数票的情况
        //线程也可以唤醒，而不会被通知，中断或超时，即所谓的虚假唤醒 。 虽然这在实践中很少会发生，但应用程序必须通过测试应该
        // 使线程被唤醒的条件来防范，并且如果条件不满足则继续等待。 换句话说，等待应该总是出现在循环中
        new Thread(productor, "生产者A").start();
        new Thread(consumer, "消费者B").start();
        new Thread(productor, "生产者C").start();
        new Thread(consumer, "消费者D").start();
    }
}

//店员类
class Clerk {
    private int product = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //进货
    public void get() {
        //这里的this.wait() 对应的是Condition对象
        lock.lock();
        try {
            while (product >= 1) {
                System.out.println("商品已满");
                try {
                    condition.await();
                    // this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + ++product);
            // lock.unlock();
            condition.signalAll();
        } finally {
           this.lock.unlock();
        }

    }

    //    卖货
    public void sale() {
        lock.lock();
        try {
            while (product <= 0) {
                System.out.println("缺货！");
                try {
                    // this.wait();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            // lock.unlock();
            condition.signalAll();
        } finally {
            this.lock.unlock();
        }

    }
}

//生产者
class Productor implements Runnable {

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.clerk.get();
        }
    }
}

//消费者
class Consumer implements Runnable {


    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.clerk.sale();
        }
    }
}
