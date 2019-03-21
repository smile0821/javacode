package com.test.thread;

public class SimpleWaitNotify {
	final static SimpleWaitNotify object = new SimpleWaitNotify();
	public static class T1 extends Thread{
		@Override
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis()+":T1 start.");
				try {
					System.out.println(System.currentTimeMillis()+":T1 wait for object.");
					object.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis()+":T1 end.");
			}
		}
	}
	public static class T2 extends Thread{
		@Override
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis()+":T2 start.");
				object.notify();
				System.out.println(System.currentTimeMillis()+":T2 end.");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		Thread t1 = new T1();
		Thread t2 = new T2();
		t1.start();
		t2.start();
	}
}