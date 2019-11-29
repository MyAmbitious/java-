package com.alex.bridge;

public class UpRightPhone extends Phone {
	
		//构造器
		public UpRightPhone(Brand brand) {
			super(brand);
		}
		
		public void open() {
			super.open();
			System.out.println(" 直立样式手机打开 ");
		}
		
		public void close() {
			super.close();
			System.out.println("直立样式手机关闭 ");
		}
		
		public void call() {
			super.call();
			System.out.println(" 直立样式手机打电话 ");
		}
}
