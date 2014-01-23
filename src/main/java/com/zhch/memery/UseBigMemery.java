package com.zhch.memery;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class UseBigMemery {
	public void fileTest() {
		int count = 20;
		String[] strs = new String[count];
		for (int i = 0; i < count; i++) {
			File file = new File("/home/lifeix/temp/d4/bigfile");
			try {
				strs[i] = FileUtils.readFileToString(file);
				System.out.println("read a file " + i);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("read ready!");
	}
	
	public void objectTest() throws InterruptedException{
		List<Mem> list = new ArrayList<Mem>();
		while(true){
			list.add(new Mem());
			Thread.sleep(5);
			if(list.size() > 5000){
				break;
			}
		}
		System.out.println("mem ready!!");
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		UseBigMemery t = new UseBigMemery();
//		t.fileTest();
		t.objectTest();
		System.in.read();
		System.out.println("voer!!");
	}
}
class Mem{
	String content;
	Mem(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<1000;i++){
			sb.append("abcdefg");
		}
		content = sb.toString();
	}
}
