package com.test.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo1 {
	public static void main(String[] args) {
		File file = new File("/notifyTest/"+"abcdef.txt");
		if(!file.exists())
		{
			if(!file.getParentFile().exists())
			{
				file.getParentFile().mkdirs();
			}
		}
		else
		{
			file.delete();
		}
		String notify = "cudytiju";
		byte data[] = notify.getBytes();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(null != fos)
			{
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		System.out.println("输出完成");
	}
}