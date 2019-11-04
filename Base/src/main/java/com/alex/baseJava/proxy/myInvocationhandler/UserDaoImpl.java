package com.alex.baseJava.proxy.myInvocationhandler;

public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("新增功能");
	}

	@Override
	public void delete() {
		System.out.println("删除功能");
	}

	@Override
	public void update() {
		System.out.println("更新功能");
	}

	@Override
	public void find() {
		System.out.println("查找功能");
	}

}
