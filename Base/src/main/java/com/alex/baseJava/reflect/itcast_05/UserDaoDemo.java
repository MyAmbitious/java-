package com.alex.baseJava.reflect.itcast_05;

public class UserDaoDemo {
	public static void main(String[] args) {
		// �������û�����
		UserDao ud = new UserDaoImpl();
		ud.add();
		ud.delete();
		ud.update();
		ud.find();
		System.out.println("---------");

		UserDao ud2 = new UserDaoImpl2();
		ud2.add();
		ud2.delete();
		ud2.update();
		ud2.find();

		System.out.println("---------");
		StudentDao sd = new StudentDaoImpl();
		sd.login();
		sd.regist();
		System.out.println("---------");
		// ��ʵ������Ӧ����������ӵ�:
		// ��ÿ������ִ��ǰ��Ӧ�ÿ������Ƿ���Ȩ�޽����������
		// ˭�����������������ø������¼�¼
		StudentDao sd2 = new StudentDaoImpl2();
		sd2.login();
		sd2.regist();
	}
}
