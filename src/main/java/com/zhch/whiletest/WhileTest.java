package com.zhch.whiletest;

public class WhileTest {
	public void test() throws InterruptedException {
		while(true){
			call();
		}
	}
	
	public void  call() throws InterruptedException{
		new Thread(new R()).start();
		Thread.sleep(1000);
	}

	public static void main(String[] args) throws InterruptedException {
		WhileTest t = new WhileTest();
		t.test();
	}
	
	public class R implements Runnable{

		@Override
		public void run() {
			System.out.println("i am run.");
			
		}
		
	}
}
