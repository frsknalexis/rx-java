package com.dev.reactive.app.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyRxJava {

	private static final Logger logger = LoggerFactory.getLogger(ConcurrencyRxJava.class);
	
	public static void main(String...strings) {
		Observable<String> source = Observable.create((e) -> {
			new Thread(() -> {
				e.onNext("Hello");
				e.onNext("RxJava");
			}).start();
		});
		
		source.subscribe((s) -> System.out.println("Subscriber 1: onNext -> " + s +" Thread name: " + Thread.currentThread().getName()),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		source.subscribe((s) -> System.out.println("Subscriber 2: onNext -> " + s + " Thread name: " + Thread.currentThread().getName()),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
	}
}