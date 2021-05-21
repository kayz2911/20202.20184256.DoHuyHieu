package hust.soict.globalict.test.book;

import hust.soict.globalict.aims.media.Book;

public class TestBook {

	public static void main(String[] args) {
		Book book = new Book("Romeo", "001");
		book.setContent("At least 22 people died from loss of oxygen in a hospital accident. Infections hit a daily record. And the government faced criticism for allowing an enormous Hindu festival to continue.");
		book.setWordFrequency();
		System.out.println( book.getWordFrequency() );
		System.out.println();
		System.out.println(book.getContentTokens());
	}

}
