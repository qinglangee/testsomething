package com.zhch.string;

public class Builder {

	/**
	 * '\0' 可以终止字符串
	 */
	public void test() {
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.append(123));

		StringBuffer ssb = new StringBuffer();
		System.out.println(ssb.append(345));

		String aa = "aa" + '\0' + '\0' + '\0' + '\0' + '\0' + '\0' + "bb";
		StringBuilder sb2 = new StringBuilder("aa");
		sb2.append('\0');
		sb2.append("bb");
		System.out.println(sb2.toString());

		System.out.println(Math.pow(2, 19));
	}

	/**
	 * setLeng 比原来短会截断<br>
	 * 比原来长会填充'\u0000', 填充后什么也append不了了
	 */
	public void setLength() {
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		sb.append("def");
		System.out.println("sb is : " + sb + " length is : " + sb.length());
		sb.setLength(0);
		sb.append("mm");
		System.out.println("sb is : " + sb + " length is : " + sb.length());
		sb.setLength(22);
		sb.append("www");
		System.out.println("sb is : " + sb + " length is : " + sb.length());
	}
	
	/**
	 *  setLength(0) 跟重新new 不知道哪个快
	 */
	public void setLengthSpeed(){
		int count =  10000;
		

		
		long startTime1 = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< count; i++){
			sb.setLength(0);
			sb.append(123456);
			sb.append("_");
			sb.append(654321);
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("endTime1 - startTime1 :"+(endTime1 - startTime1));
		
		
		
		long startTime2 = System.currentTimeMillis();
		for(int i = 0; i< count; i++){
			StringBuilder sb2 = new StringBuilder();
			sb2.append(123456);
			sb2.append("_");
			sb2.append(654321);
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println("endTime2 - startTime2 :"+(endTime2 - startTime2));
		
		
		

		long startTime3 = System.currentTimeMillis();
		StringBuilder sb3 = new StringBuilder();
		for(int i = 0; i< count; i++){
			sb3.setLength(0);
			sb3.append(123456);
			sb3.append("_");
			sb3.append(654321);
		}
		long endTime3 = System.currentTimeMillis();
		System.out.println("endTime3 - startTime3 :"+(endTime3 - startTime3));
		
		
		
	}
	

	/**
	 *  append('_') 和 + 不知道哪个快, 哪个在后边哪个快
	 */
	public void appendAndPlus(){
		int count =  1000000;
	
		long startTime1 = System.currentTimeMillis();
		for(int i = 0; i< count; i++){
			String a = "";
			a = a + "123456" + "_" + "654321";
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("endTime1 - startTime1 :"+(endTime1 - startTime1));
		
		
		long startTime2 = System.currentTimeMillis();
		for(int i = 0; i< count; i++){
			StringBuilder sb2 = new StringBuilder();
			sb2.append(123456);
			sb2.append("_");
			sb2.append(654321);
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println("endTime2 - startTime2 :"+(endTime2 - startTime2));
		
		
		
	}
	
	/**
	 *  append('_') 和append("_") 不知道哪个快, 哪个在后边哪个快
	 */
	public void appendCharAndString(){
		int count =  1000000;
		
		
		long startTime2 = System.currentTimeMillis();
		for(int i = 0; i< count; i++){
			StringBuilder sb2 = new StringBuilder();
			sb2.append('_');
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println("endTime2 - startTime2 :"+(endTime2 - startTime2));
		
		long startTime1 = System.currentTimeMillis();
		for(int i = 0; i< count; i++){
			StringBuilder sb = new StringBuilder();
			sb.append("_");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("endTime1 - startTime1 :"+(endTime1 - startTime1));
		
		
	}
	
	/**
	 * plus 是常数, 快一点
	 */
	public void plusAndAppend(){
		StringBuilder sb = new StringBuilder();
		int times = 1000000;
		
		long startTime1 = System.currentTimeMillis();
		for(int i = 0; i< times; i++){
			sb.append("abc").append("def").append("ert");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println(" plus time : " + (endTime1 - startTime1));
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i< times; i++){
			String a = "abc" + "def" + "ert";
		}
		long endTime = System.currentTimeMillis();
		System.out.println(" plus time : " + (endTime - startTime));
	}

	public static void main(String[] args) {
		Builder t = new Builder();
		t.plusAndAppend();

	}
}
