package com.zhch.string;

import java.io.UnsupportedEncodingException;

public class StringCharset {
	public void test() throws UnsupportedEncodingException {
		String s = "有";
		printArr(s.getBytes());
		String s1 = new String(s.getBytes(), "iso-8859-1");
		System.out.println("s1 is : " + s1);
		printArr(s1.getBytes("iso-8859-1"));
		
		String right = s1;
		System.out.println("right : "+new String(right.getBytes("iso-8859-1")));
	}

	public void printArr(byte[] arr) {
		for (byte b : arr) {
			System.out.print(b);
			System.out.print(',');
		}
		System.out.println();
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		StringCharset t = new StringCharset();
		t.test();
	}
}
