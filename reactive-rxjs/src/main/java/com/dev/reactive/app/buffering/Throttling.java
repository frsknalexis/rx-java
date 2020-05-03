package com.dev.reactive.app.buffering;

import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;

public class Throttling {

	private static final Logger logger = LoggerFactory.getLogger(Throttling.class);
	
	public static void main(String...strings) {
		Observable<String> source = Observable.create((e) -> {
			e.onNext("A");
			Thread.sleep(200);
			e.onNext("B");
			Thread.sleep(100);
			e.onNext("C");
			Thread.sleep(400);
			e.onNext("D");
			Thread.sleep(300);
			e.onNext("E");
			Thread.sleep(800);
			e.onNext("F");
			Thread.sleep(900);
			e.onNext("X");
			Thread.sleep(600);
			e.onNext("Y");
			Thread.sleep(1000);
			e.onNext("Z");
			e.onComplete();
		});
		
		/*
		logger.info("ThrottleFirst Operator");
		
		source.throttleFirst(1000, TimeUnit.MILLISECONDS)
			.subscribe((s) -> logger.info("onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));

		logger.info("Sample o ThrottleLast Operator");
		source.sample(1000, TimeUnit.MILLISECONDS)
			.subscribe((s) -> logger.info("onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		*/
		
		logger.info("throttleWithTimeout operator");
		source.throttleWithTimeout(700, TimeUnit.MILLISECONDS)
			.subscribe((s) -> logger.info("onNext -> {}", s),
					(e) -> logger.info("onError -> {}", e.getMessage()),
					() -> logger.info("onComplete"));
	}
}