package com.zhch.map;

import java.util.HashMap;
import java.util.Map;

public class RemoveMap {

	public void test() {
		Map<String ,String> map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("b", "b");
		System.out.println(map);
		map.remove("a");
		map.remove("c");
		System.out.println(map);
	}

	public static void main(String[] args) {
		RemoveMap t = new RemoveMap();
		t.test();
	}
}
