package com.dev.reactive.app.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleScheduler {

	private static final Logger logger = LoggerFactory.getLogger(ComputationScheduler.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable<String> source = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
											.subscribeOn(Schedulers.single());
		
		source.subscribe((s) -> sensitiveTask());	
		source.subscribe((s) -> sensitiveTask());
		source.subscribe((s) -> sensitiveTask());
		source.subscribe((s) -> sensitiveTask());
		source.subscribe((s) -> sensitiveTask());
		source.subscribe((s) -> sensitiveTask());
		
		Thread.sleep(50000);
	}
	
	public static void sensitiveTask() throws InterruptedException {
		Thread.sleep(1000);
		logger.info("Computation Done by -> {}", Thread.currentThread().getName());
	}
}
