package com.dev.reactive.app.combining;

import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;

public class MergedAndConcat {

	private static final Logger logger = LoggerFactory.getLogger(MergedAndConcat.class);
	
	public static void main(String...strings) throws InterruptedException {
		
		logger.info("Merge Method");
		Observable<String> source1 = Observable.just("Ella", "Alexa", "Lily");
		Observable<String> source2 = Observable.just("Priya", "Chloe");
		
		Observable.merge(source1, source2)
				.subscribe((s) -> logger.info("onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		// logger.info("Merge Method 2");
		@NonNull
		Observable<String> sourceObservable1 = Observable.interval(1, TimeUnit.SECONDS)
														.map((l) -> "source 1: " + l);
		
		@NonNull
		Observable<String> sourceObservable2 = Observable.interval(1, TimeUnit.SECONDS)
														.map((l) -> "source 2: " + l);
		
		/*
		Observable.merge(sourceObservable1, sourceObservable2)
				.subscribe((s) -> logger.info("onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		Thread.sleep(10000);
		
		*/
		
		logger.info("Concat Method");
		
		/*
		Observable.concat(sourceObservable1, sourceObservable2)
				.subscribe((s) -> logger.info("onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		*/
		
		sourceObservable1.concatWith(sourceObservable2)
						.subscribe((s) -> logger.info("onNext -> {}", s),
									(e) -> logger.info("onError -> {}", e.getMessage()),
									() -> logger.info("onComplete"));
				
		Thread.sleep(20000);
	}
}