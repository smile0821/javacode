package com.test.demo1;

public class RegexTest {
	public static void main(String[] args) {
		String str = "123a45664";
		String regex = "[1-9]\\d{4,14}";
		boolean flag = str.matches(regex);
        if(flag)
            System.out.println(str+"...is ok");
        else
            System.out.println(str+"... 不合法");
	}
}
