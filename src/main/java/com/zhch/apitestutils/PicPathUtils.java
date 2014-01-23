package com.zhch.apitestutils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;

public class PicPathUtils {
	
	
	private static List<String> imgsArr = new ArrayList<String>();
	
	
	
	public static boolean initPic(String path){
		if (imgsArr.size()<1) {
			listDir(path);
			System.out.println("==============初始化图片路径:"+imgsArr.size());
		}
		return true;
	}
	
	/**
	 * 得到图片地址路径
	 * @param path
	 * @return
	 */
	public static boolean listDir(String path) {
		File picPath = new File("/home/lifeix/temp/uploadpicPath.txt");
//		File picPath = new File("/home/lifeix/temp/picPath.txt");
		if(picPath.exists()){
			try {
				imgsArr = FileUtils.readLines(picPath);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File dir = new File(path);
		File[] files = dir.listFiles();
		for (File file : files) {

			if (file.isDirectory()) {
				listDir(file.getAbsolutePath());
			} else {
				try {
					ImageInputStream is = ImageIO.createImageInputStream(file);
					if (is!=null && file.getAbsolutePath().endsWith(".jpg")) {
						imgsArr.add(file.getAbsolutePath());
						System.out.println(file.getAbsolutePath());
					}
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
//				System.out.println(file.getAbsolutePath());
				//System.out.println(file.getParent() + "-->" + file.getName());
			}
		}
		
		if(picPath.exists()){
			try {
				FileUtils.writeLines(picPath, imgsArr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String getRandomPicPath(){
		initPic("/mnt/dianping/photos/310");
		int i = new Random().nextInt(imgsArr.size()-1);
		return imgsArr.get(i);
	}
	public static void main(String[] args) {
//		listDir("/mnt/dianping/photos/310");
		listDir("/nfsdata/filedata/eatables/140x140/");
		//System.out.println(imgsArr.size());
	}
	
}
