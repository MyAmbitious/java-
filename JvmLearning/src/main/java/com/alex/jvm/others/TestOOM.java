package com.alex.jvm.others;

import java.util.Random;

//先是PSYoungGen执行GC 然后PSYoungGen和ParOldGen区执行Full GC
//若ParOldGen养老区执行了Full Gc 之后发现仍然无法进行对象的保存 就会产生OOM错误

public class TestOOM {
    //-Xms10m -Xmx10m -XX:+PrintGCDetails
    public static void main(String[] args) {
        // final byte[] bytes = new byte[40 * 1024 * 1024];
        String str = "alex";
        while (true) {
            str += str + new Random().nextInt(888888888) + new Random().nextInt(999999999);
        }
    }
    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * 	at com.alex.jvm.others.TestOOM.main(TestOOM.java:5)
     */


//      [GC (Allocation Failure) [PSYoungGen: 2017K->499K(2560K)] 2017K->751K(9728K), 0.0013175 secs]
//      PSYoungGen 表示GC类型
//      2017K 是新生代GC前的内存 499K是新生代GC后新生代的内存占用大小 2560K是新生代总内存大小
//      2017K是新生代GC前堆占用空间的大小 751K是新生代GC后堆占用空间的大小 9728K是jvm堆的总大小 0.0013175 secs:新生代GC耗费时间
//    [Times: user=0.00 sys=0.00, real=0.00 secs]


//    [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4855K->4835K(7168K)] 4855K->4835K(9216K), [Metaspace: 3233K->3233K(1056768K)], 0.0070267 secs]
//
//
//
//    [Times: user=0.02 sys=0.01, real=0.01 secs]

}
