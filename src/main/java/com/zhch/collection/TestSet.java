package com.zhch.collection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
	public void test() {
		Set<String> set = new HashSet<String>(1);
		set.add("aa");
		set.add("bb");
		set.add("cc");
		System.out.println(set);
	}

	public static void main(String[] args) {
		TestSet t = new TestSet();
		t.test();
	}
}
