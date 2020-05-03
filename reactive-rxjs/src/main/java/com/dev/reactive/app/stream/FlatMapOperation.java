package com.dev.reactive.app.stream;

import java.util.stream.Stream;

public class FlatMapOperation {

	public static void main(String...strings) {
		Stream<String> a = Stream.of("Hello", "there!");
		Stream<String> b = Stream.of("Learning", "Java !");
		
		Stream<String> flatMap = Stream.of(a, b)
									.flatMap(e -> e);
		
		flatMap.forEach(System.out::println);
	}
}
