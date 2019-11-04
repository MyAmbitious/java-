package com.alex.concurrency.juc;

/**
 *CAS模拟
 *     CAS (Campare-And-Swap)算法保证了数据的原子性
 *         CAS 算法本来是硬件对于并发惭怍共享数据的支持
 *         CAS 包括了三个操作数
 *             内存值 V：先从主存中读取一个内存值 V 记读取到的值为0
 *             预估值 A：等到要替换的时候  再次从主存中读取原来的旧值
 *             更新值 B： 当且仅当 V==A时 V=B 更新B值 否则不做任何操作
 *             当且仅当 V==A时 V=B 否则将不做任何操作
 */
public class TestCompareAndSwap {
    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final int expectedValue = cas.get();
                    final boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
                    System.out.println(b);
                }
            }).start();
        }
    }
}

class CompareAndSwap {
    private int value;

    //获取内存值
    public synchronized int get() {
        return value;
    }

    //比较
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = this.value;
        if (oldValue == expectedValue) {
            this.value = newValue;
        }
        return oldValue;
    }

    //    设置
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}

