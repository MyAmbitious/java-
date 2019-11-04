package com.alex.baseJava.reflect.itcast.test;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/*
 * ͨ�������ļ��������еķ���
 * 
 * ���䣺
 * 		��Ҫ�������ļ����ʹ�á�
 * 		��class.txt���档
 * 		������֪������������
 * 			className
 * 			methodName
 */
public class Test {
	public static void main(String[] args) throws Exception {
		// ����ǰ������
		// Student s = new Student();
		// s.love();
		// Teacher t = new Teacher();
		// t.love();
		// Worker w = new Worker();
		// w.love();
		// ����������

		// ���ؼ�ֵ������
		Properties prop = new Properties();
		FileReader fr = new FileReader("I:\\idea\\javaBase\\Base\\src\\main\\java\\com\\alex\\baseJava\\class.txt");
		prop.load(fr);
		fr.close();

		// ��ȡ����
		String className = prop.getProperty("className");
		String methodName = prop.getProperty("methodName");

		// ����
		Class c = Class.forName(className);

		Constructor con = c.getConstructor();
		Object obj = con.newInstance();

		// ���÷���
		Method m = c.getMethod(methodName);
		m.invoke(obj);
	}
}