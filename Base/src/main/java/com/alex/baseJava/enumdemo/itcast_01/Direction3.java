package com.alex.baseJava.enumdemo.itcast_01;

//多态原理 编译看左边 运行看右边
public abstract class Direction3 {
	// ��������ʵ��
	public static final Direction3 FRONT = new Direction3("前") {
		@Override
		public void show() {
			System.out.println("前");
		}

	};
	public static final Direction3 BEHIND = new Direction3("后") {
		@Override
		public void show() {
			System.out.println("后");
		}

	};
	public static final Direction3 LEFT = new Direction3("左") {
		@Override
		public void show() {
			System.out.println("左");
		}

	};
	public static final Direction3 RIGHT = new Direction3("右") {
		@Override
		public void show() {
			System.out.println("右");
		}

	};

	// ����˽�У����˾Ͳ������޵Ĵ�����
	// private Direction2() {
	// }

	// �����Ա����,��ȥ���޲ι���
	private String name;

	private Direction3(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// ������󷽷�
	public abstract void show();
}
