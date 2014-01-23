package com.zhch.gcd;

import java.math.BigInteger;


public class Gcd {
	public void test() {
		BigInteger a1 = new BigInteger("5345452553567");
		BigInteger a2 = new BigInteger("64772856467");
		BigInteger m = new BigInteger("7456534567654464765");
		BigInteger b1 = a1.multiply(m);
		BigInteger b2 = a2.multiply(m);
		
		System.out.println("b1:" + b1 + "  b2:" + b2);
		System.out.println("gcd is:" + b1.gcd(b2));
		System.out.println("gcd is:" + gcd(b1, b2));
	}

	private BigInteger gcd(BigInteger b1, BigInteger b2) {
//		System.out.println("b1:" + b1 + " b2:" + b2);
		if(!b2.equals(new BigInteger("0"))){
			return gcd(b2, b1.mod(b2));
		}else{
			return b1;
		}
	}
	

	public static void main(String[] args) {
		Gcd t = new Gcd();
		t.test();
	}
}
