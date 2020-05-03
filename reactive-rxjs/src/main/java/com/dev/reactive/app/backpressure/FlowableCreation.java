package com.dev.reactive.app.backpressure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlowableCreation {

	private static final Logger logger = LoggerFactory.getLogger(FlowableCreation.class);
	
	public static void main(String...strings) throws InterruptedException {
		Flowable.create(emitter -> {
			for (int i = 0; i <= 5000; i++) {
				if (emitter.isCancelled()) {
					return;
				}
				emitter.onNext(i);
			}
			emitter.onComplete();
		}, BackpressureStrategy.BUFFER)
		.observeOn(Schedulers.io())
		.subscribe((e) -> logger.info("onNext -> {}", e));
		
		Thread.sleep(2000);
	}
}
