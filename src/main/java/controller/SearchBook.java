package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookInterfaceDAO;
import factories.BookFactory;
import model.Book;
import services.BookServiceInterface;




@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchBook() {
        super();
       
    }

	
	protected void doPost(
		HttpServletRequest request, 
		HttpServletResponse response) 
	throws ServletException, IOException {
		var num = request.getParameter("id");
		BookInterfaceDAO dao = BookFactory.getBookQueryDAO();
  BookServiceInterface bsi = BookFactory.getBookServiceImplemantation(dao);
  List<Book> list = bsi.searchBooks(num);

  RequestDispatcher view = null;
  request.setAttribute("res", list);
	 view = request.getRequestDispatcher("SearchBook.jsp");
	 view.include(request, response);	
	}
}
