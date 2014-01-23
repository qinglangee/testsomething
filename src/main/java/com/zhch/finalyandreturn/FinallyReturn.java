package com.zhch.finalyandreturn;

public class FinallyReturn {
	static String a = "asdf";
	public String test() {
		try{
			return a.substring(2);
		}finally{
			a = "mmmm";
		}
	}

	public static void main(String[] args) {
		FinallyReturn t = new FinallyReturn();
		String aa = t.test();
		System.out.println(aa);
		System.out.println(a);
	}
}
