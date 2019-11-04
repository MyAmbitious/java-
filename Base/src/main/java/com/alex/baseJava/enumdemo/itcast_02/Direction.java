package com.alex.baseJava.enumdemo.itcast_02;

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
public enum Direction {
	FRONT, BEHIND, LEFT, RIGHT
}
