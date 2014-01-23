package com.zhch.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class NullKey {
	public void test() {
		Map a = new HashMap();
		a.put(null , "aa"); // key值可以为null
		
		System.out.println(a);
		Map b = new Hashtable();
		b.put(null , "bb"); // key值不能为null
		
		System.out.println(b);
	}

	public static void main(String[] args) {
		NullKey t = new NullKey();
		t.test();
	}
}
