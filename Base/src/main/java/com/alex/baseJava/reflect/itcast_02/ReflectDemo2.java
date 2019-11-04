package com.alex.baseJava.reflect.itcast_02;

import java.lang.reflect.Constructor;

/*
 * ����ͨ������ȥ��ȡ�ù��췽����ʹ�ã�
 * public Person(String name, int age, String address)
 * 
 * Person p = new Person("����ϼ",27,"����");
 * System.out.println(p);
 */
public class ReflectDemo2 {
	public static void main(String[] args) throws Exception {
		// ��ȡ�ֽ����ļ�����
		Class c = Class.forName("com.alex.baseJava.reflect.itcast_01.Person");

		// ��ȡ���ι��췽������
		// public Constructor<T> getConstructor(Class<?>... parameterTypes)
		Constructor con = c.getConstructor(String.class, int.class,
				String.class);

		// ͨ�����ι��췽�����󴴽�����
		// public T newInstance(Object... initargs)
		Object obj = con.newInstance("大傻", 27, "北京");
		
		System.out.println(obj);
	}
}
