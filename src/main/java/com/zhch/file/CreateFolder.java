package com.zhch.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CreateFolder {

	public void test() throws IOException {
		String folder = "/home/lifeix/temp/d3/a/b/c/d";
		File file = new File(folder);
		// 目录不存在就创建
		if(!file.exists()){
			FileUtils.forceMkdir(file);
		}
		File file2 = new File(folder + "/abc");
		// 文件不存在就创建文件, 目录要先存在
		if(!file2.exists()){
			file2.createNewFile();
		}
	}

	public static void main(String[] args) throws IOException {
		CreateFolder t = new CreateFolder();
		t.test();
		System.out.println("over.");
	}
}
