package dao;

import java.util.ArrayList;


import model.Book;

public interface BasketInterfaceDAO{

	ArrayList<Book> showBookOnBasket(String email);
	ArrayList<Book> searchBooksAndInsertOnBasket(String id,String email);
	ArrayList<Book> searchBooksAndDeleteFromBasket(String id, String email);
	
}
