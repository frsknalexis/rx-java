package com.dev.reactive.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SingleUse {

	public static void main(String...strings) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
		books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
		books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
		books.add(new Book("House of Levels", "Mark Z. Danielewski", "Horror", 4.10908908));
			
		List<Book> popularHorrorBooks = books.stream()
											.filter((b) -> b.getGenre().equalsIgnoreCase("Horror"))
											.filter((b) -> b.getRating() > 3)
											.collect(Collectors.toList());
		
		popularHorrorBooks.forEach((b) -> System.out.println(b));
		
		List<Book> popularRomanticBooks = books.stream()
											.filter((b) -> b.getGenre().equalsIgnoreCase("Romance"))
											.filter((b) -> b.getRating() > 3)
											.collect(Collectors.toList());
		
		popularRomanticBooks.forEach(System.out::println);
	}
}
