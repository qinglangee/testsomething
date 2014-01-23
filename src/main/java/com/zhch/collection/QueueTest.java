package com.zhch.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public void test() {
		Queue<String> queue = new LinkedList<String>();
		for(int i=0 ;i< 4;i++){
			queue.offer(""+ i);
		}
		for(String str : queue){
			System.out.println(str);
		}
		
		for(int i=0;i<6;i++){
			String str = queue.poll();
			System.out.println("str is :  " + str + "  queue size:" + queue.size());
			
		}
	}

	public static void main(String[] args) {
		QueueTest t = new QueueTest();
		t.test();
	}
}
