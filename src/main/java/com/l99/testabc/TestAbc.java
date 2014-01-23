package com.l99.testabc;

public class TestAbc {
	public void test() {
		M a = new M("a");
		M b = new M("b");
		M c = new M("c");
		
		c =a;
		a=b;
		b=c;
		System.out.println(a.name);
		System.out.println(b.name);
	}

	public static void main(String[] args) {
		TestAbc t = new TestAbc();
		t.test();
	}
}

class M{
	public String name;
	public M(String n){
		name = n;
	}
}
