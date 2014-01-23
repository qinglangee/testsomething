package com.zhch.java;

public class AndOr {
	public boolean a(){
		System.out.println("a");
		return false;
	}
	public boolean b(){
		System.out.println("b");
		return false;
	}
	public void test() {
		boolean a = a() && b();
		System.out.println("===");
		boolean b = a() || b();
		
		System.out.println("a:" + a + " b:" + b);
	}

	public static void main(String[] args) {
		AndOr t = new AndOr();
		t.test();
	}
}
