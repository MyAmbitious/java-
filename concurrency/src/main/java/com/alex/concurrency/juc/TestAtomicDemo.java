package com.alex.concurrency.juc;

import java.util.concurrent.atomic.AtomicInteger;

/*
一，i++的原子性问题:
    int i =10;
    i=i++;//10 ?

    原因 ：i++的操作实际上分为三个步骤"读-改-写"
    <1> 先从内存中把i取出来放到寄存器中
    <2>然后++，
    <3>然后再把i复制到内存中，这需要至少3步
            int temp =i;
            temp=temp+1;
            i=temp
二. 原子变量：jdk1.5后 java.util.concurrent.atomic 包下提供了常用的原子变量

    1 volatile 保证内存可见性
    2 CAS (Campare-And-Swap)算法保证了数据的原子性
        CAS 算法本来是硬件对于并发惭怍共享数据的支持
        CAS 包括了三个操作数
            内存值 V：先从主存中读取一个内存值 V 记读取到的值为0
            预估值 A：等到要替换的时候  再次从主存中读取原来的旧值
            更新值 B： 当且仅当 V==A时 V=B 更新B值 否则不做任何操作
            当且仅当 V==A时 V=B 否则将不做任何操作
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        final AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 100; i++) {
            //发现serialNumber会出现重复的 这也是所谓的原子性(多线程安全)问题 改用volatile 关键字修饰也无效
            //原因 ：i++的操作分为的三个步骤 在不同的线程中，这些步骤执行不是原子性的 会导致serialNumber会出现重复的
            //而 volatile不具有互斥性  在i++的操作分为的三个步骤中 也不能保证变量的原子性
            //解决方法 使用java.util.concurrent.atomic 包下提供了常用的原子变量
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable {

    // private int serialNumber = 0;
    //使用volatile 关键字也无效
    // private volatile int serialNumber = 0;
    private AtomicInteger serialNumber = new AtomicInteger();


    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getSerialNumber();
        System.out.println(this.serialNumber);
    }

    public int getSerialNumber() {
        // return serialNumber++;
        return serialNumber.getAndIncrement();
    }
}
