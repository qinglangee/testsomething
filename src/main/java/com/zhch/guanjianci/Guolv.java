package com.zhch.guanjianci;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

public class Guolv {

	// List<String> list = FileUtils.readLines(new
	// File("/home/lifeix/Documents/l99/webim/wrong"));
	Set<String> wordSet = new HashSet<String>();
	List<String> wordSetMulti = new ArrayList<String>();
	List<String> noUse = new ArrayList<String>();
	List<String> unknow = new ArrayList<String>();
	List<String> wrong = new ArrayList<String>();
	List<String> wrong2 = new ArrayList<String>();
	List<String> wrong3 = new ArrayList<String>();
	List<String> alphNum = new ArrayList<String>();
	String base = "/home/lifeix/Documents/l99/webim/guanjianci/";

	public void test() throws IOException {
		CsvListReader reader = new CsvListReader(new FileReader(new File("")), CsvPreference.EXCEL_PREFERENCE);

		List<String> list = FileUtils.readLines(new File(base + "guanjianci.csv"));
		int wrongCount = 0;
		int wrong2Count = 0;
		int lineNum = 0;
		for (String line : list) {
			lineNum++;
			String[] words = line.split(",");
			if (words.length < 4) {
				Pattern p1 = Pattern.compile("(\\d+)(\\s+)(.*)(未参与审查)");
				// Pattern p =
				// Pattern.compile("(\\s+)(\\s+)(.*)( 参与审查)|( 未参与审查)");
				Matcher m1 = p1.matcher(line);
				Pattern p2 = Pattern.compile("(\\d+)(\\s+)(.*)(参与审查)");
				// Pattern p =
				// Pattern.compile("(\\s+)(\\s+)(.*)( 参与审查)|( 未参与审查)");
				if (m1.find()) {
					noUse.add(line);
				} else {
					Matcher m2 = p2.matcher(line);
					if (m2.find()) {

						int gNum = m1.groupCount();
						String word2 = m2.group(3).trim();
						addToSet(word2);
						// for(int i =3;i<=gNum ;i++){
						// System.out.println(i + "n:" + m2.group(i));
						// }
					} else {
						wrong2Count++;
						wrong2.add(line);
					}

				}
				wrongCount++;
				// System.out.println(words);
				wrong.add(line);

				continue;
			}
			String word = words[2];

			String type = words[3];
			if ("参与审查".equals(type)) {
				addToSet(word);
			} else {
				if ("未参与审查".equals(type)) {
					noUse.add(word);
				} else {
					unknow.add(line);

				}
			}
		}
		System.out.println("once wrong:" + wrongCount);
		System.out.println(" wrong2:" + wrong2Count);

		// printList(wordSet);
		// printList(wordSetMulti);
		// printList(noUse);
		writetoFile(wordSet, "wordSet");
		writetoFile(wordSetMulti, "wordMulti");
		writetoFile(noUse, "nouse");
		writetoFile(unknow, "unknow");
		writetoFile(wrong, "wrong");
		writetoFile(wrong2, "wrong2");
		writetoFile(alphNum, "alphNum");
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (String s : wordSet) {
			if ("".equals(s)) {
				System.out.println("is empty:");
			} else if (s.startsWith(",")) {
				System.out.println(", start:" + s);
			} else if (s.endsWith(",")) {
				System.out.println(", end:" + s);
			}
			if (index > 1) {
				sb.append(",");
			}
			sb.append(s);
			index++;
		}
		FileUtils.writeStringToFile(new File(base + "words"), sb.toString());
		System.out.println("over!");
	}

	public void addToSet(String word) {
		String content = word.trim();
		if (content.startsWith(",")) {
			content = content.substring(1);
		}
		if (content.endsWith(",")) {
			content = content.substring(0, content.length() - 1);
		}

		content = content.replaceAll(",", " ");

		Pattern p1 = Pattern.compile("^[\\d,\\w]+$");
		// Pattern p = Pattern.compile("(\\s+)(\\s+)(.*)( 参与审查)|( 未参与审查)");
		Matcher m1 = p1.matcher(content);
		if (m1.find()) {
			alphNum.add(content);
			return;
		}

		if (wordSet.contains(content)) {
			wordSetMulti.add(content);
		} else {
			wordSet.add(content);
		}

	}

	public void writetoFile(Collection<String> list, String filename) throws IOException {

		String name = base + filename;
		File file = new File(name);
		FileUtils.writeLines(file, list);

	}

	public void printList(Collection<String> list) {
		for (int i = 0; i < 10; i++) {
			System.out.println("==========================");
		}
		for (String s : list) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) throws IOException {
		Guolv t = new Guolv();
		t.test();
	}
}
