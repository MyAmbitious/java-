package com.alex.jvm.classloaderZL;

import java.util.UUID;

/**
 * 当一个常量的值并非编译器间可以确定的 那么其值就不会放到调用者的常量池中
 * 这时在程序运行的时候 会导致主动使用这个常量所在的类 显然会导致这个类被初始化
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {

    //str的值编译的时候不能确定 只有运行的时候才能确定 所以会导致MyParent3的初始化
    //像这样运行期才能确定的值 会导致目标类被初始化 所以将这样的非编译器常量放入到常量池中是无意义的
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static code");
    }
}
