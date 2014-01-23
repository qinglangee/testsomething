package com.zhch.nouse;

public class PrintNumber {
	public void test() {
		for(int i=5001;i<5099;i++){
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		PrintNumber t = new PrintNumber();
		t.test();
	}
}
