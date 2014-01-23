package com.zhch.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomTest {
	Random r = new Random();
	public void test() {
		int max = 1000;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<max;i++){
			map.put(i, 0);
		}
		for(int i=0;i<1000000;i++){
			int num = r.nextInt(max);
			map.put(num, map.get(num) + 1);
		}
		
		for(int i=0;i<max;i++){
			System.out.println( i + " : " + map.get(i));
		}
	}

	public static void main(String[] args) {
		RandomTest t = new RandomTest();
		t.test();
	}
}
