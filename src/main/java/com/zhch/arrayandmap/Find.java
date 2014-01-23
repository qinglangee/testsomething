package com.zhch.arrayandmap;

import java.util.Random;
import java.util.TreeSet;

public class Find {
	TreeSet<Integer> l99Ids;
	Integer[] idsArray;
	Find(){
		l99Ids = new TreeSet<Integer>();
	}
	public void test() {
		int total = 100000;
		int arr = 10000;
		for(int i = 0 ; i < total; i ++){
			add(i);
		}
		Integer[] ints = new Integer[arr];
		Random r = new Random();
		for(int i = 0; i < arr; i++){
			ints[i] = r.nextInt(total);
		}
		long t1 = System.currentTimeMillis();
		for(Integer i : ints){
			boolean a = find(i);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("time1:" + (t2-t1));
		long t3 = System.currentTimeMillis();
		for(Integer i : ints){
			boolean a = l99Ids.contains(i);
		}
		long t4 = System.currentTimeMillis();
		System.out.println("time2:" + (t4-t3));
	}

	public static void main(String[] args) {
		Find t = new Find();
		t.test();
	}
	public Integer[] getIdsArray() {
		if (idsArray != null) {
			return idsArray;
		} else {
			idsArray = l99Ids.toArray(new Integer[l99Ids.size()]);
			return idsArray;
		}
	}
	public void add(final Integer l99Id) {
		l99Ids.add(l99Id);
	}
	
	public boolean find(final Integer l99Id) {
		Integer[] ids = getIdsArray();
		for (Integer id : ids) {
			if (id.equals(l99Id)) {
				return true;
			}
		}
		return false;
	}
}
