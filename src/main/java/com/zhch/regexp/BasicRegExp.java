package com.zhch.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicRegExp {
	public void test() {
		
	}
	
	public void groupLongno(){
		String[] strs = {"199","999999","1999","99999","9999999","88123","891243","8812345","871234567","66123456","661234567","6712345"};
		String pattern = "199|999999|8[89]\\d{4,7}|6[6-8]\\d{5,7}";
		Pattern p = Pattern.compile(pattern);
		for(String str : strs){
			Matcher m = p.matcher(str);
			System.out.println("find " + str + " : " + m.find());
			System.out.println("match " + str + " : " + m.matches());
		}
	}
	
	public void youkuVideo(){
		Pattern p = Pattern.compile("/playlist_show/id_(.*?)\\.html");
		String url = "http://www.youku.com/playlist_show/id_19020357.html";
		Matcher m = p.matcher(url);
		System.out.println("find:" + m.find());
	}

	public static void main(String[] args) {
		BasicRegExp t = new BasicRegExp();
		t.youkuVideo();
	}
}
