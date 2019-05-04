package com.test.thread;

/**
 * @author 51 线程安全
 */

class ThreadDemo1 implements Runnable {
	private int count = 100;
	private Object mutex=new Object();

	@Override
	public void run() {
		while (count > 0) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (mutex) {
				if(count>0)
				{
					System.out.println("当前线程:" + Thread.currentThread().getId() + ",name:"
							+ Thread.currentThread().getName() + ":售出第" + (100 - count + 1) + "张票");
					count--;
				}
			}
		}
	}
}

/**
 * @author 51 模拟100张票，两个窗口进行售票
 */
public class ThreadSecurityDemo1 {
	public static void main(String[] args) {
		ThreadDemo1 thread = new ThreadDemo1();
		
		Thread thread1 = new Thread(thread);
		Thread thread2 = new Thread(thread);
		thread1.start();
		thread2.start();
	}
}
