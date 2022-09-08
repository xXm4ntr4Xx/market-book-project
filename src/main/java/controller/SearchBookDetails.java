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

/**
 * Servlet implementation class SearchBookDetails
 */
@WebServlet("/SearchBookDetails")
public class SearchBookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

public SearchBookDetails() {
 super();
    }

protected void doGet(
 HttpServletRequest request, 
 HttpServletResponse response) 
throws ServletException, IOException {
	var num = request.getParameter("bookDetailsId");
	BookInterfaceDAO dao = BookFactory.getBookQueryDAO();
 BookServiceInterface bsi = BookFactory.getBookServiceImplemantation(dao);
 List<Book> list = bsi.searchBooks(num);

 RequestDispatcher view = null;
 request.setAttribute("singleBook", list);
 view = request.getRequestDispatcher("BookDetails.jsp");
 view.include(request, response);
	System.out.println(num);
		}
}
