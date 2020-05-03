package com.dev.reactive.app.stream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {

	public static void main(String...strings) {
		List<Employee> list = new ArrayList<>();
		
		long startTime;
		long endTime;
		
		for (int i = 0; i < 100; i++) {
			list.add(new Employee("John", 20000));
			list.add(new Employee("Rohn", 3000));
			list.add(new Employee("Tom", 15000));
			list.add(new Employee("Bheem", 8000));
			list.add(new Employee("Shiva", 200));
			list.add(new Employee("Krishna", 50000));
		}
		
		
		startTime = System.currentTimeMillis();
		long listEmployee = list.stream()
								.filter((e) -> e.getSalary() > 1000)
								.count();
		
		System.out.println(listEmployee);
		endTime = System.currentTimeMillis();
		System.out.println("Time taken with Sequential: " + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		long listEmployeeParallel = list.parallelStream()
										.filter(e -> e.getSalary() > 1000)
										.count();
		System.out.println(listEmployeeParallel);
		endTime = System.currentTimeMillis();
		System.out.println("Time taken with parallel stream: " + (endTime - startTime));
	}
}
