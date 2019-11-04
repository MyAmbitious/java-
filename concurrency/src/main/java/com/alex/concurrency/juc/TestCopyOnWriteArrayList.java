package com.alex.concurrency.juc;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList/CopyOnWriteArraySet ："写入并复制"
 * 其作用是 每次对此对象进行修改操作时 都会在底层复制一个新的列表 再近些重新修改操作
 *
 *
 * 源码如下
 *  public boolean add(E e) {
 *         synchronized (lock) {
 *             Object[] elements = getArray();
 *             int len = elements.length;
 *             Object[] newElements = Arrays.copyOf(elements, len + 1);
 *             newElements[len] = e;
 *             setArray(newElements);
 *             return true;
 *         }
 *     }
 *
 * 注意：添加操作多时，效率低，因为每次添加是多会进行复制 开销非常的大。在并发迭代操作多时可以选择使用它
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        for (int i = 0; i < 10; i++) {
            //会报 java.util.ConcurrentModificationException 异常
            new Thread(helloThread).start();
        }
    }
}

class HelloThread implements Runnable {
    // private static List<String> list = Collections.synchronizedList(new ArrayList<String>());
    private static List<String> list = new CopyOnWriteArrayList<String>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        /**
         * 参考文章 https://www.cnblogs.com/loong-hon/p/10256686.html
         *
         * Iterator的工作机制。Iterator是工作在一个独立的线程中，并且拥有一个 mutex锁，
         * 就是说Iterator在工作的时候，是不允许被迭代的对象被改变的。
         * Iterator被创建的时候，建立了一个内存索引表（单链表），这 个索引表指向原来的对象，当原来的对象数量改变的时候，
         * 这个索引表的内容没有同步改变，所以当索引指针往下移动的时候，便找不到要迭代的对象，于是产生错误。
         */
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add("AA");
        }
    }
}
