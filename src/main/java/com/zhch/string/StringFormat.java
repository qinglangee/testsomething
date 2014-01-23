package com.zhch.string;

public class StringFormat {
	public void test() {
		double a = 3.3445;
		String b = String.format("%.2f", a * 100) + "%";
		System.out.println(b);
	}

	public static void main(String[] args) {
		StringFormat t = new StringFormat();
		t.test();
	}
}
