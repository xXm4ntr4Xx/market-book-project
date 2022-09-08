package services;

import java.util.ArrayList;

import model.Book;

public interface BookServiceInterface {
	public ArrayList<Book> showBooks();
	public ArrayList<Book> searchBooks(String num);
	
}
