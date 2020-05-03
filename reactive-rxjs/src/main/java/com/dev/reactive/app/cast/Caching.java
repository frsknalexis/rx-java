package com.dev.reactive.app.cast;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class Caching {

	private static final Logger logger = LoggerFactory.getLogger(Caching.class);
	
	public static void main(String...strings) throws InterruptedException {
		
		logger.info("Caching Operator");
		
		@NonNull
		Observable<@NonNull Long> source = Observable.interval(1, TimeUnit.SECONDS)
													.cache();
		
		source.subscribe((s) -> logger.info("Observer 1: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		Thread.sleep(5000);
		
		source.subscribe((s) -> logger.info("Observer 2: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		Thread.sleep(3000);
	}
}
