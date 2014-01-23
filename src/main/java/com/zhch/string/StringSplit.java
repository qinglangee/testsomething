package com.zhch.string;

public class StringSplit {
	public void test() {
		String a = "1,2,3";
		String b = "1,,";
		String c = ",,s";
		String d = ",,,";
		System.out.println("a.split:" + a.split(",").length);
		System.out.println("b.split:" + b.split(",").length);
		System.out.println("c.split:" + c.split(",").length);
		System.out.println("d.split:" + d.split(",").length);
	}

	public static void main(String[] args) {
		StringSplit t = new StringSplit();
		t.test();
	}
}
