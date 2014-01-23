package com.zhch.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UnitTime {
	public static Date getDateByUnixTimeStamp(long timestamp) {
		return new Date(timestamp * 1000);
	}
	public void test() {
		SimpleDateFormat longFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(1374464250L * 1000);
		System.out.println(longFormat.format(date));
		System.out.println(longFormat.format(getDateByUnixTimeStamp(1374221537)));
	}

	public static void main(String[] args) {
		UnitTime t = new UnitTime();
		t.test();
	}
}
