package com.zhch.testGeneric;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public void test() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Integer a = 878787878;
		map.put(a, "I am a");
		map.put(new Integer(4), "I am b");
		System.out.println("a:" + map.get(a));;
		System.out.println("3 :" + map.get(878787878));
		System.out.println("Integer 3:" + map.get(new Integer(878787878)));
	}

	public static void main(String[] args) {
		TestMap t = new TestMap();
		t.test();
	}
}
