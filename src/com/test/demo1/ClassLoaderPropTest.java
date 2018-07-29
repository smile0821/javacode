package com.test.demo1;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {
	public static void main(String[] args) throws IOException {
		ClassLoader sysLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器："+sysLoader);
		Enumeration<URL> em1 = sysLoader.getResources("");
		while(em1.hasMoreElements())
		{
			System.out.println(em1.nextElement());
		}
		
		ClassLoader extensionLoader = sysLoader.getParent();
		System.out.println("扩展类加载器："+extensionLoader);
		System.out.println("扩展类加载器的加载路径："+System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器的parent:"+extensionLoader.getParent());
	}
}
