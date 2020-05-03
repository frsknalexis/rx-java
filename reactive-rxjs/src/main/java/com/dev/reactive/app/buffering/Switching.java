package com.dev.reactive.app.buffering;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;

public class Switching {

	private static final Logger logger = LoggerFactory.getLogger(Switching.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable<String> source = Observable.just("John", "Lily", "Emma", "Reyan", "Darshin")
											.concatMap(s -> {
												return Observable.just(s)
												.delay(ThreadLocalRandom.current().nextInt(1000), TimeUnit.MILLISECONDS);
											});
		
		Observable.interval(2, TimeUnit.SECONDS)
				.switchMap(s -> source.doOnDispose(() -> logger.info("Disposing and starting again")))
				.subscribe((l) -> logger.info("onNext -> {}", l));
		
		Thread.sleep(10000);
	}
}
