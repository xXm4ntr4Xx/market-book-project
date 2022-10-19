package services;

import java.util.ArrayList;

import model.Book;

public interface BasketServiceInterface {
	public ArrayList<Book> searchBooksAndInsertOnBasket(String id,String email);
	public ArrayList<Book> searchBooksAndDeleteFromBasket(String id,String email);
	public ArrayList<Book> showBookOnBasket(String email);
}
