package com.zhch.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class DateFormatTest {
	public void test() throws ParseException {
		DateFormat df = new SimpleDateFormat();
		System.out.println(df.format(new Date()));
		
		String date1s = "20121208";
		df = new SimpleDateFormat("yyyyMMdd");
		Date date1 = df.parse(date1s);
		System.out.println("date1:" + date1);
		
		String date2s = "12201208";
		df = new SimpleDateFormat("MMyyyydd");
		Date date2 = df.parse(date2s);
		System.out.println("date2:" + date2);
		
		SimpleDateFormat longFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = longFormat.parse("2012-12-12 12:12:12");
		Date d2 = longFormat.parse("2012-12-13 12:12:12");
		System.out.println(d1.after(d2));
		System.out.println(d2.after(d1));
		
		System.out.println("====================parse");
		SimpleDateFormat parser = new SimpleDateFormat("yyyyMMdd");
		Date errDate = parser.parse("20120112abcdefg");
		System.out.println("错的也能解析:" + longFormat.format(errDate));
		Date errDate2 = parser.parse("20120112120000");
		System.out.println("能解析但是结果不对:" + longFormat.format(errDate2));
	}
	
	public void early() throws ParseException{
		
		SimpleDateFormat longFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = longFormat.parse("1521-12-12 12:25:26");
		// 一个很早的时间
		System.out.println(date);
	}

	public static void main(String[] args) throws ParseException {
		DateFormatTest t = new DateFormatTest();
		t.early();
	}
}
