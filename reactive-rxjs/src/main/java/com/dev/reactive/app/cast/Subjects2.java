package com.dev.reactive.app.cast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Subjects2 {

	private static final Logger logger = LoggerFactory.getLogger(Subjects2.class);
	
	public static void main(String...strings) {
		@NonNull
		PublishSubject<Object> subject = PublishSubject.create();
		@NonNull
		Subject<Object> serialized = subject.toSerialized();
		
		serialized.subscribe(System.out::println);
		serialized.subscribe(e -> logger.info("Observer 2 -> {} ", e));
		
		serialized.onNext("Hello");
		serialized.onNext("RxJava");
		serialized.onComplete();
		serialized.onNext("RxJava");
	}
}
