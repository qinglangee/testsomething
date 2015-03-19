package com.zhch.date;

import java.util.Date;

public class SystemMilli {
	public void test() {
		// System.currentTimeMillis() 可以直接转换成当前时间
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
	}

	public static void main(String[] args) {
		SystemMilli t = new SystemMilli();
		t.test();
	}
}
