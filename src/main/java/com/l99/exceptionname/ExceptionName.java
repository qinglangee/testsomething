package com.l99.exceptionname;

public class ExceptionName {
	public void test() {
		java.lang.UnsatisfiedLinkError e = new java.lang.UnsatisfiedLinkError();
	}

	public static void main(String[] args) {
		ExceptionName t = new ExceptionName();
		t.test();
	}
}
