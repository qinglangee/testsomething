package com.zhch.integer;

public class ParseInteger {
	public void test() {
		int a = Integer.parseInt("0010");
		System.out.println("a is : " + a);  // a is : 10
		 a = Integer.parseInt("0010", 10);
		System.out.println("a is : " + a);  // a is : 10
		 a = Integer.parseInt("0010", 8);
		System.out.println("a is : " + a);  // a is : 8
		 a = Integer.parseInt("0010", 16);
		System.out.println("a is : " + a);  // a is : 16
		
		a = Integer.parseInt("1,000");
		System.out.println("a is : " + a);  // a is : 
	}

	public static void main(String[] args) {
		ParseInteger t = new ParseInteger();
		t.test();
	}
}
