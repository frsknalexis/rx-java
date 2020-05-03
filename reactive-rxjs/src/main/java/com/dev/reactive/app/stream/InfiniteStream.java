package com.dev.reactive.app.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStream {

	public static void main(String...strings) {
		Stream.iterate(0, (i) -> i + 1);
		
		IntStream.iterate(5, i -> i -1)
				.limit(15)
				.forEach(System.out::println);
		
		Stream.generate(new Random()::nextInt)
			.forEach(System.out::println);
	}
}
