package com.dev.reactive.app.backpressure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Conversion {

	private static final Logger logger = LoggerFactory.getLogger(Conversion.class);
	
	public static void main(String...strings) throws InterruptedException {
	
		/*
		logger.info("Observable to Flowable");
		
		Observable.range(1, 1000000)
				.toFlowable(BackpressureStrategy.BUFFER)
				.observeOn(Schedulers.io())
				.subscribe((e) -> {
					logger.info("onNext -> {}", e);
					logger.info("Current Thread -> {}", Thread.currentThread().getName());
				});
		
		Thread.sleep(5000);
		
		*/
		
		logger.info("Flowable to Observable");
		Flowable.range(1, 1000000)
				.toObservable()
				.observeOn(Schedulers.io())
				.subscribe((e) -> {
					logger.info("onNext -> {}", e);
					logger.info("Current Thread -> {}", Thread.currentThread().getName());
				});
		
		Thread.sleep(5000);
				
	}
}
