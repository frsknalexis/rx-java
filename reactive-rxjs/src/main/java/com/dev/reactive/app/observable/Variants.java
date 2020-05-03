package com.dev.reactive.app.observable;

import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import org.slf4j.Logger;

public class Variants {

	private static final Logger logger = LoggerFactory.getLogger(Variants.class);
	
	public static void main(String...strings) {
		Observable<String> source = Observable.just("Alex", "Justin", "Jack");
		Observable<String> sourceEmpty = Observable.empty();
		
		sourceEmpty.first("Name")
			.subscribe((s) -> logger.info("singleElement onSuccess -> {}", s));
		
		logger.info("Single Method");
		Single<String> singleSource = Single.just("Alex");
		singleSource.subscribe((s) -> logger.info("onSuccess -> {}", s));
		
		logger.info("Maybe Observable");
		
		source.firstElement()
			.subscribe((s) -> logger.info("onSuccess -> {}", s), 
						(e) -> logger.info("onError -> {}", e.getMessage()), 
						() -> logger.info("onComplete"));
			
		sourceEmpty.firstElement()
				.subscribe((s) -> logger.info("onSuccess -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("Completable Observable");
		
		Completable completable = Completable.complete();
		completable.subscribe(() -> logger.info("onComplete"));
	
		logger.info("Completable Observable 1");
		Completable.fromRunnable(() -> logger.info("Some process executing"))
				.subscribe(() -> logger.info("The process executed successfully"));
	}
}