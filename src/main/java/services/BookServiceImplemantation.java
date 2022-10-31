package services;

import java.util.ArrayList;


import dao.BookInterfaceDAO;
import model.Book;

public class BookServiceImplemantation implements BookServiceInterface {
	BookInterfaceDAO bookDao;
	
	
	public BookServiceImplemantation(BookInterfaceDAO bookDao) {
		super();
		this.bookDao = bookDao;	
	}

	@Override
	public ArrayList<Book> showBooks() {
		// TODO Auto-generated method stub
		return this.bookDao.showBooks();
	}

	@Override
	public ArrayList<Book> searchBooks(String num) {
		// TODO Auto-generated method stub
		return this.bookDao.searchBooks(num);
	}	
}


