package com.alex.baseJava.enumdemo.itcast_03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
		// ������������
		int x = 0b100101;
		System.out.println(x);
		// �������������Գ����»���
		int y = 1_1123_1000;
		// ���ܳ����ڽ��Ʊ�ʶ����ֵ֮��
		int z = 0x111_222;
		// ���ܳ�������ֵ��ͷ�ͽ�β
		int a = 0x11_22;
		// ���ܳ�����С�����Ա�
		double d = 12.3_4;
		// switch ���������ַ���?�Լ��ع�
		// ���ͼ�
		ArrayList<String> array = new ArrayList<>();
		// �쳣�Ķ��catch�ϲ�
		method();
	}

	private static void method() {
		// try-with-resources ���
		// try(������java.lang.AutoCloseable���������){��}

		try {
			FileReader fr = new FileReader("a.txt");
			FileWriter fw = new FileWriter("b.txt");
			int ch = 0;
			while ((ch = fr.read()) != -1) {
				fw.write(ch);
			}
			fw.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// �Ľ���Ĵ���
		try (FileReader fr = new FileReader("a.txt");
				FileWriter fw = new FileWriter("b.txt");) {
			int ch = 0;
			while ((ch = fr.read()) != -1) {
				fw.write(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
