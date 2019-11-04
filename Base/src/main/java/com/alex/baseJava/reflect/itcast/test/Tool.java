package com.alex.baseJava.reflect.itcast.test;

import java.lang.reflect.Field;

public class Tool {
	public void setProperty(Object obj, String propertyName, Object value)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		// ���ݶ����ȡ�ֽ����ļ�����
		Class c = obj.getClass();
		// ��ȡ�ö����propertyName��Ա����
		Field field = c.getDeclaredField(propertyName);
		// ȡ�����ʼ��
		field.setAccessible(true);
		// ������ĳ�Ա������ֵΪָ����ֵ
		field.set(obj, value);
	}
}
