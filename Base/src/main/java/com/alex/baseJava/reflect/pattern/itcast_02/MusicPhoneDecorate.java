package com.alex.baseJava.reflect.pattern.itcast_02;

public class MusicPhoneDecorate extends PhoneDecorate {

	public MusicPhoneDecorate(Phone p) {
		super(p);
	}

	@Override
	public void call() {
		super.call();
		System.out.println("�ֻ�����������");
	}
}
