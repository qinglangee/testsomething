package com.zhch.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class PringString {
	public void test() throws IOException {
		File file = new File("/tmp/abcd.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write("中文字符串" + new Date().toString() + "\n");
		bw.flush();
	}

	public static void main(String[] args) throws IOException {
		PringString t = new PringString();
		t.test();
	}
}
