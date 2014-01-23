package com.zhch.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MoveFile {
	public void test() throws IOException {
		String dir = "/home/lifeix/temp/d3/";
		File a = new File(dir + "aa");
		File b = new File(dir + "bb");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(b));
			System.out.println(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("==========割一下=============");
		a.renameTo(b);
		// rename 后, a对象的路径不变
		System.out.println("a:" + a.getAbsolutePath());
		
		// rename 后, b对象的内容变了
		br = new BufferedReader(new FileReader(b));
		System.out.println(br.readLine());
	}

	public static void main(String[] args) throws IOException {
		MoveFile t = new MoveFile();
		t.test();
	}
}
