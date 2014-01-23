package com.zhch.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

public class ParseJsonArray {
	private static Gson gson = new Gson();
	private static JsonParser parser = new JsonParser();
	static Type type = new com.google.gson.reflect.TypeToken<List<Option>>() {
	}.getType();

	public void test() {
		String str = "[{name:\"1段\",id:1},{name:\"2段\",id:2},{name:\"3段\",id:3},{name:\"4段\",id:4},{name:\"5段\",id:5},{name:\"6段\",id:6},{name:\"7段\",id:7},{name:\"8段\",id:8},{name:\"9段\",id:9}]";
		// for()
		// List<Option> list = gson.fromJson(str, List.class);
		List<Option> list = new ArrayList<Option>();
		Option o = new Option("aa", "bb");
		list.add(o);
		
		/** 对于list的toJson, 有没有type都可以 */
		System.out.println(gson.toJson(list, type));
		System.out.println(gson.toJson(list));
		// prints [{"id":"id","name":"name"}]

		/** 对于list的fromJson, 没有type都可以, 没有type是不行的, 转换不成原来的对象了 */
		List<Option> OptionListFromJson = gson.fromJson(str, type);
		System.out.println(OptionListFromJson);
		List<Option> OptionListFromJson2 = gson.fromJson(str, List.class);
		System.out.println(OptionListFromJson2);
	}

	public static void main(String[] args) {
		ParseJsonArray t = new ParseJsonArray();
		t.test();
	}

}

class Option {

	String name;
	String id;

	public Option() {
	}

	public Option(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String toString() {
		return "{"+name + ":" + id+"}";
	}
}
