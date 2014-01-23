package com.zhch.stringreplace.gui;

import javax.swing.JFrame;

public class BlackBoard extends JFrame{

	private static final long serialVersionUID = -7609589551595338727L;

	public BlackBoard(){
		setTitle("Java Panel");
	}

	public static void main(String[] args) {
		BlackBoard t = new BlackBoard();
		t.setBounds(0, 0, 300, 300);
		t.setVisible(true);
	}
}
