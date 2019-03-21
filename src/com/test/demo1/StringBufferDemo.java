package com.test.demo1;

import java.util.Date;

public class StringBufferDemo {
	public static void main(String[] args) {
		long d1 = new Date().getTime();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<5000000;i++)
		{
			sb.append("str1");
			sb.append(String.valueOf("_"));
			sb.append("str2");
			sb.delete(0, sb.length());
//			System.out.println(sb.hashCode());
		}
		System.out.println(new Date().getTime()-d1);
	}
}
