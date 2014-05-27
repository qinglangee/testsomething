package com.zhch.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	static int count = 0;
	public void test() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				System.out.println("start." + (count ++));

			}
		};
		// 如果时间已经过了, 会把中间差的执行次数补上
		timer.scheduleAtFixedRate(task, getDate(6,0,0), 600000);
		// 如果时间已经过了, 只执行一次
		timer.schedule(task, getDate(6,0,0), 3000);
	}

	private Date getDate(int i, int j, int k) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, i);
		c.set(Calendar.MINUTE, j);
		c.set(Calendar.SECOND, k);
		return c.getTime();
	}

	public static void main(String[] args) {
		TimerTest t = new TimerTest();
		t.test();
	}
}
