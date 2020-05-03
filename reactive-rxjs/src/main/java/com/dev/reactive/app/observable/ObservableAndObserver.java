package com.dev.reactive.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableAndObserver {

	private static final Logger logger = LoggerFactory.getLogger(ObservableAndObserver.class);
	
	public static void main(String...strings) {
		Observable<Integer> source = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>() {
			@Override
			public void subscribe(@NonNull ObservableEmitter<@NonNull Integer> emitter) throws Throwable {
				try {
					emitter.onNext(10);
					emitter.onNext(11);
					emitter.onComplete();
				} catch(Throwable t) {
					emitter.onError(t);
				}
			}
		});
		
		Observer<Integer> observer = new Observer<Integer>() {
			
			@Override
			public void onSubscribe(@NonNull Disposable d) {
				logger.info("onSubscribe");
			}
			
			@Override
			public void onNext(@NonNull Integer t) {
				logger.info("onNext -> {}", t);
			}
			
			@Override
			public void onError(@NonNull Throwable e) {
				logger.info("onError -> {}", e.getMessage());
			}
			
			@Override
			public void onComplete() {
				logger.info("onComplete");
			}
		};
		
		source.subscribe(observer);
	}
}