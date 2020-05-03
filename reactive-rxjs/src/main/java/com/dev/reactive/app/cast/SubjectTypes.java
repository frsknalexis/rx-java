package com.dev.reactive.app.cast;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class SubjectTypes {

	private static final Logger logger = LoggerFactory.getLogger(SubjectTypes.class);
	
	public static void main(String...strings) throws InterruptedException {
		
		logger.info("PublishSubject Operator");
		
		Subject<String> subject = PublishSubject.create();
		
		subject.subscribe((e) -> logger.info("Subscriber 1 -> {}", e));
		
		subject.onNext("a");
		subject.onNext("b");
		subject.onNext("c");
		
		subject.subscribe((e) -> logger.info("Subscriber 2 -> {}", e));
		
		subject.onNext("d");
		subject.onNext("e");
		subject.onComplete();
		
		logger.info("ReplaySubject Operator");
		
		Subject<String> subject2 = ReplaySubject.create();
		
		subject2.subscribe((e) -> logger.info("Subscriber 1 -> {}", e));
		
		subject2.onNext("a");
		subject2.onNext("b");
		subject2.onNext("c");
		
		subject2.subscribe((e) -> logger.info("Subscriber 2 -> {}", e));
		
		subject2.onNext("d");
		subject2.onNext("e");
		subject2.onComplete();
		
		logger.info("BehaviorSubject Operator");
		
		Subject<String> subject3 = BehaviorSubject.create();
		
		subject3.subscribe((e) -> logger.info("Subscriber 1 -> {}", e));
		
		subject3.onNext("a");
		subject3.onNext("b");
		subject3.onNext("c");
		
		subject3.subscribe((e) -> logger.info("Subscriber 2 -> {}", e));
		
		subject3.onNext("d");
		subject3.onNext("e");
		subject3.onComplete();
		
		logger.info("AsyncSubject Operator");
		
		Subject<String> subject4 = AsyncSubject.create();
		
		subject4.subscribe((e) -> logger.info("Subscriber 1 -> {}", e));
		
		subject4.onNext("a");
		subject4.onNext("b");
		subject4.onNext("c");
		
		subject4.subscribe((e) -> logger.info("Subscriber 2 -> {}", e));
		
		subject4.onNext("d");
		subject4.onNext("e");
		subject4.onComplete();
		
		logger.info("UniCastSubject Operator");
		
		Subject<Long> subject5 = UnicastSubject.create();
		
		Observable.interval(1000, TimeUnit.MILLISECONDS)
				.subscribe(subject5);
		
		Thread.sleep(2000);
		
		subject5.subscribe((e) -> logger.info("Subscriber 1 -> {}", e));
		
		Thread.sleep(2000);
		
	}
}