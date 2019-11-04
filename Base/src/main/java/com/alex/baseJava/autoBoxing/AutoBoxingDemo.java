package com.alex.baseJava.autoBoxing;

public class AutoBoxingDemo {
    public static void main(String[] args) {
        Integer a = 120;
        int b= 120;
        Integer c = 120; ////自动装箱。相当于Integer c = Integer.valueOf(120);
        Integer d = new Integer(120);

        //可以看到变量a、c在初始化的时候编译器调用了valueOf进行自动装箱，

        // 在a==b时对变量a调用了intValue()方法进行了自动拆箱操作，这就很好解释t1~t4的结果了。

        //t1产生的原因是编译器编译时会调用intValue()自动的将a进行了拆箱，结果肯定是true;
        System.out.println(a == b);   //true    t1

        /**
         * t2跟t4的结果比较难理解：这是因为初始化时，编译器会调用装箱类的valueOf()方法,查看jdk的源码：
         * public static Integer valueOf(int i) {
         *     assert IntegerCache.high >= 127;
         *     if (i >= IntegerCache.low && i <= IntegerCache.high)
         *         return IntegerCache.cache[i + (-IntegerCache.low)];
         *     return new Integer(i);
         * }
         *
         *
         * 发现jdk对-128~127之间的值做了缓存，对于-128~127之间的值会取缓存中的引用,通过缓存经常请求的值而显著提高空间和时间性能。
         * 这就能解释t2结果返回true，而t4由于128不在缓存区间内，编译器调用valueOf方法会重新创建新的对象，两个不同的对象返回false。
         *
         * t3结果无论如何都不会相等的，因为new Integer(120)构造器会创建新的对象。
         *
         * Byte、Short、Integer、Long、Char这几个装箱类的valueOf()方法都会做缓存，而Float、Double则不会，原因也很简单，因为byte、Short、integer、long、char在某个范围内的整数个数是有限的，但是float、double这两个浮点数却不是。
         * 原文链接：https://blog.csdn.net/chengbinbbs/article/details/78973453
         */
        System.out.println(a == c);   //true    t2
        System.out.println(a == d);   //false   t3

        Integer e = 128;
        Integer f = 128;
        System.out.println(e == f);   //false    t4
    }
}
