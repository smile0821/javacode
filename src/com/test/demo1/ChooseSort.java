package com.test.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class ChooseSort {
	List<Employee> employees = Arrays.asList(
			new Employee("张三", 18,9999.9),
			new Employee("李四", 58,5555.5),
			new Employee("王五", 26,3333.3),
			new Employee("赵六", 36,6666.6),
			new Employee("田七", 12,8888.8)
			);
	@Test
	public void test1()
	{
		Stream<Employee> s= employees.stream()
				.filter((e) -> {
					System.err.println("中间操作");
					return e.getAge()>20;
				});
		
		s.forEach(System.out::println);
	}
	
	@Test
	public void test2()
	{
		employees.stream()
				.filter((e)->
				{
					System.out.println("短路");
					return e.getSalary()>5000;
				}
				)
				.limit(2)
				.forEach(System.out::println);
	}
}
 