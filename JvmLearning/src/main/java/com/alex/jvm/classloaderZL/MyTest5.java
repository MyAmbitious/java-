package com.alex.jvm.classloaderZL;

/**
 * 当一个接口和类在初始化时 并不要求其父接口都完成了初始化
 * 接口中的变量默认都是public static final的
 * final关键字 会使得常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 只有在真正使用带父接口的时候 （如引用接口所定义的常量时） 才会初始化
 *
 */
public class MyTest5 {
    public static void main(String[] args) {
        // System.out.println(MyChild5.a);
        // System.out.println(MyChild5.b);
        // System.out.println(MyChild5_1.b);
        // System.out.println(MyChild5_1.a);
        // new C();
        // new C();
        System.out.println(MyParent5_1.thread);
    }
}

interface MyGrandPa5 {
    Thread thread = new Thread(){
        {
            System.out.println("MyGrandPa5 invked");
        }
    };
    int a = 5;
}

interface MyParent5 extends MyGrandPa5{
    Thread thread = new Thread(){
        {
            System.out.println("MyParent5 invked");
        }
    };

}

interface MyChild5 extends MyParent5 {
    public static int b =6;
    /**
     * 当一个常量的值并非编译器间可以确定的 那么其值就不会放到调用者的常量池中
     * 这时在程序运行的时候 会导致主动使用这个常量所在的类 显然会导致这个类被初始化
     */
    // public static final int b = new Random().nextInt(2);
}

class MyChild5_1 implements MyParent5 {
    // public static int b = 6;
    public static final  int b = 6;
}



interface MyGrandPa5_1 {
    Thread thread = new Thread(){
        {
            System.out.println("MyGrandPa5_1 invked");
        }
    };

}
interface MyParent5_1 extends MyGrandPa5_1{
    Thread thread = new Thread(){
        {
            System.out.println("MyParent5_1 invked");
        }
    };
}

class C{
    //非静态代码块中的代码 表示是一个实例化代码块 每次对象被创建的时候就都会在构造方法之前被执行一次
    //静态代码块中的代码 只是类被加载的时候 初始化这个阶段会被调用
    //当类实例话的时候 先执行静态代码块中的内容  再执行非静态代码块的内容 最后是构造方法中的内容
    {
        System.out.println("Hello");
    }
    static {
        System.out.println("Static Hello");
    }
    public  C(){
        System.out.println("C");
    }
}