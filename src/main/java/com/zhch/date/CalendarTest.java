package com.zhch.date;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public void test() {
		Calendar c = Calendar.getInstance();
		String str = c.get(Calendar.YEAR)+ "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH);
		System.out.println(str);
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -3);
		Date oldDate = cal.getTime();
		System.out.println("3个月前:" + oldDate);
		
		cal.add(Calendar.DATE, -2);
		oldDate = cal.getTime();
		System.out.println("再两天前:" + oldDate);
	}

	public static void main(String[] args) {
		CalendarTest t = new CalendarTest();
		t.test();
	}
}
