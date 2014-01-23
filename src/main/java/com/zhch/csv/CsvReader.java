package com.zhch.csv;

import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	public static String[] parseLine(String src) throws Exception {
		if (src == null)
			return null;
		if (src.indexOf("\"") < 0) {
			return src.split(",");
		}
		List<String> list = new ArrayList<String>();

		boolean quote = false;
		boolean innerQuote = false;

		int length = src.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = src.charAt(i);
			if (!quote) { // 没开始引号
				if (c != ',') {
					if (sb.length() > 0 && c == '"') {
						throw new Exception("quote is in middle!!");
					}
					sb.append(c);
					if (c == '"') {
						quote = true;
					}
				} else {
					list.add(sb.toString());
					sb = new StringBuilder();
				}
			} else { // 在引号中了
				if (innerQuote) {
					if (c != '"') {
						if (c == ',') {
							list.add(sb.toString().substring(1, sb.length()-1));
							sb = new StringBuilder();
							quote = false;
						} else {
							throw new Exception("quote in middle must be double or next to ','!!!");
						}
					} else {
						innerQuote = false;
					}
				} else {
					if (c == '"') {
						sb.append(c);
						innerQuote = true;
					} else {
						sb.append(c);
					}
				}
			}
		}
		
		if(quote && !innerQuote){
			throw new Exception("quote does not close.");
		}

		list.add(sb.toString()); 
		
		return list.toArray(new String[] {});
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1ab,cd,efg,hi,jk");
		list.add("2ab,cd,\"efg,hi,jk");
		list.add("3ab,cd,\"efg\",hi,jk");
		list.add("4ab,cd,\"e,fg\",hi,jk");
		list.add("5ab,cd,\"e,f,,g\",hi,jk");
		list.add("6ab,cd,\"e\"\"fg\",hi,jk");
		list.add("62ab,cd,\"e\"\"fg\"\"\",hi,jk");
		list.add("7ab,cd,\"e\"fg\",hi,jk");
		list.add("8ab,cd,\"efg\" ,hi,jk");
		list.add("9ab,cd,\"e\"fg\",hi,jk");

		for (String s : list) {
			try {
				String[] strs = parseLine(s);
				String res = "";
				for (String ss : strs) {
					res += "[" + ss + "]  ";
				}
				System.out.println(s);
				System.out.println(res);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("invalide: " + s);
			}
		}

	}
}
