package com.dev.reactive.app.observable;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class CreatingObservable {

	private static final Logger logger = LoggerFactory.getLogger(CreatingObservable.class);
	
	public static void main(String...strings) {
		// create observable
		logger.info("create Method");
		
		Observable<Integer> source = Observable.create(e -> {
			e.onNext(10);
			e.onNext(11);
			e.onNext(12);
			e.onComplete();
		});
		
		source.subscribe((i) -> logger.info("onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		// just
		logger.info("just Method");
		
		Observable<Integer> just = Observable.just(1, 2, 3);
		just.subscribe((i) -> logger.info("onNext -> {}", i));
		
		logger.info("fromIterable Method");
		
		//fromIterable
		List<String> list = List.of("Ram", "Shyam", "Mike");
		@NonNull
		Observable<String> fromIterable = Observable.fromIterable(list);
		
		fromIterable.subscribe((s) -> logger.info("onNext -> {}", s));
		
		// defer
		logger.info("defer Method");
		
		List<String> listString = new ArrayList<String>();
		listString.add("Ram");
		listString.add("Mike");
		
		Observable<String> observableDefer = Observable.defer(() -> Observable.fromIterable(listString));
		
		observableDefer.subscribe(s -> logger.info("onNext -> {}", s));
		
		listString.add("Paul");
		observableDefer.subscribe(s -> logger.info("onNext -> {}", s));
	}
}
