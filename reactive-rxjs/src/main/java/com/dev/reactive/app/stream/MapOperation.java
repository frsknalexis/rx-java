package com.dev.reactive.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapOperation {

	public static void main(String...strings) {
		List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
									.map(e -> e * 25)
									.collect(Collectors.toList());
		
		collect.forEach(System.out::println);
		
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
		books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
		books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
		books.add(new Book("House of Levels", "Mark Z. Danielewski", "Horror", 4.10908908));
			
		List<String> popularHorrorBooks = books.stream()
											.filter((b) -> b.getGenre().equalsIgnoreCase("Horror"))
											.filter((b) -> b.getRating() > 3)
											.map(Book::getName)
											.collect(Collectors.toList());
		
		popularHorrorBooks.forEach(System.out::println);
	}
}
