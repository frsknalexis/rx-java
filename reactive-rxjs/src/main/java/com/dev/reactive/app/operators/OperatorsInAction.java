package com.dev.reactive.app.operators;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;

public class OperatorsInAction {

	private static final Logger logger = LoggerFactory.getLogger(OperatorsInAction.class);
	
	public static void main(String...strings) {
		Observable<Employee> source = Observable.just(new Employee(101, "Alexa", 60000, 4.0),
				new Employee(123, "Dhwanit", 94000, 4.7),
				new Employee(236, "Mike", 65000, 4.0),
				new Employee(155, "Ella", 85000, 4.4),
				new Employee(443, "George", 50000, 3.6),
				new Employee(127, "Shreeja", 85000, 4.5),
				new Employee(509, "Daniel", 60000, 4.0),
				new Employee(344, "Lucy", 94000, 4.7));
		
		source.filter(e -> e.getRating() > 4.0)
			.sorted((e1, e2) -> Double.compare(e2.getRating(), e1.getRating()))
			.map(Employee::getName)
			.take(4)
			.toList() // return a single observable instead observable
			.subscribe((s) -> logger.info("onNext -> {}", s));
		
		logger.info("Operator example 2");
		
		List<Integer> expenses = List.of(200, 500, 300, 340, 129, 234, 999, 1030, 3400, 890, 996, 789);
		Observable.fromIterable(expenses)
				.scan(Integer::sum)
				.subscribe((i) -> logger.info("onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("Operator Example 3");
		
		Observable.fromIterable(expenses)
				.reduce(0, Integer::sum)
				.subscribe((i) -> logger.info("Result Expenses: onSuccess -> {}", i));
	}
}