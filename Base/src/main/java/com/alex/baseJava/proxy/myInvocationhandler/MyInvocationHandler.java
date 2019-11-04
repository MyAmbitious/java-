package com.alex.baseJava.proxy.myInvocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	private Object target; // 目标对象 对目标进行代理

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//代理方法中新增权限校验 和  日志记录功能
		System.out.println("权限校验");
		//代理对象调用原对象中方法
		Object result = method.invoke(target, args);
		System.out.println("日志记录");
		return result; //返回的是代理对象
	}
}
