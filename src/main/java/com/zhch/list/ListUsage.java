package com.zhch.list;

import java.util.ArrayList;
import java.util.List;

public class ListUsage {
	
	public void subList(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println("list:" + list);
		
		// 取后缀子list, end要写 list.size(), 不是list.size()-1
		// start 3, 是前3个不要, 从第4个开始取
		List<Integer> sub = list.subList(3, list.size());
		System.out.println(" sub:" + sub);
		sub = list.subList(3, 3); // 3,3 取不到
		System.out.println(" sub:" + sub);
		sub = list.subList(3, 4); // 3,4 取一个
		System.out.println(" sub:" + sub);
		// 3,8 越界, 报错
//		sub = list.subList(3, 8); 
		System.out.println(" sub:" + sub);
	}
	
	public static void main(String[] args) {
		ListUsage t = new ListUsage();
		t.subList();
	}
}
