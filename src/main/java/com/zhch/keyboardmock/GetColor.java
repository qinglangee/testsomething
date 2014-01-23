package com.zhch.keyboardmock;

/* Java屏幕取色工具 */
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GetColor extends JFrame implements ActionListener {
	private static final long serialVersionUID = -3590024511714989686L;
	JLabel RGB_label, Hex_label, mouse_track_label;
	JTextField RGB_jtf, Hex_jtf;
	JButton start, explain;
	JPanel jpcolor;

	// 初始化程序主窗口
	public GetColor() {
		Container contentPane = this.getContentPane();
		GridBagLayout gbLayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		contentPane.setLayout(gbLayout);
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
//		Hex_label = new JLabel("十六进制值:");
//		Hex_label.setFont(new java.awt.Font("MS Song", 0, 12));
		Hex_label = new JLabel("16jinzhi:");
		gbLayout.setConstraints(Hex_label, c);
		contentPane.add(Hex_label);

		c.gridx = 0;
		c.gridy = 1;
		Hex_jtf = new JTextField();
		gbLayout.setConstraints(Hex_jtf, c);
		contentPane.add(Hex_jtf);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		RGB_label = new JLabel("RGB:");
		gbLayout.setConstraints(RGB_label, c);
		contentPane.add(RGB_label);

		c.gridx = 1;
		c.gridy = 1;
		ImageIcon im = new ImageIcon("buttonicon.png");
		start = new JButton(im);
		start.addActionListener(this);
		gbLayout.setConstraints(start, c);
		contentPane.add(start);

		c.gridx = 2;
		c.gridy = 1;
		jpcolor = new JPanel();
		jpcolor.setBackground(Color.red);
		gbLayout.setConstraints(jpcolor, c);
		contentPane.add(jpcolor);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		RGB_jtf = new JTextField();
		gbLayout.setConstraints(RGB_jtf, c);
		contentPane.add(RGB_jtf);

		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		explain = new JButton("说明");
		explain = new JButton("shuoming:");
		explain.addActionListener(this);
		gbLayout.setConstraints(explain, c);
		contentPane.add(explain);

		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		mouse_track_label = new JLabel("鼠标轨迹:");
		mouse_track_label = new JLabel("shubiao:");
		gbLayout.setConstraints(mouse_track_label, c);
		contentPane.add(mouse_track_label);

		this.setTitle("Java取色器");
		this.setAlwaysOnTop(true);
		this.setSize(250, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String args[]) {
		GetColor gc = new GetColor();
	}

	// 接收按钮事件
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == start) {
			doStart();
		} else if (ae.getSource() == explain) {
			doExplain();
		}
	}

	// 更新保存当前取色,即确定取色
	private void updates(Color bg) {
		jpcolor.removeAll();
		jpcolor.setBackground(bg);
		this.setResizable(true);
		this.setCursor(Cursor.DEFAULT_CURSOR);
		SwingUtilities.updateComponentTreeUI(this);
	}

	// 开始取色按钮事件对应的方法
	private void doStart() {
		try {
			Robot ro = new Robot();
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension di = tk.getScreenSize();
			Rectangle rec = new Rectangle(0, 0, di.width, di.height);
			BufferedImage bi = ro.createScreenCapture(rec);
			JFrame jf = new JFrame();
			jf.getContentPane().add(new Temp(jf, bi, di.width, di.height));
			jf.setUndecorated(true);
			jf.setSize(di);
			jf.setVisible(true);
			this.setResizable(false);
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}

	// 说明信息
	private void doExplain() {
		String copyright;
		copyright = "Java屏幕取色器:\n单击取色按钮开始取色,在程序窗口以外再次单击鼠标以确定取色!\n" + "由威龙网站长[灰色心情]制作!";
		copyright = copyright + " 愿与您共同学习,共同进步\n" + "欢迎访问我的主页:http://www.pdfbbs.com\n";
		JOptionPane.showMessageDialog(null, copyright);
	}

	// 一个暂时类，用于显示当前的屏幕图像
	private class Temp extends JPanel implements MouseListener, MouseMotionListener {
		private BufferedImage bi;
		private int width, height;
		private JFrame jf;

		public Temp(JFrame jf, BufferedImage bi, int width, int height) {
			this.jf = jf;
			this.bi = bi;
			this.width = width;
			this.height = height;
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
		}

		public void paintComponent(Graphics g) {
			jf.setCursor(Cursor.CROSSHAIR_CURSOR);
			g.drawImage(bi, 0, 0, width, height, this);
		}

		public void mouseMoved(MouseEvent me) {
			pickColor();
		}

		// 获取鼠标指针当前颜色并显示
		public Color pickColor() {
			Color pixel = new Color(0, 0, 0);
			Robot robot = null;
			Point mousepoint;
			int R, G, B;
			try {
				robot = new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
				System.exit(1);
			}
			mousepoint = MouseInfo.getPointerInfo().getLocation();
			pixel = robot.getPixelColor(mousepoint.x, mousepoint.y);
			R = pixel.getRed();
			G = pixel.getGreen();
			B = pixel.getBlue();
			jpcolor.setBackground(pixel);
			RGB_jtf.setText("R=" + R + ",G=" + G + ",B=" + B);
			Hex_jtf.setText("#" + Integer.toHexString(R) + Integer.toHexString(G) + Integer.toHexString(B));
			mouse_track_label.setText("鼠标轨迹:x=" + mousepoint.x + ",y=" + mousepoint.y);
			return pixel;
		}

		public void mouseExited(MouseEvent me) {

		}

		public void mouseEntered(MouseEvent me) {

		}

		public void mouseDragged(MouseEvent me) {

		}

		public void mousePressed(MouseEvent me) {

		}

		public void mouseReleased(MouseEvent me) {

		}

		public void mouseClicked(MouseEvent me) {
			jf.dispose();
			updates(pickColor());
		}
	}
}