package com.alex.concurrency.juc;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;
//ForkJoin框架 jdk1.7 之后出来的
//jdk 1.8 对其进行的改进 可以很方便的使用 lambda表达式写出来

/**
 * 参考文章 https://segmentfault.com/a/1190000016781127
 *
 * 假设有个非常大的long[]数组，通过FJ框架求解数组所有元素的和。
 */
public class TestForkJoinPool {
    public static void main(String[] args) {
        Instant start = Instant.now();
        final ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 50000000000L);
        final Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("共耗费时间："+ Duration.between(start,end).toMillis());//18070ms

    }

    @org.junit.jupiter.api.Test
    public void test1(){
        Instant start = Instant.now();
        long sum = 0L;
        for(long i = 0L ;i<=50000000000L;i++){
            sum+=i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("共耗费时间："+ Duration.between(start,end).toMillis());//16869ms
    }

    //java8 新特性
    @org.junit.jupiter.api.Test
    public void testJdk8(){
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0L,50000000000L)
                .parallel()
                .reduce(0L,Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("共耗费时间："+ Duration.between(start,end).toMillis());//13747ms
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {
    private long start;
    private long end;
    private static final long THURSHOLD = 10000L; //临界值

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long length = end - start;
        //当小于临界值的时候 不再继续拆分 直接循环计算中和
        if (length <= THURSHOLD) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;

            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
            left.fork();//进行拆分，同时压入线程队列
            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
            right.fork();//
            return left.join() + right.join();
        }

    }
}