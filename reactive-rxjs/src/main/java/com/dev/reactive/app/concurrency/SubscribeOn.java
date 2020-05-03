package com.dev.reactive.app.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {

	private static final Logger logger = LoggerFactory.getLogger(SubscribeOn.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.subscribeOn(Schedulers.computation())
				.map(e -> e.toUpperCase())
				.doOnNext(e -> logger.info("Current Thread -> {}", Thread.currentThread().getName()))
				.observeOn(Schedulers.newThread())
				.filter((s) -> s.startsWith("P"))
				.observeOn(Schedulers.io())
				.subscribe((s) -> print(s));
		
		Thread.sleep(6000);
	}
	
	public static void print(String element) {
		System.out.println(element + " : printed by: " + Thread.currentThread().getName());
	}
}
