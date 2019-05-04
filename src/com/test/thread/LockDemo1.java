package com.test.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Res
{
	public String name;
	public String sex;
	public boolean flag;
	public Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
}

class InThread extends Thread
{
	public Res res;
	
	public InThread(Res res) {
		this.res = res;
	}
	
	@Override    
	public void run() {
		int count = 0;
		while(true)
		{
			try {
				res.lock.lock();
				// 如果flag为true表示正在读，暂停写操作
				if(res.flag)
				{
					try {
						res.condition.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(count == 0)
				{
					res.name = "小黑";
					res.sex = "男";
				}
				else
				{
					res.name = "小兰";
					res.sex = "女";
				}
				count=(count+1)%2;
				res.flag = true;
				res.condition.signal();
			} catch(Exception e)
			{
				
			}
			finally {
				// 释放锁
				res.lock.unlock();
			}
		}
	}
}

class OutThread extends Thread
{
	public Res res;
	public OutThread(Res res) {
		this.res = res;
	}
	@Override
	public void run() {
		while(true)
		{
			try {
				res.lock.lock();
				if(!res.flag)
					res.condition.await();
				System.out.println("姓名:"+res.name+"性别:"+res.sex);
				res.flag = false;
				res.condition.signal();
			} catch(Exception e)
			{
				
			}
			finally {
				res.lock.unlock();
			}
		}
	}
}

public class LockDemo1 {
	public static void main(String[] args) {
		Res res = new Res();
		OutThread out = new OutThread(res);
		InThread in = new InThread(res);
		out.start();
		in.start();
	}
}
