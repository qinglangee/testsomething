package com.zhch.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsUtil {
	public void test() {
		List<Integer>  a = new ArrayList<Integer>();
		a.add(1);
		a.add(5);
		a.add(8);
		a.add(3);
		a.add(4);
		System.out.println(a);
		Collections.sort(a);   // sort会直接改变参数 
		System.out.println(a);
	}

	public static void main(String[] args) {
		CollectionsUtil t = new CollectionsUtil();
		t.test();
	}
}
