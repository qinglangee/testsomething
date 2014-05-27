package com.zhch.image;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;

public class ReadImage {
	public void test() {
		// 读取宽高
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("/home/lifeix/temp/d3/heng.png"));
		    System.out.println("w: "  + img.getWidth() + " h:  " + img.getHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readExif() throws ImageProcessingException, IOException, MetadataException{
		File file = new File("/home/lifeix/temp/d3/set.jpg");
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		Metadata metadata = ImageMetadataReader.readMetadata(in, true);
//		Metadata metadata = PngMetadataReader.readMetadata(file);
		for (Directory directory : metadata.getDirectories()) {
			System.out.println(directory.getName()+"===========================");
			Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
			System.out.println(date);
			System.out.println(directory.getTagCount());
		    for (Tag tag : directory.getTags()) {
		    	System.out.println(tag);
		        System.out.println(tag.getTagName() + " " + tag.getTagType() + " " + tag.getTagTypeHex() + " " + tag.getDescription());
		    }
		}
		Directory dir = metadata.getDirectory(ExifIFD0Directory.class);
		if(dir != null){
			int orientation = dir.getInt(0x0112);  // 0x0112 是Orientation tag对应的数字
			System.out.println(orientation);
			// Orientation 相关说明 http://blog.csdn.net/daisyhd/article/details/6000962
		}else{
			System.out.println("ExifIFD0Directory.class  is null" );
		}
	}

	public static void main(String[] args) throws ImageProcessingException, IOException, MetadataException {
		ReadImage t = new ReadImage();
		t.test();
//		t.readExif();
	}
}
