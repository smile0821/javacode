package com.test.thread;

/**
 * @author 51 同步代码块与同步函数的区别： 同步函数使用的是this锁
 * 将obj锁换为this锁后实现两个窗口同时售票
 */
class ThreadDemo2 implements Runnable {
	private int count = 100;
	private Object obj = new Object();
	public boolean flag = true;

	@Override
	public void run() {
		if (flag) {
			while (count > 0) {
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
		} else {
			while (count > 0) {
				show();
			}
		}
	}

	private synchronized void show() {
		if (count > 0) {
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("当前线程:" + Thread.currentThread().getId() + ",name:" + Thread.currentThread().getName()
					+ ":售出第" + (100 - count + 1) + "张票");
			count--;
		}
	}

}

public class ThreadSecurityDemo2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo2 thread = new ThreadDemo2();
		Thread thread1 = new Thread(thread, "1号窗口");
		Thread thread2 = new Thread(thread, "2号窗口");
		thread1.start();
		Thread.sleep(40);
		thread.flag = false;
		thread2.start();
	}
	/**
	 * 当前线程:10,name:1号窗口:售出第1张票 当前线程:11,name:2号窗口:售出第2张票 当前线程:10,name:1号窗口:售出第2张票
	 * 当前线程:10,name:1号窗口:售出第4张票 当前线程:11,name:2号窗口:售出第4张票 当前线程:11,name:2号窗口:售出第6张票
	 * 当前线程:10,name:1号窗口:售出第6张票 当前线程:10,name:1号窗口:售出第8张票 当前线程:11,name:2号窗口:售出第8张票
	 * 当前线程:10,name:1号窗口:售出第10张票 当前线程:11,name:2号窗口:售出第10张票 当前线程:10,name:1号窗口:售出第12张票
	 * 当前线程:11,name:2号窗口:售出第12张票 当前线程:11,name:2号窗口:售出第14张票 当前线程:10,name:1号窗口:售出第14张票
	 * 当前线程:11,name:2号窗口:售出第16张票 当前线程:10,name:1号窗口:售出第16张票 当前线程:10,name:1号窗口:售出第18张票
	 * 当前线程:11,name:2号窗口:售出第18张票 当前线程:11,name:2号窗口:售出第20张票 当前线程:10,name:1号窗口:售出第20张票
	 * 当前线程:10,name:1号窗口:售出第22张票 当前线程:11,name:2号窗口:售出第22张票 当前线程:10,name:1号窗口:售出第24张票
	 * 当前线程:11,name:2号窗口:售出第25张票 当前线程:11,name:2号窗口:售出第26张票 当前线程:10,name:1号窗口:售出第26张票
	 * 当前线程:10,name:1号窗口:售出第28张票 当前线程:11,name:2号窗口:售出第28张票 当前线程:11,name:2号窗口:售出第30张票
	 * 当前线程:10,name:1号窗口:售出第30张票 当前线程:10,name:1号窗口:售出第32张票 当前线程:11,name:2号窗口:售出第32张票
	 * 当前线程:11,name:2号窗口:售出第34张票 当前线程:10,name:1号窗口:售出第34张票 当前线程:10,name:1号窗口:售出第36张票
	 * 当前线程:11,name:2号窗口:售出第36张票 当前线程:10,name:1号窗口:售出第38张票 当前线程:11,name:2号窗口:售出第39张票
	 * 当前线程:11,name:2号窗口:售出第40张票 当前线程:10,name:1号窗口:售出第41张票 当前线程:11,name:2号窗口:售出第42张票
	 * 当前线程:10,name:1号窗口:售出第42张票 当前线程:10,name:1号窗口:售出第44张票 当前线程:11,name:2号窗口:售出第44张票
	 * 当前线程:10,name:1号窗口:售出第46张票 当前线程:11,name:2号窗口:售出第46张票 当前线程:11,name:2号窗口:售出第48张票
	 * 当前线程:10,name:1号窗口:售出第48张票 当前线程:10,name:1号窗口:售出第50张票 当前线程:11,name:2号窗口:售出第50张票
	 * 当前线程:11,name:2号窗口:售出第52张票 当前线程:10,name:1号窗口:售出第52张票 当前线程:11,name:2号窗口:售出第54张票
	 * 当前线程:10,name:1号窗口:售出第54张票 当前线程:10,name:1号窗口:售出第56张票 当前线程:11,name:2号窗口:售出第56张票
	 * 当前线程:10,name:1号窗口:售出第58张票 当前线程:11,name:2号窗口:售出第58张票 当前线程:10,name:1号窗口:售出第60张票
	 * 当前线程:11,name:2号窗口:售出第60张票 当前线程:11,name:2号窗口:售出第62张票 当前线程:10,name:1号窗口:售出第62张票
	 * 当前线程:11,name:2号窗口:售出第64张票 当前线程:10,name:1号窗口:售出第64张票 当前线程:10,name:1号窗口:售出第66张票
	 * 当前线程:11,name:2号窗口:售出第66张票 当前线程:10,name:1号窗口:售出第68张票 当前线程:11,name:2号窗口:售出第68张票
	 * 当前线程:11,name:2号窗口:售出第70张票 当前线程:10,name:1号窗口:售出第70张票 当前线程:11,name:2号窗口:售出第72张票
	 * 当前线程:10,name:1号窗口:售出第72张票 当前线程:10,name:1号窗口:售出第74张票 当前线程:11,name:2号窗口:售出第74张票
	 * 当前线程:10,name:1号窗口:售出第76张票 当前线程:11,name:2号窗口:售出第76张票 当前线程:11,name:2号窗口:售出第78张票
	 * 当前线程:10,name:1号窗口:售出第78张票 当前线程:10,name:1号窗口:售出第80张票 当前线程:11,name:2号窗口:售出第80张票
	 * 当前线程:11,name:2号窗口:售出第82张票 当前线程:10,name:1号窗口:售出第82张票 当前线程:10,name:1号窗口:售出第84张票
	 * 当前线程:11,name:2号窗口:售出第84张票 当前线程:11,name:2号窗口:售出第86张票 当前线程:10,name:1号窗口:售出第86张票
	 * 当前线程:10,name:1号窗口:售出第88张票 当前线程:11,name:2号窗口:售出第88张票 当前线程:11,name:2号窗口:售出第90张票
	 * 当前线程:10,name:1号窗口:售出第90张票 当前线程:10,name:1号窗口:售出第92张票 当前线程:11,name:2号窗口:售出第92张票
	 * 当前线程:11,name:2号窗口:售出第94张票 当前线程:10,name:1号窗口:售出第94张票 当前线程:10,name:1号窗口:售出第96张票
	 * 当前线程:11,name:2号窗口:售出第96张票 当前线程:10,name:1号窗口:售出第98张票 当前线程:11,name:2号窗口:售出第98张票
	 * 当前线程:10,name:1号窗口:售出第100张票 当前线程:11,name:2号窗口:售出第100张票
	 * 
	 * 
	 */
}
