package com.alex.baseJava.reflect.itcast_03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/*
 * 通过反射获取成员变量并使用
 */
public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		// ��ȡ�ֽ����ļ�����
		Class c = Class.forName("com.alex.baseJava.reflect.itcast_01.Person");

		// ��ȡ���еĳ�Ա����
		// Field[] fields = c.getFields();
		// Field[] fields = c.getDeclaredFields();
		// for (Field field : fields) {
		// System.out.println(field);
		// }

		/*
		 * Person p = new Person(); p.address = "����"; System.out.println(p);
		 */

		// ͨ���޲ι��췽����������
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		System.out.println(obj);

		// ��ȡ�����ĳ�Ա����
		// ��ȡaddress�����丳ֵ
		Field addressField = c.getField("address");
		// public void set(Object obj,Object value)
		// ��ָ����������ϴ� Field �����ʾ���ֶ�����Ϊָ������ֵ��
		addressField.set(obj, "北京"); // ��obj�����addressField�ֶ�����ֵΪ"����"
		System.out.println(obj);

		// ��ȡname�����丳ֵ
		// NoSuchFieldException
		Field nameField = c.getDeclaredField("name");
		// IllegalAccessException
		nameField.setAccessible(true);
		nameField.set(obj, "大傻");
		System.out.println(obj);

		// ��ȡage�����丳ֵ
		Field ageField = c.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.set(obj, 27);
		System.out.println(obj);
	}
}
