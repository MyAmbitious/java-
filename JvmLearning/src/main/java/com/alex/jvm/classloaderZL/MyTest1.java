package com.alex.jvm.classloaderZL;
/**
 * 所有的java虚拟机实现必须在每个类或接口被java程序“首次主动使用”时才初始化他们
 * 主动使用的七中情况
 * 1 创建类的实例
 * 2 访问某个类或者接口的静态变量，或者对该静态变量赋值
 * 3 调用类的静态方法
 * 4 反射
 * 5 初始化一个类的子类
 * 6 java虚拟机启动时被标明为启用类的类 main JavaTest
 * 7 jdk1.7 开始提供的动态语言支持：
 * java.lang.invoke.MethodHandle实例的解析结果REF_getStatic,REF_putStatic,
 * REF_invokeStatic句柄对应的类没有初始化 则初始化
 */


/**
 *
 * 第一次的输出结果说明
 * 对于静态字段来说 只有直接定义了该字段的类才会被初始化
 *
 * 第二次是对MyChild1 中的静态变量访问 属于主动使用 但是初始化一个类的子类，其父类会被先初始化
 * 既当一个类在初始化时 要求其父类全部都已经初始化完毕了
 *
 * -XX:+TraceClassLoading 用于追踪类的加载信息并且打印出来
 *-XX:+TraceClassUnLoading 用于追踪类的卸载信息并且打印出来
 *
 * -XX:+<option>    表示开启option选项
 * --XX:-<option>   表示关闭option选项
 * --XX:<option>=<value> 表示将option的值设置为value
 *
 */
public class MyTest1 {
    public static void main(String[] args) {
        // System.out.println(MyChild1.str);
        //其打印结果
        // MyParent1 static block
        // hello world
        //    MyChild1 中的静态代码块并未执行

        System.out.println(MyChild1.str1);
        /**把str编程str1
         * 其打印结果
         * MyParent1 static block
         * MyChild1 static block
         * hello worl
         */
    }
}

class MyParent1 {
    public static String str = "hello world";

    //静态代码块 类加载  初始化的时候执行
    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str1 = "hello world";

    static {
        System.out.println("MyChild1 static block");
    }
}