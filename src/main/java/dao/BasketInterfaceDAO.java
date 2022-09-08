package dao;

import java.util.ArrayList;


import model.Book;

public interface BasketInterfaceDAO {
	public ArrayList<Book> searchBooksAndInsertOnBasket(String num);
	public ArrayList<Book> searchBooksAndDeleteFromBasket(String num);
	public ArrayList<Book> showBookOnBasket();
	public String showTotalCost();
	


}
