package com.alex.baseJava.enumdemo.itcast_02;

public class DirectionDemo {
	public static void main(String[] args) {
		Direction d = Direction.FRONT;
		System.out.println(d); // 不手动重写toString方法打印的也不是地址值 而是FRONT  这是因为enum自己重写了toString方法 返回声明中包含的此枚举常量的名称。

		System.out.println("-------------");
		Direction2 d2 = Direction2.FRONT;
		System.out.println(d2);
		System.out.println(d2.getName());
		System.out.println("-------------");
		Direction3 d3 = Direction3.FRONT;
		System.out.println(d3);
		System.out.println(d3.getName());
		d3.show();
		System.out.println("--------------");

		Direction3 dd = Direction3.FRONT;
		dd = Direction3.LEFT;

		switch (dd) {
		case FRONT:
			System.out.println("你选择了前");
			break;
		case BEHIND:
			System.out.println("你选择了后");
			break;
		case LEFT:
			System.out.println("你选择了左");
			break;
		case RIGHT:
			System.out.println("你选择了右");
			break;
		}
	}
}