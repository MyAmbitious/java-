package com.alex.baseJava.reflect.itcast_01;

/*
反射：就是通过class文件对象 去使用该文件中的成员变量，构造和成员方法
先获得class文件对象 其实也就是得到class类的对象
Claass类：
	成员变量：Filed
	构造方法：Constructor
	成员方法：Method
获取class类中的静态方法
	1:Object类中的getClass()方法
	2:数据类型的静态属性class
	3：Class类中的静态方法 className必须是类的全路径
		public static Class forName(String className)

 */
public class ReflectDemo {
	public static void main(String[] args) throws ClassNotFoundException {

		Person p = new Person();
		Class c = p.getClass();

		Person p2 = new Person();
		Class c2 = p2.getClass();

		System.out.println(p == p2);// false
		System.out.println(c == c2);// true


		Class c3 = Person.class;
		// int.class;
		// String.class;
		System.out.println(c == c3);


		// ClassNotFoundException
		Class c4 = Class.forName("com.alex.baseJava.reflect.itcast.test.Person");
		System.out.println(c == c4);
	}
}
