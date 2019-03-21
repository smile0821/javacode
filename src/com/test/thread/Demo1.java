package com.test.thread;

import java.util.Date;

public class Demo1 {
	public static void main(String[] args) {
		long d1 = new Date().getTime();
		int i = 0;
		while(i<10)
		{
			i++;
			System.out.println("i="+i);
		}
		System.out.println("i time:"+(new Date().getTime()-d1));
		commonThread t1 = new commonThread();
		t1.setI(i);
		System.out.println("t1 time:"+(new Date().getTime()-d1));
		t1.start();
		System.out.println("end.");
		System.out.println("i time:"+(new Date().getTime()-d1));
	}
	
}

class commonThread extends Thread
{
	int j;
	int i;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		long d1 = new Date().getTime();
		j=0;
		while(j<10)
		{
			System.out.println("j+i="+(j+i));
			j++;
			try {
				this.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("j time:"+(new Date().getTime()-d1));
	}
	
	
}

