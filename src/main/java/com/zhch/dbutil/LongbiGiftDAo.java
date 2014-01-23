package com.zhch.dbutil;


public class LongbiGiftDAo {
	public void test() {
//		LongbiGiftDaoImpl dao = new LongbiGiftDaoImpl();
//		LongbiGift gift = dao.findById(15);
//		gift.setStatus(0);
//		dao.update(gift);
	}
	public void test2() {
//		LongbiGiftDaoImpl dao = new LongbiGiftDaoImpl();
//		LongbiGift gift = dao.findById(15);
//		gift.setStatus(0);
//		gift.setEnableTime(DateUtil.formatDate(new Date(new Date().getTime()-1000*60*60*24*16)));
//		dao.update(gift);
	}

	public static void main(String[] args) {
		String memcachedEnabled = "true";
        String memcachedNodes = "n1:192.168.1.53:10101 n2:192.168.1.53:10102";
		System.setProperty("com.l99.cache.memcachedEnabled", memcachedEnabled);
		System.setProperty("com.l99.cache.memcacheNodes", memcachedNodes);
		
		LongbiGiftDAo t = new LongbiGiftDAo();
		t.test2();
		System.out.println("aaabc..");
		System.exit(0);
	}
}
