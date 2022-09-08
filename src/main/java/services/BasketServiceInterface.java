package services;

import java.util.ArrayList;

import model.Book;

public interface BasketServiceInterface {
	public ArrayList<Book> searchBooksAndInsertOnBasket(String num);
	public ArrayList<Book> searchBooksAndDeleteFromBasket(String id);
	public ArrayList<Book> showBookOnBasket();
	public String showTotalCost();
}
