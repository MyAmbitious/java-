package com.alex.singleton.type8;


/*
 * jdk5新特性 枚举
 *
 *
 * 定义枚举类要用关键字enum
	所有枚举类都是Enum的子类
	枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的，但是如果枚举类有其他的东西，这个分号就不能省略。建议不要省略
	枚举类可以有构造器，但必须是private的，它默认的也是private的。枚举项的用法比较特殊：枚举("");
	枚举类也可以有抽象方法，但是枚举项必须重写该方法

 */


//借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。可能是因为枚举在JDK1.5中才添加，
// 所以在实际项目开发中，很少见人这么写过。
//
// 优点
//
// 系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能。
//
// 缺点
//
// 当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new，可能会给其他开发人员造成困扰，特别是看不到源码的时候。
//
// 适用场合
//
// 需要频繁的进行创建和销毁的对象；
// 创建对象时耗时过多或耗费资源过多，但又经常用到的对象；
// 工具类对象；
// 频繁访问数据库或文件的对象。
public class  SingletonTest08{
    public static void main(String[] args) {
        final Singleton instance = Singleton.INSTANCE;
        final Singleton instance1 = Singleton.INSTANCE;
        System.out.println(instance==instance1);
        System.out.println("instance.hashCode()="+instance.hashCode());
        System.out.println("instance1.hashCode()="+instance1.hashCode());
        instance.SayOk();
    }
}
enum Singleton {
    INSTANCE();
    public void SayOk() {
        System.out.println("OK~~~~~~~~~~~~");
    }
}