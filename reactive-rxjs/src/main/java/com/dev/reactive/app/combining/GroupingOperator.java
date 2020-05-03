package com.dev.reactive.app.combining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.reactive.app.operators.Employee;

import io.reactivex.rxjava3.core.Observable;

public class GroupingOperator {

	private static final Logger logger = LoggerFactory.getLogger(GroupingOperator.class);
	
	public static void main(String...strings) {
		Observable<Employee> source = Observable.just(new Employee(101, "Alexa", 60000, 4.0),
				new Employee(123, "Dhwanit", 94000, 4.7),
				new Employee(236, "Mike", 65000, 4.0),
				new Employee(155, "Ella", 85000, 4.4),
				new Employee(443, "George", 50000, 3.6),
				new Employee(127, "Shreeja", 85000, 4.5),
				new Employee(509, "Daniel", 60000, 4.0),
				new Employee(344, "Lucy", 94000, 4.7));
		
		source.groupBy(Employee::getRating)
			.flatMapSingle(e -> e.toMultimap(Employee::getRating))
			.subscribe((m) -> logger.info("onNext -> {}", m),
						(e) -> logger.info("onError -> {}", e.getMessage()),
						() -> logger.info("onComplete"));
		
		source.groupBy(Employee::getRating)
				.flatMapSingle(e -> e.toList())
				.subscribe((l) -> logger.info("onNext -> {}", l), 
							(e) -> logger.info("onError -> {}", e.getMessage()), 
							() -> logger.info("onComplete"));
	}
}
