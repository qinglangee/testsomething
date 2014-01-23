package com.zhch.json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UseGson extends UseJson{
	Gson gson = new Gson();
	JsonParser parser = new JsonParser();
	public String toJson(Object o){
		JsonObject json = (JsonObject)o;
		return json.toString();
	}
	
	public Object parseJson(String str){
		return parser.parse(str).getAsJsonObject();
	}
}
