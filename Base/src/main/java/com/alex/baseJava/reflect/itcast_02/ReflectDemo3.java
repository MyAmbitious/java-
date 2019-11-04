package com.alex.baseJava.reflect.itcast_02;

import java.lang.reflect.Constructor;

/*
 * 需求：通过反射获取私有构造方法并使用
 * private Person(String name){}
 * 
 * Person p = new Person("������");
 * System.out.println(p);
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		// ��ȡ�ֽ����ļ�����
		Class c = Class.forName("com.alex.baseJava.reflect.itcast_01.Person");

		// ��ȡ˽�й��췽������
		// NoSuchMethodException��ÿ����������쳣
		// ԭ����һ��ʼ����ʹ�õķ���ֻ�ܻ�ȡ�����ģ��������ַ�ʽ�Ϳ����ˡ�
		Constructor con = c.getDeclaredConstructor(String.class);

		// �ø�˽�й��췽����������
		// IllegalAccessException:�Ƿ��ķ����쳣��
		// ��������
		con.setAccessible(true);//设置true 可以访问java对象中的私有方法
		Object obj = con.newInstance("大傻");

		System.out.println(obj);
	}
}