package com.alex.concurrency.juc;
/**
 * java线程内存模型 jmm 线程、工作内存、主内存
 *
 * 所有线程共享主内存，每个线程有自己的工作内存
 *
 * 线程的working memory 工作内存是cpu的寄存器和高速缓存的抽象描述：
 *
 * 现在的计算机，cpu在计算的时候，并不总是从内存读取数据，它的数据读取顺序优先级 是：寄存器－高速缓存－内存。线程耗费的是CPU，线程计算的时候，
 * 原始的数据来自内存，在计算过程中，有些数据可能被频繁读取，这些数据被存储在寄存器和高速缓存中，当线程计算完后，这些缓存的数据在适当的时候应该写回内存。
 * 当多个线程同时读写某个内存数据时，就会产生多线程并发问题，涉及到三个特 性：原子性，有序性，可见性。
 * 支持多线程的平台都会面临 这种问题，运行在多线程平台上支持多线程的语言应该提供解决该问题的方案。
 * 原文链接：https://blog.csdn.net/majiawenzzz/article/details/81122498
 */

/**
 * volatile 底层原理 https://blog.csdn.net/zezezuiaiya/article/details/81456060
 * volatile 关键字：当多个线程进行共享数据是 可以保证内存中的数据可见 相较于synchronized关键字是一种较为轻量级的同步策略
 *
 * 注意
 * 1 volatile不具有互斥性
 * 2 volatile不能保证变量的原子性
 */
public class TestVolatile {
    public static void main(String[] args) {
        final ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        //内存可见性问题  当多个线程操作共享数据时 彼此不可见
        //main线程先从主存中读取flag 因为while (true) 底层代码执行速度非常快 所以等不到另一个线程修改flag值 读取到的flag一致是false
        //即使另一个线程修改flag为true的时候 mian线程也不会再次从主存中读取新的flag值 而是会一致读取自己线程里已将缓存的旧的flag值(false)
        while (true) {
            //synchronized同步锁 每次都刷新main线程的缓存 可以使main线程重复的从主存中读取数据
            // 加上锁的代价太大 改用volatile关键字
            /*
            volatile通常被比喻成"轻量级的synchronized"，也是Java并发编程中比较重要的一个关键字。和synchronized不同，volatile是一个变量修饰符，只能用来修饰变量。无法修饰方法及代码块等。
            volatile的用法比较简单，只需要在声明一个可能被多线程同时访问的变量时，使用volatile修饰就可以了。
             */
            // synchronized (td){
            //     if (td.isFlag()) {
            //         System.out.println("------------------------");
            //         break;
            //     }
            // }

            if (td.isFlag()) {
                System.out.println("------------------------");
                break;
            }
        }
    }

}

class ThreadDemo implements Runnable {
    // private  boolean flag = false;
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.flag = true;
        System.out.println("flag=" + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }
}