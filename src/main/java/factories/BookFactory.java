package factories;

import dao.BookInterfaceDAO;
import dao.BookQueryDAO;
import services.BookServiceImplemantation;
import services.BookServiceInterface;

public class BookFactory {
	
	public static BookInterfaceDAO getBookQueryDAO() {
		return new BookQueryDAO();
	}
	
	public static BookServiceInterface getBookServiceImplemantation(BookInterfaceDAO dao) {
		return new BookServiceImplemantation(dao);
	}
}

//BookInterfaceDAO dao = new BookQueryDAO();
//BookServiceInterface bsi = new BookServiceImplemantation(dao);