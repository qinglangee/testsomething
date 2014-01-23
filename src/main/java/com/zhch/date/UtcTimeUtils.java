package com.zhch.date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.ejb.Local;

/**
 * 没有加入到timeutils class中　.
 * @author neoyin
 */
public class UtcTimeUtils {

	/** 网站UTC TIME 采用的格式	Fri Dec 28 16:21:18 +0800 2012 */
	private static final String UTCTIMEPATTEN ="EEE MMM dd HH:mm:ss ZZZZZ yyyy";
	
	/**
	 * 将 utc 时间转成 unixtime
	 * @param utcTime
	 * @param utcTimePatten
	 * @return
	 */
	public static long utcTransToUnix(String utcTime, String utcTimePatten) { 
		if (utcTimePatten==null) {
			utcTimePatten = UTCTIMEPATTEN;
		}
		SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten); 
		utcFormater.setTimeZone(TimeZone.getTimeZone("UTC")); 
		try { 
			Date gpsUTCDate = utcFormater.parse(utcTime); 
			return gpsUTCDate.getTime();
		} catch (ParseException e) { 
			e.printStackTrace();
			return 0;
		} 
	}
	
	public static void main(String[] args) {
		System.out.println(123);
		System.out.println(Locale.getDefault());
		System.out.println(utcTransToUnix("Fri Dec 28 16:21:18 +0800 2012",null));
	}
	
}
