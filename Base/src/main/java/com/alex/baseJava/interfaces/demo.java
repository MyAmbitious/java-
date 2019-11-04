package com.alex.baseJava.interfaces;
//接口，是Java语言中一种引用类型，是方法的集合，如果说类的内部封装了成员变量、构造方法和成员方法，那么接口的内部主要就是封装了方法，
// 包含抽象方法（JDK 7及以前），默认方法和静态方法（JDK 8），私有方法 （JDK 9）。
//接口的定义，它与定义类方式相似，但是使用 interface 关键字。它也会被编译成.class文件，但一定要明确它并 不是类，而是另外一种引用数据类型。引用数据类型：数组，类，接口。
//接口的使用，它不能创建对象，但是可以被实现（ implements ，类似于被继承）。一个实现接口的类（可以看做 是接口的子类），需要实现接口中所有的抽象方法，创建该类对象，就可以调用方法了，否则它必须是一个抽象 类。


//public interface 接口名称 { // 抽象方法 // 默认方法 // 静态方法 // 私有方法 }
//接口中，无法定义成员变量，但是可以定义常量，其值不可以改变，默认使用public static final修饰。 接口中，没有构造方法，不能创建对象。 接口中，没有静态代码块。
public interface demo {
   private static void test(){
       System.out.println("接口");
   }


    public static void test2(){
        System.out.println("接口");
    }

    public default int getSum1(){
        return 3;
    }
    public    int getSum();

    //下面两行两者等价  不带abstract关键字也会默认带有 abstract 方法必须实现
    public abstract int getAge();
    // public int getAge();

}
