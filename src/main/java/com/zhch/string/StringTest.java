package com.zhch.string;

public class StringTest {
	public void test() {
		String c = null;
		Object a = c;
		String b = (String)a; // 把一个null转化为String是没有什么问题的
		System.out.println(b);
	}

	public static void main(String[] args) {
		StringTest t = new StringTest();
		t.test();
	}
}
