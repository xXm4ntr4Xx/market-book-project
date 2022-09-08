package controller;

import java.io.IOException;
import java.util.List;

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
	
	
	var id = request.getParameter("id");
	BasketInterfaceDAO bi = BasketFactory.getBasketQueryDAO(); 
	BasketServiceInterface bsi = BasketFactory.getBasketServiceIMplementation(bi);
	List<Book> basket= null ;
	
	RequestDispatcher view = null;
	
	
	HttpSession session = request.getSession(true);
	String emailSession = (String) session.getAttribute("email");
	System.out.println(emailSession);
	basket = bsi.searchBooksAndInsertOnBasket(id);

	
 request.setAttribute("basket",basket);
 view = request.getRequestDispatcher("BookShow?");
 view.include(request, response); 
 response.sendRedirect("BookShow?");
 
	}

}
