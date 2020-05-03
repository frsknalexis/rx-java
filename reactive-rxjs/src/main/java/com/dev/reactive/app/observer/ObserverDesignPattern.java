package com.dev.reactive.app.observer;

public class ObserverDesignPattern {

	public static void main(String...strings) {
		Book book = new Book("Goosebumps", "Horror", "Xyz", 200, "SoldOut");
		EndUser endUser = new EndUser("Bob", book);
		EndUser endUser1 = new EndUser("Rob", book);
		
		System.out.println(book.getInStock());
		
		book.setInStock("In Stock");
	}
}
