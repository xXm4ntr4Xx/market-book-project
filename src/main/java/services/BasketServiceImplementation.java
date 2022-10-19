package services;

import java.util.ArrayList;

import dao.BasketInterfaceDAO;
import model.Book;

public class BasketServiceImplementation implements BasketServiceInterface {
BasketInterfaceDAO basketDao;
	
	public BasketServiceImplementation(BasketInterfaceDAO basketDao) {
	super();
	this.basketDao = basketDao;
}

	@Override
	public ArrayList<Book> searchBooksAndInsertOnBasket(String id,String email) {
		// TODO Auto-generated method stub
		return basketDao.searchBooksAndInsertOnBasket(id,email);
	}

	

	@Override
	public ArrayList<Book> searchBooksAndDeleteFromBasket(String id,String email) {
		// TODO Auto-generated method stub
		return this.basketDao.searchBooksAndDeleteFromBasket(id,email);
	}

	
	@Override
	public ArrayList<Book> showBookOnBasket(String email) {
		// TODO Auto-generated method stub
		return basketDao.showBookOnBasket(email);
	}

	
}
