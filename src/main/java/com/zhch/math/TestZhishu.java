package com.zhch.math;

public class TestZhishu {
	public void test() {
		for(int i=1;i<100;i++){
			int j = 0;
			for(j=2;j<i;j++){
				if (i % j == 0){
					break;
				}
					
			}
			if(i==j){
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		TestZhishu t = new TestZhishu();
		t.test();
	}
}
