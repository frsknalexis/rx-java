package com.dev.reactive.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStream {

	public static void main(String...strings) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
		books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
		books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
		books.add(new Book("House of Levels", "Mark Z. Danielewski", "Horror", 4.10908908));
		
		OptionalDouble average = books.stream()
									.mapToDouble(Book::getRating)
									.average();
		
		System.out.println(average.getAsDouble());
		
		IntStream intStream = IntStream.of(1, 3, 5, 8);
		DoubleStream doubleStream = DoubleStream.of(1, 3, 5, 8);
		LongStream longStream = LongStream.of(1L, 3L, 5L, 8L);
		
		Stream<Integer> boxedIntegerStream = intStream.boxed();
		
		doubleStream.mapToObj(val -> val);
	}
}
