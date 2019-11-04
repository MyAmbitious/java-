package com.alex.baseJava.enumdemo.itcast_01;

public class Direction {
	// 创建几个实例
	public static final Direction FRONT = new Direction();
	public static final Direction BEHIND = new Direction();
	public static final Direction LEFT = new Direction();
	public static final Direction RIGHT = new Direction();

	// 构造私有 别人就不能无限创建了
	private Direction() {
	}
}