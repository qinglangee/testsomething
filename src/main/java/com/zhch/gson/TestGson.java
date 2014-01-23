package com.zhch.gson;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestGson {
	Gson gson = new Gson();
	JsonParser parser = new JsonParser();
	public void test() {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		String result = "{\"villages\":{\"cat_flag\":1,\"like_number\":1,\"active_logo\":\"\",\"lng\":\"116.442543\",\"creator\":{\"nick_name\":\"\",\"id\":1730,\"first_name\":\"eo\",\"longNO\":15101,\"name\":\"Neo\",\"last_name\":\"N\",\"profile_image_url\":\"30/MjAxMjAxMTcwMDM5MDZfMTI0LjIwNy4xMDQuMThfNTc0MzY3.jpeg\"},\"cat_name\":\"\",\"cat_id\":0,\"local_id\":100000011,\"business_flag\":\"0\",\"distance\":12238821,\"name\":\"在哪测试\",\"bs_photo_number\":0,\"check_number\":0,\"pigeon_id\":0,\"like_flag\":0,\"active_flag\":\"0\",\"lat\":\"40.006239\",\"comment_number\":0,\"user_number\":2,\"mayor\":{\"nick_name\":\"\",\"id\":0,\"first_name\":\"管理员\",\"longNO\":150101,\"name\":\"系统管理员\",\"last_name\":\"系统\",\"profile_image_url\":\"manage.jpg\"},\"check_flag\":false,\"mayor_time\":\"Sun Jun 03 19:58:55 +0800 2012\",\"reblog_number\":2,\"photo_number\":1,\"join_active\":\"0\",\"create_time\":\"Sun Jun 03 19:58:55 +0800 2012\",\"active_title\":\"\",\"cat_image\":\"select.png\"}}";
		result = "{\"a\":3,\"b\":4}";
		JsonElement ele = parser.parse(result);
		Jo json = gson.fromJson(result, Jo.class);
		System.out.println(json);
		System.out.println("=abc");
		System.out.println("sss");
		System.out.println(result);

		System.out.println("==================");
		Jo jo1 = new Jo(3, 4);
		String jo1json = gson.toJson(jo1);
		System.out.println(jo1json);
		
		System.out.println(result);
		System.out.println("equals:"+ jo1json.equals(result));
		Jo jo2 = gson.fromJson(jo1json, Jo.class);
		System.out.println(jo2);

	}
	
	public void jsonObject(){
		JsonObject jo = new JsonObject();
		jo.addProperty("a", 3);
		jo.addProperty("b", 4);
		System.out.println("jo:" + jo);
		System.out.println("toJson:" + gson.toJson(jo));
		String joS = gson.toJson(jo);
		
		Map jo2 = gson.fromJson(joS, Map.class);
		System.out.println("jo2:" + jo2);
		
		JsonElement joe = parser.parse(joS);
		JsonObject jo3 = joe.getAsJsonObject();
		System.out.println("element:" + joe);
		System.out.println("jo3:" + jo3);
		System.out.println("jo3.a : " + jo3.get("a"));
	}
	
	public void village(){
		String result = "{\"villages\":{\"cat_flag\":1,\"like_number\":1,\"active_logo\":\"\",\"lng\":\"116.442543\",\"creator\":{\"nick_name\":\"\",\"id\":1730,\"first_name\":\"eo\",\"longNO\":15101,\"name\":\"Neo\",\"last_name\":\"N\",\"profile_image_url\":\"30/MjAxMjAxMTcwMDM5MDZfMTI0LjIwNy4xMDQuMThfNTc0MzY3.jpeg\"},\"cat_name\":\"\",\"cat_id\":0,\"local_id\":100000011,\"business_flag\":\"0\",\"distance\":12238821,\"name\":\"在哪测试\",\"bs_photo_number\":0,\"check_number\":0,\"pigeon_id\":0,\"like_flag\":0,\"active_flag\":\"0\",\"lat\":\"40.006239\",\"comment_number\":0,\"user_number\":2,\"mayor\":{\"nick_name\":\"\",\"id\":0,\"first_name\":\"管理员\",\"longNO\":150101,\"name\":\"系统管理员\",\"last_name\":\"系统\",\"profile_image_url\":\"manage.jpg\"},\"check_flag\":false,\"mayor_time\":\"Sun Jun 03 19:58:55 +0800 2012\",\"reblog_number\":2,\"photo_number\":1,\"join_active\":\"0\",\"create_time\":\"Sun Jun 03 19:58:55 +0800 2012\",\"active_title\":\"\",\"cat_image\":\"select.png\"}}";
//		result = "{\"villages\":[{\"cat_flag\":1,\"like_number\":1,\"active_logo\":\"\",\"lng\":\"116.442543\",\"creator\":{\"nick_name\":\"\",\"id\":1730,\"first_name\":\"eo\",\"longNO\":15101,\"name\":\"Neo\",\"last_name\":\"N\",\"profile_image_url\":\"30/MjAxMjAxMTcwMDM5MDZfMTI0LjIwNy4xMDQuMThfNTc0MzY3.jpeg\"},\"cat_name\":\"\",\"cat_id\":0,\"local_id\":100000011,\"business_flag\":\"0\",\"distance\":12238821,\"name\":\"在哪测试\",\"bs_photo_number\":0,\"check_number\":0,\"pigeon_id\":0,\"like_flag\":0,\"active_flag\":\"0\",\"lat\":\"40.006239\",\"comment_number\":0,\"user_number\":2,\"mayor\":{\"nick_name\":\"\",\"id\":0,\"first_name\":\"管理员\",\"longNO\":150101,\"name\":\"系统管理员\",\"last_name\":\"系统\",\"profile_image_url\":\"manage.jpg\"},\"check_flag\":false,\"mayor_time\":\"Sun Jun 03 19:58:55 +0800 2012\",\"reblog_number\":2,\"photo_number\":1,\"join_active\":\"0\",\"create_time\":\"Sun Jun 03 19:58:55 +0800 2012\",\"active_title\":\"\",\"cat_image\":\"select.png\"},{\"cat_flag\":1,\"like_number\":0,\"active_logo\":\"\",\"lng\":\"116.442543\",\"creator\":{\"nick_name\":\"\",\"id\":1730,\"first_name\":\"eo\",\"longNO\":15101,\"name\":\"Neo\",\"last_name\":\"N\",\"profile_image_url\":\"30/MjAxMjAxMTcwMDM5MDZfMTI0LjIwNy4xMDQuMThfNTc0MzY3.jpeg\"},\"cat_name\":\"\",\"cat_id\":0,\"local_id\":100000010,\"business_flag\":\"0\",\"distance\":12238821,\"name\":\"在哪\",\"bs_photo_number\":0,\"check_number\":0,\"pigeon_id\":0,\"like_flag\":0,\"active_flag\":\"0\",\"lat\":\"40.006239\",\"comment_number\":0,\"user_number\":0,\"mayor\":{\"nick_name\":\"\",\"id\":0,\"first_name\":\"管理员\",\"longNO\":150101,\"name\":\"系统管理员\",\"last_name\":\"系统\",\"profile_image_url\":\"manage.jpg\"},\"check_flag\":false,\"mayor_time\":\"Sun Jun 03 19:57:20 +0800 2012\",\"reblog_number\":0,\"photo_number\":0,\"join_active\":\"0\",\"create_time\":\"Sun Jun 03 19:57:20 +0800 2012\",\"active_title\":\"\",\"cat_image\":\"select.png\"},{\"cat_flag\":1,\"like_number\":0,\"active_logo\":\"\",\"lng\":\"116.448764204979\",\"creator\":{\"nick_name\":\"\",\"id\":1730,\"first_name\":\"eo\",\"longNO\":15101,\"name\":\"Neo\",\"last_name\":\"N\",\"profile_image_url\":\"30/MjAxMjAxMTcwMDM5MDZfMTI0LjIwNy4xMDQuMThfNTc0MzY3.jpeg\"},\"cat_name\":\"\",\"cat_id\":0,\"local_id\":100000009,\"business_flag\":\"0\",\"distance\":12239280,\"name\":\"在哪\",\"bs_photo_number\":0,\"check_number\":0,\"pigeon_id\":0,\"like_flag\":0,\"active_flag\":\"0\",\"lat\":\"40.0076233424612\",\"comment_number\":0,\"user_number\":0,\"mayor\":{\"nick_name\":\"\",\"id\":0,\"first_name\":\"管理员\",\"longNO\":150101,\"name\":\"系统管理员\",\"last_name\":\"系统\",\"profile_image_url\":\"manage.jpg\"},\"check_flag\":false,\"mayor_time\":\"Sun Jun 03 19:56:08 +0800 2012\",\"reblog_number\":0,\"photo_number\":0,\"join_active\":\"0\",\"create_time\":\"Sun Jun 03 19:56:08 +0800 2012\",\"active_title\":\"\",\"cat_image\":\"select.png\"}]}";
		JsonElement joe = parser.parse(result);
		JsonObject jo3 = joe.getAsJsonObject();
		System.out.println("jo3:" + jo3);
		JsonElement ele = jo3.get("villages");
		if(ele.isJsonArray()){
			JsonArray array = ele.getAsJsonArray();
			for(int i=0; i<array.size();i++){
				JsonObject jo = array.get(i).getAsJsonObject();
				System.out.println("i:" + jo.get("name"));
			}
		}else{
			JsonObject jo = ele.getAsJsonObject();
			System.out.println("name:"+jo.get("name"));
			
		}
	}

	public static void main(String[] args) {
		TestGson t = new TestGson();
		t.village();
	}

}

class Jo {
	public Jo() {
	}

	public Jo(int a, int b) {
		this.a = a;
		this.b = b;
	}

	int a;
	int b;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String toString() {
		return "[ a:" + a + " b:" + b + "]";
	}
}
