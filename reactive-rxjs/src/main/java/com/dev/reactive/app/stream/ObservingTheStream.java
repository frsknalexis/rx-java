package com.dev.reactive.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObservingTheStream {

	public static void main(String...strings) {
		List<Book> books = new ArrayList<Book>();
		
		// Stream pipeline
		List<Book> popularHorrorBooks = books.stream()
											.filter((b) -> b.getGenre().equalsIgnoreCase("Horror"))
											.filter((b) -> b.getRating() > 3)
											.collect(Collectors.toList());
		
		// create the stream
		Stream<Book> streamBook = books.stream();
		
		// filter
		Stream<Book> horrorBooksStream = streamBook.filter((b) -> b.getGenre().equalsIgnoreCase("Horror"));
		
		// filter
		Stream<Book> popularHorrorBooksStream = horrorBooksStream.filter((b) -> b.getRating() > 3);
		
		// collect into a list
		List<Book> collectBooks = popularHorrorBooksStream.collect(Collectors.toList());
	}
}
