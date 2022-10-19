package dao;

import java.util.ArrayList;


import model.Book;

public interface BasketInterfaceDAO{

	ArrayList<Book> showBookOnBasket();
	ArrayList<Book> searchBooksAndInsertOnBasket(String id);
	ArrayList<Book> searchBooksAndDeleteFromBasket(String num);
	String showTotalCost();
	
}
