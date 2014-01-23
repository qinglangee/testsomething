package com.zhch.keyboardmock;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Keyboard {

	static Robot robot;
	public static List<int[]> list = new ArrayList<int[]>(); 
	public static Color base = new Color(255, 255, 255);

	public void test() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		int i = 0;
		while (i < 5) {
			i++;
			robot.keyPress(KeyEvent.VK_SPACE);
			Thread.sleep(10);
			robot.keyRelease(KeyEvent.VK_SPACE);
			Thread.sleep(1);
		}
	}

	public int getPixel(int x, int y) throws AWTException { // 函数返回值为颜色的RGB值。
		Robot rb = null; // java.awt.image包中的类，可以用来抓取屏幕，即截屏。
		rb = new Robot();
		Toolkit tk = Toolkit.getDefaultToolkit(); // 获取缺省工具包
		Dimension di = tk.getScreenSize(); // 屏幕尺寸规格
		Rectangle rec = new Rectangle(0, 0, di.width, di.height);
		BufferedImage bi = rb.createScreenCapture(rec);
		int pixelColor = bi.getRGB(x, y);
		return 16777216 + pixelColor; // pixelColor的值为负，经过实践得出：加上颜色最大值就是实际颜色值。
	}

	public void moveMouse() throws InterruptedException, AWTException {
		
		int[] keys = new int[] { KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_J, KeyEvent.VK_K,
				KeyEvent.VK_L };
		int count = 0;
		Point point1 = MouseInfo.getPointerInfo().getLocation();
		System.out.println("x :" + point1.x + "  y:" + point1.y);
		point1 = new Point(322,751);
		for (int i = 0; i < 6; i++) {
			int x = point1.x + 100 * i;
			int y = point1.y - 30*i;
			list.add(i, new int[]{x,y});
		}
		new Thread(new TestColor(0)).start();
//		while (true) {
//			count++;
//			Point point = MouseInfo.getPointerInfo().getLocation();
//			for (int i = 0; i < 6; i++) {
//				int x = point.x + 100 * i;
//				int y = point.y;
//				list.add(i, new int[]{x,y});
////				Color color = robot.getPixelColor(x, y);
////				System.out.println(x+" "+y + " " + color);
////				if (color.equals(base)) {
////					System.out.println(i);
////					if (point.x < 600) {
////						robot.keyPress(keys[i]);
////						Thread.sleep(10);
////						robot.keyRelease(keys[i]);
//////						robot.mouseMove(point.x + 100*i, point.y);
////					}
////				}
//			}
//		}
	}

	public void getColor() {
		// Color pixel = robot.getPixelColor(mousepoint.x, mousepoint.y);
		Point point = MouseInfo.getPointerInfo().getLocation();
		robot.mouseMove(point.x, point.y);
		Color color = robot.getPixelColor(point.x, point.y);
//		System.out.println(color);
	}

	public static void main(String[] args) throws AWTException, InterruptedException {
		robot = new Robot();
		Keyboard t = new Keyboard();
		t.moveMouse();
	}
}

class TestColor implements Runnable{
	int index = 0;
	Robot robot;
	int[] keys = new int[] { KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_J, KeyEvent.VK_K,
			KeyEvent.VK_L };
	public TestColor(int index) throws AWTException{
		this.index = index;
		robot = new Robot();
	}
	public void run(){
		while (true) {
			int[] point = Keyboard.list.get(index);
			int x = point[0];
			int y = point[1];
			long startTime = System.currentTimeMillis();
			Color color = robot.getPixelColor(x, y);
//			Color color2 = robot.getPixelColor(x, y-3);
//			Color color3 = robot.getPixelColor(x, y-6);
//			System.out.println(x+" "+y + " " + color);
//			if (color.equals(Keyboard.base)||color2.equals(Keyboard.base)||color3.equals(Keyboard.base)) {
			if (color.equals(Keyboard.base)) {
				System.out.println("get it");
				if (x < 600) {
					robot.keyPress(keys[index]);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					robot.keyRelease(keys[index]);
//					robot.mouseMove(point.x + 100*i, point.y);
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("cost time :" + (endTime - startTime));
		}
	}
}
