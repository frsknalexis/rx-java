package com.dev.reactive.app.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TheFlatMap {

	private static final Logger logger = LoggerFactory.getLogger(TheFlatMap.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.flatMap((e) -> {
					return Observable.just(e)
									.subscribeOn(Schedulers.computation())
									.map(s -> compute(s));
							})
				.subscribe((s) -> logger.info("onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		Thread.sleep(7000);
	}
	
	public static String compute(String element) {
		String s = element + " : printed by : " + Thread.currentThread().getName();
		return s;
	}
}
