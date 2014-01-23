package com.l99.mysql.sqlvsmongo;

public class Test {
	public void init(){
		
		Sql sql = new Sql();
		Mongo mongo = new Mongo();
	}
	public void test() {
		init();
		
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.test();
	}
}
