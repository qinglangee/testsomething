package com.zhch.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContainsVsMap {
	/**
	 * 在ArrayList, HashSet, HashMap中查找 是否包含某个值, 快->慢 Map>Set>List
	 * 用map的containsKey()方法
	 */
	public void test() {
		List<String> a = new ArrayList<String>();
		for (int i = 10000; i < 10020; i++) {
			a.add(i + "-" + i);
		}

		Set<String> b = new HashSet<String>();
		for (int i = 10000; i < 10020; i++) {
			b.add(i + "-" + i);
		}

		Map<String, String> c = new HashMap<String, String>();
		for (int i = 10000; i < 10020; i++) {
			c.put(i + "-" + i, "a");
		}
		int count = 100000;
		long t1 = System.currentTimeMillis();
		int n1 = 0;
		for (int i = 0; i < count; i++) {
			int m = 10000 + i % 30;
			boolean like = a.contains(m + "-" + m);
			if (like) {
				n1++;
			}
		}
		long t2 = System.currentTimeMillis();
		long t3 = System.currentTimeMillis();
		int n2 = 0;
		for (int i = 0; i < count; i++) {
			int m = 10000 + i % 30;
			boolean like = b.contains(m + "-" + m);
			if (like) {
				n2++;
			}
		}
		long t4 = System.currentTimeMillis();
		long t5 = System.currentTimeMillis();
		int n3 = 0;
		for (int i = 0; i < count; i++) {
			int m = 10000 + i % 30;
			boolean like = c.get(m + "-" + m) != null;
			if (like) {
				n3++;
			}
		}
		long t6 = System.currentTimeMillis();
		long t7 = System.currentTimeMillis();
		int n4 = 0;
		for (int i = 0; i < count; i++) {
			int m = 10000 + i % 30;
			boolean like = c.containsKey(m + "-" + m);
			if (like) {
				n4++;
			}
		}
		long t8 = System.currentTimeMillis();

		System.out.println("time1:" + (t2 - t1) + " time2:" + (t4 - t3) + " time3:" + (t6 - t5)+ " time4:" + (t8 - t7));
		System.out.println("n1:" + n1 + " n2:" + n2 + " n3:" + n3+ " n4:" + n4);
	}

	public static void main(String[] args) {
		ContainsVsMap t = new ContainsVsMap();
		t.test();
	}
}
