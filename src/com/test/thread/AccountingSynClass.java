package com.test.thread;

public class AccountingSynClass implements Runnable{
	static int i=0;
	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			increase();
		}
	}

	private static synchronized void increase() {
		i++;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new AccountingSynClass());
		Thread t2 = new Thread(new AccountingSynClass());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("account:"+i);
	}
}
