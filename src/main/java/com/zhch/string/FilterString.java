package com.zhch.string;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FilterString {
	public void test() throws IOException {
		List<String> match = new ArrayList<String>();
		List<String> notmatch = new ArrayList<String>();
		
		List<String> regs = FileUtils.readLines(new File("/home/lifeix/temp/d3/reg.txt"));
		List<String> lines = FileUtils.readLines(new File("/home/lifeix/temp/d3/input"));
		for(String line : lines){
			boolean has = false;
			for(String reg : regs){
				if(line.indexOf(reg) > -1){
					match.add(line);
					has = true;
					break;
				}
			}
			if(!has){
				notmatch.add(line);
			}
		}
		FileUtils.writeLines(new File("/home/lifeix/temp/d3/match.xml"), match);
		FileUtils.writeLines(new File("/home/lifeix/temp/d3/notmatch.xml"), notmatch);
	}
	
	public void dumplicate() throws IOException{
		List<String> regs = FileUtils.readLines(new File("/home/lifeix/temp/d3/reg.txt"));
		List<String>  set = new ArrayList<String>();
		int count = 0;
		for(String reg : regs){
			if(set.contains(reg)){
				System.out.println(reg);
				count ++ ;
			}else{
				set.add(reg);
			}
		}
		System.out.println("count: " + count);
	}

	public static void main(String[] args) throws IOException {
		FilterString t = new FilterString();
		long t1 = System.currentTimeMillis();
		t.dumplicate();
		long t2 = System.currentTimeMillis();
		System.out.println("over. time : " + (t2 -t1));
	}
}
