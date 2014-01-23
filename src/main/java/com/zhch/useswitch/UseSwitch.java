package com.zhch.useswitch;

public class UseSwitch {
	public void test(int a) {
		switch(a){
		case 2:
			System.out.println(2);
		case 1:
			System.out.println("1");
		case 3:
			System.out.println(3);
		default:
			System.out.println("default");
		}
	}

	public static void main(String[] args) {
		UseSwitch t = new UseSwitch();
		t.test(2);
	}
}
