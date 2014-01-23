package com.zhch.json;
import org.json.JSONException;
import org.json.JSONObject;

public class UseOrgJson extends UseJson {
	public String toJson(Object o ){
		JSONObject json = (JSONObject)o;
		return json.toString();
	}
	
	public Object parseJson(String str){
		try {
			return new JSONObject(str);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
