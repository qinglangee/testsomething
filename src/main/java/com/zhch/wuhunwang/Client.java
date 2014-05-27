package com.zhch.wuhunwang;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class Client {
	char[] empty = new char[] { 0x4e, 0x25, 0x26, 0x30, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x06, 0x00,
			0x00, 0x02, 0x03 };
	char[] exp001 = new char[] { 0x4e, 0x25, 0x26, 0x30, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x18, 0x00,
			0x00, 0x01, 0x34 };
	char[] exp002 = new char[] { 0x4e, 0x25, 0x26, 0x30, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x18, 0x00,
			0x00, 0x01, 0x35 };
	byte[] hero01 = new byte[] { 0x4e, 0x25, 0x26, 0x30, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x19, 0x00,
			0x00, 0x01, (byte) 0xfc };
	char[] loginPre = new char[] { 0x4e, 0x25, 0x26, 0x30, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x2b, 0x00,
			0x00, 0x00, 0x65 };
	char[] whask1 = new char[] { 0x4e, 0x25, 0x26, 0x30, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x10, 0x00,
			0x00, 0x01, 0x36 };
	char[] whs001 = new char[] { 0x4e, 0x25, 0x26, 0x30, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x18, 0x00,
			0x00, 0x01, 0x37 };
	char[] whs002 = new char[] { 0x4e, 0x25, 0x26, 0x30, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x18, 0x00,
			0x00, 0x01, 0x2e };

	int preLength = loginPre.length;
	// pre001{"tollgateID:13001"}
	// suc001{"tollgateID:13001"} 27817
	// pre001{"tollgateID:13002"}
	// suc001{"tollgateID:13002"}

	DataInputStream ds;
	PrintWriter pw;
	OutputStream os;
	int exp = 28000;

	public void printPre() {
		SortedMap<String, String> preMap = new TreeMap<String, String>();
		preMap.put("loginPre", "4e25263009000000000000002b00000065");
		preMap.put("empty", "4e25263009000000000000000600000203");
		preMap.put("exp001", "4e25263009000000000000001800000134");
		preMap.put("exp002", "4e25263009000000000000001800000135");
		preMap.put("whs001", "4e25263009000000000000001800000137");
		preMap.put("whs002", "4e2526300900000000000000180000012e");
		preMap.put("whask1", "4e25263009000000000000001000000136");
		preMap.put("hero01", "4e252630090000000000000019000001fc");
		for (Entry<String, String> e : preMap.entrySet()) {
			String s = "char[] ";
			s = s + e.getKey() + " = new char[]{";
			String a = e.getValue();
			for (int i = 0; i < a.length(); i = i + 2) {
				if (i > 0) {
					s += ",";
				}
				s += "0x" + a.charAt(i) + a.charAt(i + 1);
			}
			s += "};";
			if (e.getKey().equals("hero01")) {
				s = s.replaceAll("char", "byte").replace("0xfc", "1&0xfc");
			}
			System.out.println(s);
		}
	}

	public void test() {
		try {
			// Socket socket=new Socket("192.168.199.220",4700);
			Socket socket = new Socket("42.96.176.136", 8191);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ds = new DataInputStream(socket.getInputStream());

			String readline;

			readline = "1"; // 从系统标准输入读入一字符串
			while (!readline.equals("ppp")) {
				System.out.println("Client:" + readline);
				if ("1".equals(readline)) {
					login();
					// heroUp(3);
				} else if ("2".equals(readline)) {
					for (int i = 1; i <= 120; i++) {
						lilian(i);
					}
				} else if ("3".equals(readline)) {
					for (int i = 0; i < 15000; i++) {
						wuhunshi(69);
						heroUp(3);
						heroUp(3);
						heroUp(4);
						heroUp(4);
						System.out.println("time:" + i);
					}
					// for (int i = 0; i < 1500000; i++) {
					// wuhunshi(77);
					// System.out.println("time:" + i);t 
					// }
				} else if ("4".equals(readline)) {
					wuhunask();
				} else if ("5".equals(readline)) {
					heroUp(3);
				}
				readline = sin.readLine(); // 从系统标准输入读入一字符串
			}

			pw.close(); // 关闭Socket输出流
			is.close(); // 关闭Socket输入流
			socket.close(); // 关闭Socket
		} catch (Exception e) {
			System.out.println("Error" + e); // 出错，则打印出错信息
		}

	}

	private void login() throws IOException {
		sendMsg(loginPre, "{\"userName\":\"2396\",\"password\":\"454721\"}");
	}

	private void lilian(int stage) throws IOException {
		System.out.println("stage:" + stage);
		String stageStr = "" + (13000 + stage);
		sendMsg(empty, "{}");
		sleep(300);
		sendMsg(exp001, "{\"tollgateID\":" + stageStr + "}");
		sleep(300);
		sendMsg(exp002, "{\"tollgateID\":" + stageStr + "}");
		sleep(1500);
	}

	private void wuhunshi(int stage) {
		// 37 1000 经验 2000武魂
		// 57 5000 武魂
		// 54 3500 经验
		// 77 15000 武魂
		// 69 4000经验
		// 70 70 威望
		// 483510 96312
		System.out.println("wuhunshi:" + stage);
		String stageStr = "" + (10100 + stage);
		// sendMsg(whs001, "{\"tollgateID\":"+stageStr+"}");
		// sleep(300);
		sendMsg(whs002, "{\"tollgateID\":" + stageStr + "}");
		sleep(30);
	}

	private void wuhunask() {
		// 10137 1000 经验 2000武魂
		// 483510 96312
		// sendMsg(whs001, "{\"tollgateID\":"+stageStr+"}");
		// sleep(300);
		sendMsg(whask1, "{\"maxId\":78}");
		sleep(100);
	}

	private void heroUp(int heroId) throws IOException {
		// heroId 暗娘 4 绿猫 3
		sendMsg2(hero01, "{\"heroID\":" + heroId + ",\"type\":1}");
		sleep(50);
	}

	private void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void sendMsg(char[] pre, String content) {
		pw.write(pre);
		pw.print(content);
		pw.flush();

		byte[] bt = new byte[65535];
		try {
			ds.read(bt);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] msgByte = new byte[65535];
		for (int i = 0; i < bt.length - preLength; i++) {
			msgByte[i] = bt[i + preLength];
		}
		// 处理接收到的报文，转换成字符串
		String message = new String(msgByte).trim();
		System.out.println("Server:" + message);
	}

	private void sendMsg2(byte[] pre, String content) throws IOException {
		os.write(pre);
		// for(int i=0;i<5;i++){
		// pw.print(-1);
		// }
		os.write(content.getBytes());
		os.flush();
		byte[] bt = new byte[65535];
		try {
			ds.read(bt);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] msgByte = new byte[65535];
		for (int i = 0; i < bt.length - preLength; i++) {
			msgByte[i] = bt[i + preLength];
		}
		// 处理接收到的报文，转换成字符串
		String message = new String(msgByte).trim();
		System.out.println("Server:" + message);
	}

	public static void main(String args[]) {
		Client client = new Client();
		client.test();
		// client.printPre();
	}
}