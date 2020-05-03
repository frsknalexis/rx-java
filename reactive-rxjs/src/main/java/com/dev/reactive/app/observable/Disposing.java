package com.dev.reactive.app.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Disposing {

	private static final Logger logger = LoggerFactory.getLogger(Disposing.class);
	
	private static final CompositeDisposable disp = new CompositeDisposable();
	
	public static void main(String...strings) throws InterruptedException {
		logger.info("Disposing method");
		
		@NonNull
		Observable<Long> intervalSource = Observable.interval(1, TimeUnit.SECONDS);
		
		@NonNull
		Disposable d1 = intervalSource.subscribe((l) -> logger.info("Observer1 onNext -> {}", l));
		@NonNull
		Disposable d2 = intervalSource.subscribe((l) -> logger.info("Observer2 onNext -> {}", l));
		
		Thread.sleep(5000);
		
		disp.addAll(d1, d2);
		disp.dispose();
		
		Thread.sleep(10000);
	}
}
