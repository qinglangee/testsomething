package com.zhch.math;

public class TestFloat {
	public void test() {
		float p3x = 80838.0f;
		float p2y = -2499.0f;
		double v321 = p3x * p2y;
		System.out.println(v321);
		double d1 = 80838.0f;
		double d2 = -2499.0f;
		double d3 = d1 * d2;
		System.out.println(d3);
	}

	public static void main(String[] args) {
		TestFloat t = new TestFloat();
		t.test();
	}
}
