package com.zhch.mentaltest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ParseFlow {
	public void manage() throws IOException {
		List<String> action = new ArrayList<String>();
		List<String> service = new ArrayList<String>();
		List<String> dao = new ArrayList<String>();
		List<String> lines = FileUtils.readLines(new File("/home/lifeix/Documents/l99/code/mentalTest/flow"));
		for (String line : lines) {
			String[] words = line.split("--");
			for (String word : words) {
				if (word.startsWith("a") && !action.contains(word))
					action.add(word);
				if (word.startsWith("s") && !service.contains(word))
					service.add(word);
				if (word.startsWith("d") && !dao.contains(word))
					dao.add(word);
			}
		}
		Collections.sort(action);
		Collections.sort(service);
		Collections.sort(dao);
		System.out.println("action: " + action);
		System.out.println("service: " + service);
		System.out.println("dao: " + dao);
	}

	public static void main(String[] args) throws IOException {
		ParseFlow t = new ParseFlow();
		t.manage();
	}
}
