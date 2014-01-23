package com.zhch.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonDeep {
	public void test() {
		Wo m2 = new Wo(5, null);
		Man m1 = new Man(3, new Man(4,m2));
		Gson gson = new Gson();
		System.out.println(gson.toJson(m1));
		
		GsonBuilder builder = new GsonBuilder();
		System.out.println( builder.create().toJson(m1));
		System.out.println("=========================");
		List<Man> list = new ArrayList<Man>();
		list.add(new Man(1,null));
		list.add(new Man(2,null));
		list.add(new Man(3,null));
		List<Man> list2 = new ArrayList<Man>();
		list2.add(new Man(1,null));
		System.out.println(gson.toJson(list));
		System.out.println(gson.toJson(list2));
	}

	public static void main(String[] args) {
		GsonDeep t = new GsonDeep();
		t.test();
	}
}
interface A{
}
class Man implements A{
	public Man(int a ,A b){
		this.aabDef =a;this.b=b;
	}
	private int aabDef ;
	private A b ;
	public int getA() {
		return aabDef;
	}
	public void setA(int a) {
		this.aabDef = a;
	}
	public A getB() {
		return b;
	}
	public void setB(A b) {
		this.b = b;
	}
}
class Wo implements A{
	public Wo(int w,A b){
		wo = w; mo =b;
	}
	public int  wo;
	public A mo;
}