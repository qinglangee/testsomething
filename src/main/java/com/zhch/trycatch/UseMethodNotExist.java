package com.zhch.trycatch;

public class UseMethodNotExist {
	public void test() {
		try {
			MethodNotExist.aa();
		} catch (Exception e) {
			System.out.println("catch a exception");
		} catch (Error e) { // 注释掉MethodNotExist的aa()方法, 这里会捕捉到一个Error, 因为它不是Exception
			System.out.println("catch a error");
		}
	}

	public static void main(String[] args) {
		UseMethodNotExist t = new UseMethodNotExist();
		t.test();
	}
}
