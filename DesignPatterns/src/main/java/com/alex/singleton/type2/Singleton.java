package com.alex.singleton.type2;
//2、饿汉式（静态代码块)
public class Singleton {

    private static Singleton instance;
    static {
        instance = new Singleton();
    }
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }


    //这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，
    // 也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和1）饿汉式(静态常量)是一样的。
    public static void main(String[] args) {
        final Singleton instance = Singleton.getInstance();
        final Singleton instance1 = Singleton.getInstance();
        System.out.println(instance ==instance1);
        System.out.println("instance.hashCode="+ Singleton.instance.hashCode());
        System.out.println("instance1.hashCode="+instance1.hashCode());
    }
}