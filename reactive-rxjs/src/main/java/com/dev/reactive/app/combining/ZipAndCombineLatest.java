package com.dev.reactive.app.combining;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class ZipAndCombineLatest {

	private static final Logger logger = LoggerFactory.getLogger(ZipAndCombineLatest.class);
	
	public static void main(String...strings) throws InterruptedException {
		
		logger.info("Zip Operator");
		
		@NonNull
		Observable<Long> source1 = Observable.interval(200, TimeUnit.MILLISECONDS)
											.take(10);
		
		@NonNull
		Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS)
											.take(10);
		
		
		/*
		Observable.zip(source1, source2, (s1, s2) -> "Source 1: " + s1 + ", Source 2: " + s2)
				.subscribe((s) -> logger.info("onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		*/
		
		logger.info("CombineLast Operator");
		
		Observable.combineLatest(source1, source2, (s1, s2) -> "Source 1: " + s1 + ", Source 2: " + s2)
				.subscribe((s) -> logger.info("onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		Thread.sleep(20000);
	}
}
