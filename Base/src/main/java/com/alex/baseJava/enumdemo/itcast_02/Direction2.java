package com.alex.baseJava.enumdemo.itcast_02;

/*
 * 通过jdk5提供的枚举来做枚举类
 */
public enum Direction2 {
	FRONT("前"), BEHIND("后"), LEFT("左"), RIGHT("右");

	private String name;

	private Direction2(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


}
