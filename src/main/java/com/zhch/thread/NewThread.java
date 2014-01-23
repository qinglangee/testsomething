package com.zhch.thread;

public class NewThread {
	public void test() {
		new Thread() {
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("abc");
			}
		}.start();
	}

	public static void main(String[] args) {
		NewThread t = new NewThread();
		t.test();
		System.out.println("main exit");
	}
}
