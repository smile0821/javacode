package com.test.thread;

public class DeamonDemo {
	public static class DeamonThread extends Thread
	{
		@Override
		public void run() {
			while(true)
			{
				System.out.println("Deamon Thread.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DeamonThread t1 = new DeamonThread();
//		t1.setDaemon(true);
		t1.start();
		t1.setDaemon(true);
	}
}
