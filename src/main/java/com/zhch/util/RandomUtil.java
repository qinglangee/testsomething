package com.zhch.util;

import java.util.Random;

public class RandomUtil {

	public static Random r = new Random();

	public static String randomString() {
		return randomString(10);
	}

	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder();
		while (length > 0) {
			int c = r.nextInt(26);
			sb.append((char)('a' + c));
			length--;
		}
		return sb.toString();
	}
}
