package com.zhch.json;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.google.gson.JsonObject;
public class TestJson {

	public void test() {
		UseJson[] utils = new UseJson[3];
		utils[0] = new UseSimpleJson();
		utils[1] = new UseOrgJson();
		utils[2] = new UseGson();
		
		JsonObject json = new JsonObject();
		json.addProperty("abc1", 1);
		json.addProperty("abc2", "defct");
		json.addProperty("abc3", true);
		json.addProperty("abc4", false);
		json.addProperty("abc5", 198789798);
		json.addProperty("abc6", "aaaaaaaaaaaaaaaaa");
		json.addProperty("abc7", "mmmmmmmmmmmmmmmmm");
		String str = json.toString();
		
		// 测试自己parse再自己toString
		for(int i = 0; i < 3; i++){
			UseJson util = utils[i];
			Object o = util.parseJson(str);
			String s = util.toJson(o);
			System.out.println("i " + i + " :  " + s);
		}
		
		// 测试toString需要的时间
		int maxTime = 100000;
		for(int i = 0; i < 3; i++){
			UseJson util = utils[i];
			Object o = util.parseJson(str);
			long start = System.nanoTime();
			for(int j = 0 ; j < maxTime; j++){
				util.toJson(o);
			}
			long end = System.nanoTime();
			System.out.println("time " + i + " : " + (end - start));
			
		}
		
		
	}

	public static void main(String[] args) {
		TestJson t = new TestJson();
		t.test();
	}
}
