package com.zhch.string;

public class Substring {
	public void test() {
		String a = "123456789";
		System.out.println(a.substring(0,4));
		
		
		String dashboardTime = "2012-12-45 14:11:11";
		if(dashboardTime != null && dashboardTime.length() > 7){
			dashboardTime = dashboardTime.substring(0,  7);
			System.out.println("dashboardTime :"+dashboardTime);
		}
	}

	public static void main(String[] args) {
		Substring t = new Substring();
		t.test();
	}
}
