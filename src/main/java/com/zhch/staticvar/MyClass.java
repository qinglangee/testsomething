package com.zhch.staticvar;

import java.util.HashMap;
import java.util.Map;

public class MyClass {
	static Map<String, String> map = new HashMap<String, String>(10000000);
	public synchronized static void print(){
		map.get("key");
		System.out.println("123");
	}
}
