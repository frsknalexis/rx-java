package com.dev.reactive.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntroduccion {

	public static void main(String...strings) {
		
		List<Book> books = new ArrayList<Book>();
		
		List<Book> popularHorrorBooks = books.stream().parallel()
											.filter((b) -> {
												return b.getGenre().equalsIgnoreCase("Horror");
											})
											.filter((b) -> {
												return b.getRating() > 3;
											})
											.collect(Collectors.toList());
	}
}
