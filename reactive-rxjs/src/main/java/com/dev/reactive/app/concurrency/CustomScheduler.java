package com.dev.reactive.app.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CustomScheduler {

	private static final Logger logger = LoggerFactory.getLogger(ComputationScheduler.class);
	
	public static void main(String...strings) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(20);
		
		@NonNull
		Scheduler scheduler = Schedulers.from(executor);
		
		Observable<String> source = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
											.subscribeOn(scheduler)
											.doFinally(executor::shutdown);
		
		source.subscribe((s) -> compute());	
		source.subscribe((s) -> compute());
		source.subscribe((s) -> compute());
		source.subscribe((s) -> compute());
		source.subscribe((s) -> compute());
		source.subscribe((s) -> compute());
	}
	
	public static void compute() throws InterruptedException {
		Thread.sleep(1000);
		logger.info("Computation Done by -> {}", Thread.currentThread().getName());
	}
}