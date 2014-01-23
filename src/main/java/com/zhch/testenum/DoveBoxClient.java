package com.zhch.testenum;


public enum DoveBoxClient {
	
	WEB("key:Webss" , "" , "立方网" , "Firefox" ),
	
	// API
	API("key:API" , "http://code.google.com/p/lifeix-api/" , "API" , "HTTP"),
	
	// 立方飞鸽 iPhone 应用
	DoveBoxForiPhone("key:DoveBoxForiPhone" , "http://apps.L99.com/" , "iPhone" , "DoveBox"),
	
	DoveBoxForGPhone("key:DoveBoxForGPhone" , "http://apps.L99.com/" , "Android" , "DoveBox"),
	
	DoveBoxForOPhone("key:DoveBoxForOPhone" , "" , "OPhone" , "DoveBox"),
	
	
	TownFileForiPhone("key:TownFileForiPhone" , "http://apps.L99.com/" , "iPhone" , "TownFile"),
	
	TownFileForS60("key:TownFileForS60" , "http://apps.L99.com/" , "S60客户端" , "TownFileS60"),
	
	TownFileForGPhone("key:TownFileForGPhone" , "http://apps.L99.com/" , "Android" , "TownFile"),
	
	/**
	 * A06
	 */
	WEB_A06("key:Web_A06" , "" , "立方网" , "Firefox"),
	
	IPHONE_A06("key:TownFileForiPhone_A06" , "http://apps.L99.com/" , "iPhone" , "GameA06"),
	
	IPHONE_A06_TEST("key:TownFileForiPhone_A06_Test" , "http://apps.L99.com/" , "iPhone" , "GameA06"),
	
	/**
	 * G01
	 */
	IPHONE_G01("key:TownFileForiPhone_G01" , "http://apps.L99.com/" , "iPhone" , "GameG01");
	
	private final String key;
	
	private final String url;
	
	private final String name;
	
	private final String header;
	
	DoveBoxClient(String key , String url , String name , String header) {
		this.key = key;
		this.url = url;
		this.name = name;
		this.header = header;
	}

	public String getKey() {
		return key;
	}

	public String getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	public String getHeader() {
		return header;
	}
	
	/**
	 * 判断客户端类型
	 * @param request
	 * @return
	 */
	public static DoveBoxClient detectDoveBoxClient(String source) {
		if(source == null || source.trim().equals("")) return WEB;
		for (DoveBoxClient item : DoveBoxClient.values()) {
			if (item.getKey().toLowerCase().equals(source.toLowerCase())) {
				return item;
			}
		}
		return WEB;
	}
}
