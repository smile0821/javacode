package com.test.java8;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

public class TestLambda2 {
	@Test
	public void test1()
	{
		int num = 0;
		
		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello World "+num);
			}
		};
		
		r.run();
		
		Runnable r1 = () -> System.out.println("Hello Lambda "+num);
		r1.run();
	}
	
	@Test
	public void test2()
	{
		Consumer<String> con = x -> System.out.println(x);
		con.accept("aaa");
		Consumer<Integer> conInt = x -> {x+=333;System.out.println(x);};
		conInt.accept(222);
	}
	
	@Test
	public void test3()
	{
		Comparator<Integer> com = (a,b) -> {
			return Integer.compare(a, b);
		};
	}
	
	
}
