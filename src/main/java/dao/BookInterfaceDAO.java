package dao;


import java.util.ArrayList;
import model.Book;


public interface BookInterfaceDAO {	
	 ArrayList<Book> showBooks();
  ArrayList<Book> searchBooks(String num);
	
}
