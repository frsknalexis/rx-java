package com.dev.reactive.app.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class ConnectableObservable {

	private static final Logger logger = LoggerFactory.getLogger(ConnectableObservable.class);
	
	public static void main(String...strings) throws InterruptedException {
		io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<@NonNull Long> source = Observable.interval(1, TimeUnit.SECONDS)
						.publish();
		
		source.connect();
		logger.info("subscriber 1");
		source.subscribe((i) -> logger.info("onNext -> {}", i));
		
		Thread.sleep(10000);
		
		logger.info("subscriber 2");
		source.subscribe((i) -> logger.info("onNext -> {}", i));
		
		Thread.sleep(10000);
	}
}
