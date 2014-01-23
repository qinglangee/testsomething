package com.zhch.longnum;

public class TestLong {
	public void test2() {
		Long.parseLong("17.0");
	}
	
	public void test(){
		Long a = 3L;
		if(a > 8 ){
			a= 5L;
		}else{
			a = null;
			
		}
		System.out.println( a == 4L);
	}

	public static void main(String[] args) {
		TestLong t = new TestLong();
		t.test();
	}
}
