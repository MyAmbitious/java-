package com.alex.jvm.classloaderZL;

public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1:" + Singleton.counter1);//1
        System.out.println("counter2:" + Singleton.counter2);//10
    }

}

class Singleton {
    // public static int counter1;
    public static int counter1 = 11;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;//准备阶段的重要意义 准备阶段会为静态变量分配内存并设置初始值
        System.out.println("私有构造方法中的counter1是：" + counter1);
        System.out.println("私有构造方法中的counter2是：" + counter2);
    }

    //将其放到构造方法的下面 结果发生了变化
    public static int counter2 = 10;

    public static Singleton getInstance() {
        return singleton;
    }
    /**
     * 上述代码的执行流程
     * 先给singleton对象进行准备 singleton=null counter1=0 counter2 =0
     * 后来的getInstance 则是进行初始化 class Singleton中的代码会从上而下依次执行
     */
}