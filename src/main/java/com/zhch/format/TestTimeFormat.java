package com.zhch.format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimeFormat {
	public void test() {

		long starttime = System.currentTimeMillis();

		for (int i = 0; i < 10; i++) {
			new Thread(new A()).start();
			// Date date =
			// TestTimeFormat.getUtcTimeForDate("2012-05-20 12:12:12");
			// System.out.println(date);
		}
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endtime = System.currentTimeMillis();
		System.out.println("used:" + (endtime - starttime));

	}

	/**
	 * 线程不安全的,多线程调用会报错
	 */
	final static DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	public static Date getUtcTimeForDate_static(String time) {
		if (time == null)
			return null;
		Date date = null;
		try {
			date = dateFormat.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static Date getUtcTimeForDate_local(String time) {
		if (time == null)
			return null;
		Date date = null;
		try {
			date = df.get().parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getUtcTimeForDate(String time) {
		if (time == null)
			return null;
		Date date = null;
		try {

			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public void testTime() {
		int times = 100000;

		long starttime = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			getUtcTimeForDate_static("2012-05-20 12:12:12");
		}
		long enttime = System.currentTimeMillis();
		System.out.println("used 1 : " + (enttime - starttime));
		long starttime2 = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			getUtcTimeForDate("2012-05-20 12:12:12");
		}
		long enttime2 = System.currentTimeMillis();
		System.out.println("used 2 : " + (enttime2 - starttime2));
		long starttime3 = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			getUtcTimeForDate_local("2012-05-20 12:12:12");
		}
		long enttime3 = System.currentTimeMillis();
		System.out.println("used 3 : " + (enttime3 - starttime3));
	}

	public static void main(String[] args) {
		TestTimeFormat t = new TestTimeFormat();
		t.test();
	}
}

class A implements Runnable {

	public void run() {
		Date date = TestTimeFormat.getUtcTimeForDate_local("2012-05-20 12:12:12");
		System.out.println(date);
	}

}
