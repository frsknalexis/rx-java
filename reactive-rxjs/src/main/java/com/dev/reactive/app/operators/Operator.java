package com.dev.reactive.app.operators;

import org.slf4j.LoggerFactory;

import java.util.Comparator;

import org.slf4j.Logger;

import io.reactivex.rxjava3.core.Observable;

public class Operator {

	private static final Logger logger = LoggerFactory.getLogger(Operator.class);
	
	public static void main(String...strings) {
		
		logger.info("Filter Operator");
		
		Observable.just(60, 57, 89, 90, 23, 100, 98)
				.filter(i -> i > 75)
				.sorted(Comparator.naturalOrder())
				.subscribe(e -> logger.info("onNext -> {}", e));
				
	}
}
