package com.alex.baseJava.reflect.itcast_02;

import com.alex.baseJava.reflect.itcast_01.Person;

import java.lang.reflect.Constructor;

/*
 * 通过反射获取构造方法并使用
 */
public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		// 获取字节码文件对象
		Class c = Class.forName("com.alex.baseJava.reflect.itcast_01.Person");

		// 获取构造方法
		// public Constructor[] getConstructors():拿到所有公共的构造方法
		// public Constructor[] getDeclaredConstructors(): 所有构造方法
		// Constructor[] cons = c.getDeclaredConstructors();
		// for (Constructor con : cons) {
		// 	System.out.println(con);
		// }

		// 获取单个构造方法
		// public Constructor<T> getConstructor(Class<?>... parameterTypes)
		// 参数表示的是:你要获取的构造参数个数和数据类型的class字节码对象
		Constructor con = c.getConstructor();//返回的构造方法对象

		// Person p = new Person();
		// System.out.println(p);
		// public T newInstance(Object... initargs)
		// 使用此 Constructor 对象表示的构造方法来创建该构造方法声明类的新实例，并用指定的吃时候参数初始化该方法
		Object obj = con.newInstance();
		System.out.println(obj);
		
		 Person p = (Person)obj;
		 p.show();
	}
}
