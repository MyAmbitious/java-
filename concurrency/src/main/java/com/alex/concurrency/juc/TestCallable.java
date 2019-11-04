package com.alex.concurrency.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 参考文章 https://www.cnblogs.com/nongzihong/p/10512566.html
 * java 创建线程的方式一共有4中
 * 一、继承Thread类创建线程类
 * 二、通过Runnable接口创建线程类
 * 三、 通过Callable和Future创建线程 相较与实现Runnable接口的方式 call方法可以有返回值 抛出异常
 * 四、线程池
 * <p>
 * <p>
 * 一 二 三方式的区别
 * 采用实现Runnable、Callable接口的方式创见多线程时，优势是：
 * 线程类只是实现了Runnable接口或Callable接口，还可以继承其他类。
 * 在这种方式下，多个线程可以共享同一个target对象，所以非常适合多个相同线程来处理同一份资源的情况，从而可以将CPU、代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。
 * 劣势是：
 * <p>
 * 编程稍微复杂，如果要访问当前线程，则必须使用Thread.currentThread()方法。
 * 使用继承Thread类的方式创建多线程时优势是：
 * <p>
 * 编写简单，如果需要访问当前线程，则无需使用Thread.currentThread()方法，直接使用this即可获得当前线程。
 * <p>
 * 劣势是：
 * <p>
 * <p>
 * 线程类已经继承了Thread类，所以不能再继承其他父类。
 * <p>
 * <p>
 * 通过Callable和Future创建线程 相较与实现Runnable接口的方式的区别
 * 一,call方法可以有返回值 抛出异常
 * 二 ，执行Callable方式 需要FutureTask实现类的支持 用于接收运算结果 FutureTask 是 Future接口的实现类
 */

public class TestCallable {
    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();

        FutureTask<Integer> result = new FutureTask<>(threadDemo1);
        new Thread(result).start();


    //    可以接收线程计算后得到的结果
        try {
            final Integer sum = result.get();

            //可以发现 FutureTask 实现了类似CountDownLatch的闭锁功能
            System.out.println(sum);

            System.out.println("============================================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class ThreadDemo1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}

// class ThreadDemo0 implements Runnable{
//
//     @Override
//     public void run() {
//
//     }
// }