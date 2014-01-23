package com.zhch.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComMethod {
	public void test() {
		List<A> list = new ArrayList<A>();
		list.add(new A(1));
		list.add(new A(3));
		list.add(new A(2));
		list.add(new A(5));
		list.add(new A(6));
		list.add(new A(4));
		list.add(new A(8));
		Collections.sort(list);
		System.out.println(list);
	}

	public static void main(String[] args) {
		ComMethod t = new ComMethod();
		t.test();
	}
}


class A implements Comparable<A>{
	public int index;
	public A(){}
	public A(int i){
		index = i;
	}
	public int compareTo(A other) {
		return index - other.index;
	}
	
	public String toString(){
		return index + "";
	}
}
