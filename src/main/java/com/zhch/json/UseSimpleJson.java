package com.zhch.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class UseSimpleJson extends UseJson{
	JSONParser parser = new JSONParser();
	public String toJson(Object o){
		JSONObject json = (JSONObject)o;
		return json.toJSONString();
	}
	
	public Object parseJson(String str){
		try {
			return  parser.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
