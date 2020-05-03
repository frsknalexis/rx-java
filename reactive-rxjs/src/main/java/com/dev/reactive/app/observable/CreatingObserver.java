package com.dev.reactive.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {

	private static final Logger logger = LoggerFactory.getLogger(CreatingObserver.class);
	
	public static void main(String... strings) {
		logger.info("just Method 2");

		Observable<String> justSource = Observable.just("Orange", "Black", "Red");
		justSource
			.subscribe((s) -> logger.info("onNext -> {}", s), 
						(e) -> logger.info("onError -> {}", e.getMessage()),
						() -> logger.info("onComplete"));
	}
}
