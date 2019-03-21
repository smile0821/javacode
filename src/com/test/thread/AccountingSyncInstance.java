package com.test.thread;

public class AccountingSyncInstance implements Runnable {
	static AccountingSyncInstance instance = new AccountingSyncInstance();
	static int j=0;
	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			synchronized (instance) {
				j++;
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// 实例加锁
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("account:"+j);
	}
}
