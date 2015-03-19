package com.zhch.temp;

public class Temp {
	public void test() {

	}

	public static void main(String[] args) {
		Temp t = new Temp();
		int n = t.stringMatch("xxcaazz", "xxbaaz");
		System.out.println(n);
	}

	public int stringMatch(String a, String b) {
		int n = 0;
		int l = a.length() > b.length() ? b.length() : a.length();
		for (int i = 0; i < l - 1; i++) {

			if (a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
				System.out.println(a.substring(i, i + 1) + "  " + b.substring(i, i + 1));
				n++;
			}
		}
		return n;
	}

}
