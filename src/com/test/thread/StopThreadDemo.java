package com.test.thread;

class StopThread extends Thread
{
	public boolean exeFlag = true;
	@Override
	public synchronized void run() {
		while(exeFlag)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+"线程被中断.");
				stopThread();
			}
			System.out.println(Thread.currentThread().getName()+"-------我是子线程.");
		}
	}
	
	public void stopThread()
	{
		exeFlag = false;
	}
}

public class StopThreadDemo {
	public static void main(String[] args) {
		StopThread th1 = new StopThread();
		StopThread th2 = new StopThread();
		th1.start();
		th2.start();
		for (int i = 0; i < 30; i++) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("main..");
			if(i==29)
			{
//				th1.stopThread();
//				th2.stopThread();
				th1.interrupt();
				th2.interrupt();
			}
		}
	}
}
