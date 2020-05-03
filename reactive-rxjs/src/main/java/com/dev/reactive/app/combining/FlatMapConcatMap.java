package com.dev.reactive.app.combining;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;

public class FlatMapConcatMap {

	private static final Logger logger = LoggerFactory.getLogger(FlatMapConcatMap.class);
	
	public static void main(String...strings) {
		logger.info("FlatMap Operator");
		
		List<String> list = List.of("Hello", "Reactive", "Programming");
		
		Observable.fromIterable(list)
				.flatMap(e -> Observable.fromArray(e.split(",")))
				.subscribe((s) -> logger.info("onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("ConcatMap Operator");
		
		Observable.fromIterable(list)
				.concatMap(s -> Observable.fromArray(s.split(",")))
				.subscribe((s) -> logger.info("OnNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}