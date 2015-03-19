package com.zhch.mooc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;


/**
 * 邓俊辉数据结构 题目测试数据产生
 * @author lifeix
 *
 */
public class DataProduct {
	Random r = new Random();
	String dataDir = "/home/lifeix/temp/github/mooc_code/data_structure/in/";
	String LS = "\n";
	
	public void pa01_range() {
		for(int i=2;i<3;i++){
			int r1 = 1000;
			int r2 = 100;
			int r3 = 10000;
			StringBuilder sb = new StringBuilder();
			int n = r.nextInt(r1);
			int m = 10 + r.nextInt(r2);
			sb.append(n).append(" ").append(m).append(LS);
			Set<Integer> ns = new HashSet<Integer>();
			// 一行 n 个数
			while(ns.size() < n){
				ns.add(r.nextInt(r3) + r.nextInt(r3));
			}
			List<Integer> nsList = new ArrayList<Integer>(ns);
			Collections.sort(nsList);
			for(Integer j : nsList){
				sb.append(j).append(" ");
			}
			sb.append(LS);
			// m 对范围
			for(int j = 0; j < m; j++){
				int s = r.nextInt(r3);
				sb.append(s).append(" ").append(s + r.nextInt(r3 * 3 / 2)).append(LS);
			}
			// 写文件
			File file = new File(dataDir + "01_0" + i);
			try {
				FileUtils.write(file, sb.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		DataProduct t = new DataProduct();
		t.pa01_range();
		System.out.println("over!!");
	}
}
