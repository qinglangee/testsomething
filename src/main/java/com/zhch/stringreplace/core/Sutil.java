package com.zhch.stringreplace.core;

import java.util.regex.Pattern;

public class Sutil {
	public static String replace (String str, String regex, String replacement){
		Pattern p = Pattern.compile(regex);
		return p.matcher(str).replaceAll(replacement);
	}
	
	public void test() {
		String a = "abcd12sf55df13abcd";
		String reg = "a.*d";
		String b = a.replaceAll("[0-9]", "X");
		String c = a.replaceAll("a.*d", "P");
		String d = a.replace("a.*d", "P");
		System.out.println(b);
		System.out.println(c);
	}

	public static void main(String[] args) {
		Sutil t = new Sutil();
		t.test();
		String a = t.replace("abcdabcd", "a.*?d", "bbbd");
		System.out.println("a is :" + a);
	}
}
