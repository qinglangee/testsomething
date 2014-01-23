package com.zhch.zhangpeng;

public class Test {

	static{
		int x = 5;
	}
	static int x,y;
	public static void main(String args[]){
		x--;
		System.out.println("x:"+x);
		myMethod();
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		System.out.println(x+y+ ++x);
		System.out.println("x:"+x);
	}
	public static void myMethod(){
		
		System.out.println("x1:"+x);
		y = x++ + ++x;
		System.out.println("x1:"+x);
		System.out.println("y1:"+y);
	}
}