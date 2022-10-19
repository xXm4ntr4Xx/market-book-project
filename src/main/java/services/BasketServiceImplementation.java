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
	public ArrayList<Book> searchBooksAndInsertOnBasket(String id) {
		// TODO Auto-generated method stub
		return basketDao.searchBooksAndInsertOnBasket(id);
	}

	

	@Override
	public ArrayList<Book> searchBooksAndDeleteFromBasket(String id) {
		// TODO Auto-generated method stub
		return this.basketDao.searchBooksAndDeleteFromBasket(id);
	}

	@Override
	public String showTotalCost() {
		// TODO Auto-generated method stub
		return this.basketDao.showTotalCost();
	}

	@Override
	public ArrayList<Book> showBookOnBasket() {
		// TODO Auto-generated method stub
		return basketDao.showBookOnBasket();
	}

	
}
