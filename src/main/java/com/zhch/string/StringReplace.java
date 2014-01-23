package com.zhch.string;

import org.apache.commons.lang.StringUtils;

public class StringReplace {
	public void testPlainReplace() {
		String content = "sjf＠lj＠sl＠fs＠l@";
		System.out.println(content);
		String newContent = content.replace('＠', '@');
		System.out.println(newContent);
		String newContent2 = content.replace("＠", "@");
		System.out.println(newContent2);
		String newContent3 = content.replaceAll("＠", "@");
		System.out.println(newContent3);
		
		
		String a = "asdfsafasdf@sfasf";
		String[] b = StringUtils.split(a, '@');
		System.out.println("b.length: "+b.length);
		for(String s : b){
			System.out.println(s);
		}
	}
	
	public  void testRegReplace(){
		String a = "abcd${lx-br}{la-br}efghi${lx-as-0}jklmnop${lx-ae-2}qrst${lx-image-0}uvw${lx-image-34}xyz";
		System.out.println(a);
		String b = a.replace("${lx-", "");
		System.out.println(b);
		String c = a.replaceAll("\\$\\{lx-.{2,15}?\\}", "");
		System.out.println(c);
		
	}

	public static void main(String[] args) {
		StringReplace t = new StringReplace();
		t.testRegReplace();
	}
}
