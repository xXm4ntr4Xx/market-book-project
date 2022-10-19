package controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketInterfaceDAO;

import factories.BasketFactory;
import model.Book;
import services.BasketServiceInterface;




@WebServlet("/AddToBasket")
public class AddToBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddToBasket() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response) 
throws ServletException, IOException {
	ArrayList<Book> basket;
	HttpSession session = request.getSession(true);
	var emailSession = (String) session.getAttribute("email");
	
	var id = request.getParameter("id");
	BasketInterfaceDAO bi = BasketFactory.getBasketQueryDAO(); 
	BasketServiceInterface bsi = BasketFactory.getBasketServiceIMplementation(bi);
	

	
	RequestDispatcher view = null;
	
	
	
	if(emailSession==null) {
		//redirect to login if email is null
		response.sendRedirect("http://localhost:8080/market-book/Login.jsp");
		}else {
			basket = bsi.searchBooksAndInsertOnBasket(id,emailSession);	
			
 		request.setAttribute("basket",basket);
 		view = request.getRequestDispatcher("BookShow?");
 		view.include(request, response); 
 		response.sendRedirect("BookShow?");
 
		}
	

	}

}
