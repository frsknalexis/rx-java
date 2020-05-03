package com.dev.reactive.app.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StatelessStatefulOp {

	public static void main(String...strings) {
		List<Integer> list = List.of(1, 2, 4, 5, 6, 7, 9);
		
		List<Integer> collect = list.parallelStream()
					.skip(2)
					.limit(5)
					.collect(Collectors.toList());
		
		System.out.println(collect);
	}
}
