package com.dev.reactive.app.stream;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Calculation {

	public static void main(String...strings) {
		//IntStream
		//DoubleStream
		//LongStream
		
		// Sum
		int sum = IntStream.of(1, 2, 3)
				.sum();
		System.out.println(sum);
		
		// Max Optional: primitive
		OptionalInt maxOptional = IntStream.of(1, 2, 3)
				.max();
		System.out.println(maxOptional.getAsInt());
		
		// Min Optional: primitive
		OptionalInt minOptional = IntStream.of(1, 2, 3, 4)
							.min();
		System.out.println(minOptional.getAsInt());
		
		// average OptionalDouble
		OptionalDouble averageOptional = IntStream.of(1, 2, 3, 4)
								.average();
		System.out.println(averageOptional.getAsDouble());
		
		//summaryStatistics
		IntSummaryStatistics summaryStatistics = IntStream.of(1, 2, 34)
														.summaryStatistics();
		System.out.println(summaryStatistics);
	}
}
