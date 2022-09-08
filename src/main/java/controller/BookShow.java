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
 * Servlet implementation class BookShow
 */
@WebServlet("/BookShow")
public class BookShow extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    public BookShow() {
        super();
    }

    protected void doGet(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws ServletException, IOException {
    	 BookInterfaceDAO dao = BookFactory.getBookQueryDAO();
      BookServiceInterface bsi = BookFactory.getBookServiceImplemantation(dao);
      List<Book> list = bsi.showBooks();
      System.out.println("checking");
      RequestDispatcher view = null;
      request.setAttribute("res",list);
      
      view = request.getRequestDispatcher("bookList.jsp");
      view.include(request, response);    
  }
}