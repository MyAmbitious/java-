package com.alex.jvm.others;

/**
 * Java内存模型(即Java Memory Model，简称JMM)本身是一种抽象的概念，并不真实存在，它描述的是一组规则或规范，
 * 通过这组规范定义了程序中各个变量（包括实例字段，静态字段和构成数组对象的元素）的访问方式。
 * 由于JVM运行程序的实体是线程，而每个线程创建时JVM都会为其创建一个工作内存(有些地方称为栈空间)，
 * 用于存储线程私有的数据，而Java内存模型中规定所有变量都存储在主内存，主内存是共享内存区域，所有线程都可以访问，
 * 但线程对变量的操作(读取赋值等)必须在工作内存中进行，首先要将变量从主内存拷贝的自己的工作内存空间，然后对变量进行操作，
 * 操作完成后再将变量写回主内存，不能直接操作主内存中的变量，工作内存中存储着主内存中的变量副本拷贝，
 * 原文链接：https://blog.csdn.net/javazejian/article/details/72772461
 */
class Mynumber {
    // int age = 20;
    volatile int age = 20;

    public void setAge() {
        this.age = 1205;
    }
}

public class JMM {
    public static void main(String[] args) {
        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //
        //     }
        // });
        Mynumber mynumber = new Mynumber();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "线程 coming！" + "*****");
                Thread.sleep(3000);
                mynumber.setAge();
                System.out.println(Thread.currentThread().getName() + "\t A update number,number value:" + mynumber.age);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "aaa").start();

        while (mynumber.age == 20) {

            //aaa线程把它的mynumber里面的值改了 但是对main线程不可见 它也不告诉main线程
            //这就是jmm中 多线程之间的内容可见性 volatile可以解决此问题
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}
