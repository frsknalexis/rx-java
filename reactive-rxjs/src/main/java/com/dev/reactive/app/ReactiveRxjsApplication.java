package com.dev.reactive.app;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@SpringBootApplication
public class ReactiveRxjsApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(ReactiveRxjsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReactiveRxjsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flowable.just("Hello World")
			.subscribe((e) -> System.out.println(e));
		
		Flowable<Integer> flow = Flowable.range(1, 5)
										.map((i) -> i * i)
										.filter((i) -> i % 3 == 0);
		flow.subscribe(System.out::println);
		
		Observable.just(1, 2, 3)
					.map((i) -> i * 2)			
					.filter((i) -> i > 5)
					.concatWith(Observable.error(() -> new Exception("An exception occurred")))
							
					.subscribe((i) -> System.out.println(i), (e) -> logger.error(e.getMessage()), 
							() -> logger.info("Hemos terminado"));
		
		Observable<String> observable = Observable.just("Hello");
		observable.subscribe(System.out::println);
		
		
		Observable<String> observableString = Observable
												.fromIterable(letters)
												.map(String::toUpperCase);
		
		observableString
					.subscribe((i) -> System.out.println(i), Throwable::printStackTrace,
							() -> logger.info("OnCompleted"));
		
		Observable.just("title1", "title2")
				.flatMap((s) -> getTitle())
				.subscribe((s) -> System.out.println(s));
		
		Observable.fromIterable(letters)
				.scan(new StringBuilder(), StringBuilder::append)
				.subscribe((s) -> System.out.println(s.toString()));
		
		Observable.empty()
				.switchIfEmpty(Observable.just("Observable is empty"))
				.subscribe((s) -> System.out.println(s));
		
		
		String[] result = { "" };
		
		Single<String> single = Single.just("Hello")
								.doOnSuccess(i -> result[0] += i)
								.doOnError((e) -> new RuntimeException(e.getMessage()));
		single.subscribe(System.out::println);
		
		rxJava2();
	}
	
	List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
	
	Observable<String> getTitle() {
		return Observable.fromIterable(letters);
	}
	
	public static void rxJava2() {
		Observable<String> observable = Observable.just("how", "to", "do", "in", "java");
		observable.subscribe(System.out::println);
	}
	
}