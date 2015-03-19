package com.zhch.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;

public class SendJsonData {
	public static String URL_CREATE_USER = "https://bicika.zendesk.com/api/v2/users.json";
	// public static String URL_CREATE_USERS = "";
	// public static String URL_SHOW_USER =
	// "https://bicika.zendesk.com/api/v2/users/353239419.json";
	// public static String
	// URL_ACTIVITY="https://bicika.zendesk.com/api/v2/activities/353239419.json";
	// public static String URL_ACTIVITIES =
	// "https://bicika.zendesk.com/api/v2/activities.json";
	static final String kuser = "jiang1li@126.com"; // 用户名
	static final String kpass = "19881225"; // 密码

	static class MyAuthenticator extends Authenticator {
		@Override
		public PasswordAuthentication getPasswordAuthentication() {
			return (new PasswordAuthentication(kuser, kpass.toCharArray()));
		}
	}

	public static void main(String[] args) throws Exception {
		Authenticator.setDefault(new MyAuthenticator());
		URL url = new URL(URL_CREATE_USER);
		InputStream ins = url.openConnection().getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
		String str;
		while ((str = reader.readLine()) != null)
			System.out.println(str);
	}
}
