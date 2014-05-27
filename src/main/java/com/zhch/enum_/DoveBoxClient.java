package com.zhch.enum_;


public enum DoveBoxClient {
	
	// L06
	WEB("key:Web" , "" , "立方网" , "Firefox" ),
		
	// API
	API("key:API" , "http://code.google.com/p/lifeix-api/" , "API" , "HTTP"),

	// 飞鸽(iPhone)
	DoveBoxForiPhone("key:DoveBoxForiPhone" , "http://apps.L99.com/" , "iPhone" , "DoveBox"),

	// 飞鸽(Android)
	DoveBoxForGPhone("key:DoveBoxForGPhone" , "http://apps.L99.com/" , "Android" , "DoveBox"),

	// 飞鸽(ophone)
	DoveBoxForOPhone("key:DoveBoxForOPhone" , "" , "OPhone" , "DoveBox"),

	// 在哪(iPhone)
	TownFileForiPhone("key:TownFileForiPhone" , "http://apps.L99.com/" , "iPhone" , "TownFile"),

	// 在哪(Android)
	TownFileForGPhone("key:TownFileForGPhone" , "http://apps.L99.com/" , "Android" , "TownFile"),

	// 在哪(Symbian) 
	TownFileForS60("key:TownFileForS60" , "http://apps.L99.com/" , "S60客户端" , "TownFileS60"),

	// 在哪之第九维(Flash)
	WEB_A06("key:Web_A06" , "" , "立方网" , "GameA06"),

	// 在哪之第九维(iPhone)
	IPHONE_A06("key:TownFileForiPhone_A06" , "http://apps.L99.com/" , "iPhone" , "GameA06"),

	// 吃货(iPhone) 
	EatingForiPhone("key:EatingForiPhone" , "http://apps.L99.com/" , "iPhone" , "Eatables"),

	// 在哪之幸运星 
	IPHONE_G01("key:TownFileForiPhone_G01" , "http://apps.L99.com/" , "iPhone" , "GameG01"),

	// 黑鹰(iphone) 
	IPHONE_BLACKHAWKS("key:BlackHawksForiPhone" , "http://apps.L99.com/" , "iPhone" , "BlackHawks"),

	// 黑鹰(android) 
	GPHONE_BLACKHAWKS("key:BlackHawksForGPhone" , "http://apps.L99.com/" , "Android" , "BlackHawks"),
	//我的大学(iPhone)
	MUForiPhone("key:MyUniversityForiPhone", "http://apps.L99.com/" , "iPhone" , "MU"),
	//我的大学(Android)
	MUForAndroid("key:MyUniversityForAndroid", "http://apps.L99.com/" , "iPhone" , "MU"),
	
	//床上(Android)
	BedForAndroid("key:BedForAndroid", "http://apps.L99.com/" , "Android" , "Bedigest"),
	//床上(iPhone)
	BedForiPhone("key:BedForiPhone", "http://apps.L99.com/" , "iPhone" , "Bedigest"),
	
	// 猜比赛android
	ROI_ANDROID("key:roi_android", "http://apps.L99.com/", "Android", "ROI"),
	
	// 猜比赛iPhone
	ROI_IPHONE("key:roi_iphone", "http://apps.L99.com/", "iPhone", "ROI"),
	
	// 设计师android
	DesignerForGPhone("key:DesignerForGPhone", "http://apps.L99.com/", "Android", "Designer"),
	// 设计师iPhone
	DesignerForiPhone("key:DesignerForiPhone", "http://apps.L99.com/", "iPhone", "Designer");
	
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
	
	public static void main(String[] args) {
		// valueOf 就是根据name返回对象
		System.out.println(DoveBoxClient.valueOf("DesignerForGPhone").name());
		// toString() 就是打印 name()
		System.out.println(DoveBoxClient.valueOf("DesignerForGPhone").toString());
	}
	
}
