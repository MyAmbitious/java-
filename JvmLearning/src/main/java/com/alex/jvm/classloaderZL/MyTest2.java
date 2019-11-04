package com.alex.jvm.classloaderZL;

/**
 * 加上final关键字 则常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 本质上，调用类并没有直接引用到定义常量的类 因此并不会触发定义常量的类的初始化
 * <p>
 * 注意：这里指的是 将常量str存放到了MyTest2的常量池中 之后Mytest2余Myparent2就没有任何关系了
 * 甚至 我们可以将MyParent2的class文件删除
 * <p>
 * 使用javap反编译class字节码文件 javap -c  MyTest2.class
 * <p>
 * 助记符：
 * ldc表示将int，float或是String类型的常量值从常量池中推崇到栈顶
 * bipush 表示将单字节 （-128-127）的常量值推送到栈顶
 * sipush 表示将一个短整型的常量值（-32768 - 32767）的常量值推送至栈顶
 * iconst_1 表示将int类型1推送至栈顶（iconst_m1 - iconst_5）-1到5 到了iconst_6则又变成了bipush
 *
 */
public class MyTest2 {
    public static void main(String[] args) {
        // System.out.println(Myprent2.str);// 只打印出 hello world
        // System.out.println(Myprent2.s);
        System.out.println(Myprent2.i2);
    }
}

class Myprent2 {
    public static final String str = "hello world";
    public static final short s = 7;
    public static final int i = 128;
    public static final int i1 = 6;
    public static final int i2 = -1;

    static {
        System.out.println("MyParent2 static block");
    }
}