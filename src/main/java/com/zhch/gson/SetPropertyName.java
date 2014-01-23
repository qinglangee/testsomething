package com.zhch.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetPropertyName {
	Gson gson = new Gson();
	Gson gsonEx = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

	public void test() {
		Bean bean = new Bean();
		
		// 指定json中的字段名
		System.out.println(gson.toJson(bean));
		// 没有Expose指定的字段不出现在json中
		System.out.println(gsonEx.toJson(bean));
		
	}


	public static void main(String[] args) {
		SetPropertyName t = new SetPropertyName();
		t.test();
	}
}

class Bean {
	@Expose
	String name = "nnn";
	
	// 可以指定在json中的字段名
	@SerializedName("abc")
	int a = 3;
	
	transient int b = 4;
}