package com.test.demo1;

import java.util.Date;

public class StringDemo {
	public static void main(String[] args) {
		long d1 = new Date().getTime();
		String str = "";
		for(int i=0;i<5000000;i++)
		{
			str = "str1"+"str2"+String.valueOf(i);
//			System.out.println(str.getBytes());
			str = "";
		}
		System.out.println(new Date().getTime()-d1);
	}
}
