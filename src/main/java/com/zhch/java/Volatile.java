package com.zhch.java;

public class Volatile {

	public static void main(String[] args) {
		final Volatile volObj = new Volatile();
		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					volObj.check();
				}
			}
		};
		t2.start();
		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					volObj.swap();
				}
			}
		};
		t1.start();
	}

	volatile boolean boolValue; // use volatile to print "WTF!"

	public void check() {
		if (boolValue == !boolValue)
			System.out.println("WTF!");
	}

	public void swap() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolValue = !boolValue;
	}

}
