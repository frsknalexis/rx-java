package com.dev.reactive.app.backpressure;

import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BackPressure {

	private static final Logger logger = LoggerFactory.getLogger(BackPressure.class);
	
	public static void main(String...strings) throws InterruptedException {
		Flowable.range(1, 1000000)
				.map((e) -> {
					logger.info("Produced item is -> {}", e);
					logger.info("Current Thread -> {}", Thread.currentThread().getName());
					return e;
				})
				.observeOn(Schedulers.io())
				.subscribe(new Subscriber<Integer>() {

					private Subscription s;
					private AtomicInteger count = new AtomicInteger(0);
					
					@Override
					public void onSubscribe(Subscription s) {
						logger.info("onComplete");
						this.s = s;
						s.request(20);
					}

					@Override
					public void onNext(Integer t) {
						logger.info("onNext -> {}", t);
						if (count.incrementAndGet() % 20 == 0) {
							logger.info("Asking for the next 20 items");
							s.request(20);
						}
						
						try {
							sleep(400);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					@Override
					public void onError(Throwable t) {
						logger.info("onError -> {}", t.getMessage());
					}

					@Override
					public void onComplete() {
						logger.info("onComplete");
					}
				});
		
		sleep(100000000);
	}
	
	public static void sleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}
}