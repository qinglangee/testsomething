package com.zhch.longnum;

public class TestLong {
	public void parseLong() {
		System.out.println(Long.parseLong("17"));  
		System.out.println(Long.parseLong("17.0")); // 带小数点的解析会出错 
	}
	
	public void nullLong(){
		Long a = 3L;
		if(a > 8 ){
			a= 5L;
		}else{
			a = null;
			
		}
		
		// a 为空时不能用 == 判断
		System.out.println( a == 4L);
	}
	
	public void long2Int(){
		long a = Integer.MAX_VALUE +  10L;
		System.out.println(a - 3);
		int b = (int)(a - 3); // long 可以强转int, 不过太大会变负数 
		System.out.println(b);
	}
	
	public void maxLong(){
		System.out.println(Long.MAX_VALUE); // long 的最大值 9223372036854775807
		Long a = 1L;
		System.out.println(a + Long.MAX_VALUE); // 最大值加 1 变负数 -9223372036854775808
	}

	public static void main(String[] args) {
		TestLong t = new TestLong();
		t.maxLong();
	}
}
