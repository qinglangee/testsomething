package com.zhch.l06temp;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateMailSettingConfig {

	static List<String[]> contents = null;
	static {
		contents = new  ArrayList<String[]>();
		contents.add(new String[]{"pk","立方PK","立方PK"});
		contents.add(new String[]{"buyAvatars","头像买卖","头像买卖"});
		contents.add(new String[]{"sneak","立方偷袭","立方偷袭"});
		contents.add(new String[]{"follow","加关注","关注"});
		contents.add(new String[]{"friend","加好友","好友"});
		contents.add(new String[]{"at","@消息","at 消息提醒"});
		contents.add(new String[]{"wwereGame","在哪之第九维","在哪之第九维"});
	}


	public void test() throws JSONException {
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		int index = 0 ;
		for(String[] content : contents){
			index ++;
			JSONObject cjson = new JSONObject();
			cjson.put("index", index);
			cjson.put("type", content[0]);
			cjson.put("display", content[1]);
			jsonArray.put(cjson);
		}
		json.put("types", jsonArray);
		System.out.println(json.toString());

	}

	public static void main(String[] args) throws JSONException {
		CreateMailSettingConfig t = new CreateMailSettingConfig();
		t.test();
	}
}
