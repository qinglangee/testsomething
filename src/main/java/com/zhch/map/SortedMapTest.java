package com.zhch.map;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapTest {
	public void test() {
		SortedMap<Long, String> map = new TreeMap<Long, String>();
		map.put(3L, "m");
		map.put(2L, "b");
		map.put(4L, "u");
		map.put(5L, "v");
		map.put(1L, "e");
		
		// 不管放的顺序是什么 , entrySet会按照排好的顺序取
		for(Map.Entry e : map.entrySet()){
			System.out.println(e.getKey() + " : " + e.getValue());
		}
		
	}

	public static void main(String[] args) {
		SortedMapTest t = new SortedMapTest();
		t.test();
	}
}
