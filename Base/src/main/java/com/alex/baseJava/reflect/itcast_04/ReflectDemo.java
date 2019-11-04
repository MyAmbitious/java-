package com.alex.baseJava.reflect.itcast_04;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		// ��ȡ�ֽ����ļ�����
		Class c = Class.forName("com.alex.baseJava.reflect.itcast_01.Person");

		// 通过反射获取所有的成员方法
		// Method[] methods = c.getMethods(); // ��ȡ�Լ��İ������׵Ĺ�������
		Method[] methods = c.getDeclaredMethods(); // ��ȡ�Լ������еķ���
		for (Method method : methods) {
		System.out.println(method);
		}

		Constructor con = c.getConstructor();
		Object obj = con.newInstance();

		/*
		 * Person p = new Person(); p.show();
		 */

		// ��ȡ����������ʹ��
		// public void show()
		// public Method getMethod(String name,Class<?>... parameterTypes)
		// ��һ��������ʾ�ķ��������ڶ���������ʾ���Ƿ����Ĳ�����class����
		Method m1 = c.getMethod("show");

		// obj.m1(); // ����
		// public Object invoke(Object obj,Object... args)
		// ����ֵ��Object����,��һ��������ʾ������˭���ڶ�������ʾ���ø÷�����ʵ�ʲ���
		m1.invoke(obj); // ����obj�����m1����

		System.out.println("----------");
		// public void method(String s)
		Method m2 = c.getMethod("method", String.class);
		m2.invoke(obj, "hello");
		System.out.println("----------");

		// public String getString(String s, int i)
		Method m3 = c.getMethod("getString", String.class, int.class);
		Object objString = m3.invoke(obj, "hello", 100);
		System.out.println(objString);
		// String s = (String)m3.invoke(obj, "hello",100);
		// System.out.println(s);
		System.out.println("----------");

		// private void function()
		Method m4 = c.getDeclaredMethod("function");
		m4.setAccessible(true);
		m4.invoke(obj);
	}
}
