package com.dev.reactive.app.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class BoundedStream {

	public static void main(String...strings) {
		List<Integer> list = List.of(1, 4, 7, 9, 4);
		Stream<Integer> streamIntegers = list.stream();
		
		Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four");
		Stream<Entry<Integer, String>> streamOfEntryes = map.entrySet().stream();
		Stream<String> streamOfValues = map.values().stream();
		Stream<Integer> streamOfKeys = map.keySet().stream();
		
		// 2.
		Stream<String> streamStrings = Stream.of("Hey!", "Hello!", "Happy!", "Thanksgiving");
		
		//3. 
		Integer[] integersArrays = {3, 5, 7, 89, 9};
		Stream<Integer> streamArray = Arrays.stream(integersArrays);
		
		int[] intArrays = {3, 5, 7, 89, 9};
		IntStream streamIntArray = Arrays.stream(intArrays);
		
		// 4.
		Builder<Integer> builder = Stream.builder();
		builder.add(1);
		// code
		
		// conditions
		builder.add(4);
		builder.build();
	}
}
