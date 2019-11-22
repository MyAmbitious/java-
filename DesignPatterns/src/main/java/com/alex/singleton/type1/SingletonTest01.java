package com.alex.singleton.type1;

/**
 * 单例模式有八种方式实现
 * 1）饿汉式(静态常量)
 * 2) 饿汉式（静态代码块）
 * 3) 懒汉式(线程不安全)
 * 4) 懒汉式(线程安全，同步方法)
 * 5) 懒汉式(线程安全，同步代码块)
 * 6) 双重检查
 * 7) 静态内部类
 * 8) 枚举
 */
public class SingletonTest01 {

    public static void main(String[] args) {
        final Singleton instance = Singleton.getInstance();
        final Singleton instance2 = Singleton.getInstance();
        System.out.println(instance==instance2);
        System.out.println("instance.hashCode="+instance.hashCode());
        System.out.println("instance2.hashCode="+instance2.hashCode());
    }

}
//1）饿汉式(静态常量)
//优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
//
// 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
class Singleton{
//    构造器私有化 外部不能通过new的方式创建
    private Singleton(){
        System.out.println("本地内部创建对象实例");
    }
//    2本地内部创建对象实例
    private final static Singleton instance = new Singleton();
//    3 提供一个公有的静态方法 返回静态实例对象
    public static Singleton getInstance(){
        return instance;
    }
}
