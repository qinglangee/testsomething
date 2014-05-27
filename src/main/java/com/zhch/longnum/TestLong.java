package com.zhch.longnum;

public class TestLong {
	public void test2() {
		System.out.println(Long.parseLong("17"));  
		System.out.println(Long.parseLong("17.0")); // 带小数点的解析会出错 
	}
	
	public void test(){
		Long a = 3L;
		if(a > 8 ){
			a= 5L;
		}else{
			a = null;
			
		}
		
		// a 为空时不能用 == 判断
		System.out.println( a == 4L);
	}
	
	public void test3(){
		long a = Integer.MAX_VALUE +  10L;
		System.out.println(a - 3);
		int b = (int)(a - 3); // long 可以强转int, 不过太大会变负数 
		System.out.println(b);
	}

	public static void main(String[] args) {
		TestLong t = new TestLong();
		t.test3();
	}
}
