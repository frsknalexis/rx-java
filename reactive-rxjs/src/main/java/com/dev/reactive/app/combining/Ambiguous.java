package com.dev.reactive.app.combining;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;

public class Ambiguous {

	private static final Logger logger = LoggerFactory.getLogger(Ambiguous.class);
	
	public static void main(String...strings) throws InterruptedException {
		logger.info("Ambiguous operator");
		Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
											.take(10)
											.map((l) -> "Observer 1: " + l);
		
		Observable<String> source2 = Observable.interval(10, TimeUnit.MILLISECONDS)
											.take(10)
											.map((l) -> "Observer 2: " + l);
		
		Observable.amb(Arrays.asList(source1, source2))
					.subscribe((s) -> logger.info("onNext -> {}", s),
								(e) -> logger.info("onError -> {}", e.getMessage()),
								() -> logger.info("onComplete"));
		
		Thread.sleep(20000);
	}
}
