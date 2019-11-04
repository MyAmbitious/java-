package com.alex.concurrency.juc;

/**
 * 判断打印出来的是"one" or "two"
 * <p>
 * 八锁理论
 * 1 两个普通同步方法 两个线程 标椎打印 结果是 one two
 * 2 新增非同步方法sleep方法在getOne()中 让其睡眠1s 结果还是 one two
 * 3 新增一个普通非同步方法getThree 再新增一个线程进行调用 结果是  three one two
 * 4 两个普通同步方法 两个Number 对象 ，打印结果  two three  one
 * 5 修改getOne()为静态同步方法   一个Number 对象 打印结果 two three  one
 * 6 修改getOne() getTwo() 均为静态同步方法   一个Number 对象 打印结果  three  one two
 * 7 修改getOne()为静态同步方法   getTwo() 为普通同步方法  两个Number 对象 ，打印结果  two three  one
 * 8 修改getOne() getTwo() 均为静态同步方法  两个Number 对象 ，打印结果   three  one two
 *
 * 线程八锁的关键：
 * 1 非静态方法的锁默认为 this 静态方法的锁为 对应的Class实例
 * 2 在某个时刻内 只能有一个线程持有锁 无论几个方法
 * 3
 */
public class TestThread8Monitor {

    public static void main(String[] args) {
        Number number = new Number();
        Number number2 = new Number();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getOne();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // number.getTwo();
                number2.getTwo();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getThree();
            }
        }).start();
    }
}

class Number {
    //改成静态的
    public static synchronized void getOne() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }

    public void getThree() {
        System.out.println("three");
    }
}