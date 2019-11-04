package com.alex.baseJava.proxy.myInvocationhandler;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void login() {
		System.out.println("登录校验");
	}

	@Override
	public void regist() {
		System.out.println("注册校验");
	}

}
