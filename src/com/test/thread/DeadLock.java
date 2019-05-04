package com.test.thread;

/**
 * @author 51 死锁
 */
class ThreadDemo3 implements Runnable {
	private int count = 100;
	private Object obj = new Object();
	public boolean flag = true;

	@Override
	public void run() {
		if (flag) {
			while (count > 0) {
				// 首先需要obj锁；然后需要this锁
				synchronized (obj) {
					show();
				}
			}
		} else {
			while (count > 0) {
				// 先需要this锁，再需要obj锁
				show();
			}
		}
	}

	private synchronized void show() {
		synchronized (obj) {
			if (count > 0) {
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("当前线程:" + Thread.currentThread().getId() + ",name:"
						+ Thread.currentThread().getName() + ":售出第" + (100 - count + 1) + "张票");
				count--;
			}
		}
	}

}

public class DeadLock {
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo3 thread = new ThreadDemo3();
		Thread thread1 = new Thread(thread, "1号窗口");
		Thread thread2 = new Thread(thread, "2号窗口");
		thread1.start();
		Thread.sleep(40);
		thread.flag = false;
		thread2.start();
	}
}
