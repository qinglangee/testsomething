package com.zhch.gson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonObjectToString {
	public void test() {
		JsonObject obj = new JsonObject();
		obj.addProperty("name", "a");
		obj.addProperty("age", 3);
		JsonObject item1 = new JsonObject();
		obj.addProperty("name", "item1");
		JsonObject item2 = new JsonObject();
		obj.addProperty("name", "item2");
		JsonArray arr = new JsonArray();
		arr.add(item1);
		arr.add(item2);
		
		Obj a = new Obj();
		a.setObj(obj);
		a.setArray(arr);
		
		// JsonObject 和 JsonArray 都会自己添加 一个字段 
		System.out.println(new Gson().toJson(a));  // {"obj":{"members":{"name":"item2","age":3}},"array":{"elements":[{},{}]}}
	}

	public static void main(String[] args) {
		JsonObjectToString t = new JsonObjectToString();
		t.test();
	}
}

class Obj{
	private JsonObject obj;
	private JsonArray array;
	
	public JsonObject getObj() {
		return obj;
	}
	public void setObj(JsonObject obj) {
		this.obj = obj;
	}
	public JsonArray getArray() {
		return array;
	}
	public void setArray(JsonArray array) {
		this.array = array;
	}
}