package com.dev.reactive.app.buffering;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class Buffering {

	private static final Logger logger = LoggerFactory.getLogger(Buffering.class);
	
	public static void main(String...strings) throws InterruptedException {
		
		/*
		logger.info("Buffering example 1");
		
		Observable.range(1, 30)
				.buffer(4, 7)
				.subscribe((e) -> logger.info("onNext -> {}", e));
		
		logger.info("Buffering timespan");
		
		Observable.interval(500, TimeUnit.MILLISECONDS)
				.buffer(1, TimeUnit.SECONDS, 2)
				.subscribe((l) -> logger.info("onNext -> {}", l));
		
		logger.info("Buffering Observable");
		
		@NonNull
		Observable<Long> observableInterval = Observable.interval(500, TimeUnit.MILLISECONDS);
		Observable.interval(1000, TimeUnit.MILLISECONDS)
				.buffer(observableInterval)
				.subscribe((l) -> logger.info("onNext -> {}", l));
		
		Thread.sleep(8000);
		*/
		logger.info("Window operator");
		
		@NonNull
		Observable<Long> observableInterval = Observable.interval(500, TimeUnit.MILLISECONDS);
		Observable.interval(1000, TimeUnit.MILLISECONDS)
				.window(observableInterval)
				.subscribe((l) -> logger.info("onNext -> {}", l));
		
		Thread.sleep(8000);
	}
}