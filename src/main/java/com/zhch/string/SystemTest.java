package com.zhch.string;

public class SystemTest {
	public void test() {
		String ls = System.getProperty("line.separator");
		String a = "abc" + ls + "def";
		System.out.println(a);
	}

	public static void main(String[] args) {
		SystemTest t = new SystemTest();
		t.test();
	}
}
