package com.alex.proxy.dynamic;

/**
 * 动态代理
 * 动态代理模式的基本介绍
 * 1) 代理对象,不需要实现接口，但是目标对象要实现接口，否则不能用动态代理
 * 2) 代理对象的生成，是利用JDK的API，动态的在内存中构建代理对象
 * 3) 动态代理也叫做：JDK代理、接口代理
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建目标对象
		ITeacherDao target = new TeacherDao();
		
		//给目标对象，创建代理对象, 可以转成 ITeacherDao
		ITeacherDao proxyInstance = (ITeacherDao)new ProxyFactory(target).getProxyInstance();
	
		// proxyInstance=class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
		System.out.println("proxyInstance=" + proxyInstance.getClass());
		
		//通过代理对象，调用目标对象的方法
		proxyInstance.teach();
		
		proxyInstance.sayHello(" tom ");
	}

}