package com.alex.bridge;


//折叠式手机类 继承抽象类 Phone
public class FoldedPhone extends Phone {

	//构造器
	public FoldedPhone(Brand brand) {
		super(brand);
	}

	public void open() {
		super.open();
		System.out.println(" 折叠式手机打开了 ");
	}

	public void close() {
		super.close();
		System.out.println(" 折叠式手机关闭 ");
	}

	public void call() {
		super.call();//先调用父类进行call
		System.out.println(" 折叠式手机打电话 ");
	}
}
