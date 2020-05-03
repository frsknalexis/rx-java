package com.dev.reactive.app.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterOperation {

	public static void main(String...strings) {
		List<Integer> collect = Stream.of(34, 678, 89, 4, 52, 31, 325, 6)
									.filter(e -> e % 2 == 0)
									.collect(Collectors.toList());
		
		collect.forEach(System.out::println);
	}
}
