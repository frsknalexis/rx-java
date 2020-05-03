package com.dev.reactive.app.cast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class Subjects {

	private static final Logger logger = LoggerFactory.getLogger(Subjects.class);
	
	public static void main(String...strings) throws InterruptedException {
		@NonNull
		Observable<Integer> source1 = Observable.just(5, 10, 15, 20)
												.subscribeOn(Schedulers.computation());
		/*
		@NonNull
		Observable<Integer> source2 = Observable.just(50, 100, 150, 200)
												.subscribeOn(Schedulers.computation());
		
		*/
		/*
		source1.subscribe((i) -> logger.info("onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		source2.subscribe((i) -> logger.info("onNext -> {}", i),
				(e) -> logger.info("onError -> {}", e.getMessage()),
				() -> logger.info("onComplete"));
		
		*/
		
		logger.info("Subject as Observable and Observer");
		
		@NonNull
		PublishSubject<Object> subject = PublishSubject.create();
		
		subject.subscribe(e -> System.out.println(e));
		subject.subscribe((e) -> logger.info("The element is -> {}", e));
		
		source1.subscribe(subject);
		//source2.subscribe(subject);
		
		Thread.sleep(9000);

	}
}
