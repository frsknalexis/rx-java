package com.dev.reactive.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Laziness {

	public static void main(String...strings) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
		books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
		books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
		books.add(new Book("House of Levels", "Mark Z. Danielewski", "Horror", 4.10908908));
		
		Stream<Book> stream = books.stream()
								.filter((b) -> b.getGenre().equalsIgnoreCase("Horror"))
								.peek(b -> System.out.println("Filtered Book: " + b))
								.filter((b) -> b.getRating() > 3);
		
		System.out.println("Filtering Done !");
		collect(stream);
	}
	
	public static void collect(Stream<Book> stream) {
		List<Book> popularHorrorBooks = stream.collect(Collectors.toList());
		System.out.println("Collection Done !");
		popularHorrorBooks.forEach(System.out::println);
	}
}
