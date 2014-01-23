package com.zhch.logic;

public class TestBoolean {
	public void test() {
		System.out.println(true || false && true);
		System.out.println(true || false && false);
		System.out.println(false || false && true);
		System.out.println(false || false && false);
		System.out.println(false || true && true);
		System.out.println(false || true && false);
	}

	public static void main(String[] args) {
		TestBoolean t = new TestBoolean();
		t.test();
	}
}
