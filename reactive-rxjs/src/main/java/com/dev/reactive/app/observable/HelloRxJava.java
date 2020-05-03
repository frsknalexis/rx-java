package com.dev.reactive.app.observable;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

	public static void main(String...strings) {
		Observable<String> source = Observable.create(e -> {
			e.onNext("Hello");
			e.onNext("RxJava");
		});
		
		source.subscribe(System.out::println);
		source.subscribe((e) -> System.out.println("Observer 2: " + e));
	}
}
