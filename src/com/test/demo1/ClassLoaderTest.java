package com.test.demo1;

public class ClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		cl.loadClass("com.test.demo1.Tester");
		System.out.println("系统加载Tester类");
		Class.forName("com.test.demo1.Tester");
	}
}

