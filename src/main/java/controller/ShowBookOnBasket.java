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

/**
 * Servlet implementation class ShowBookOnBasket
 */
@WebServlet("/ShowBookOnBasket")
public class ShowBookOnBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBookOnBasket() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		var emailSession = (String) session.getAttribute("email");
		
		BasketInterfaceDAO bi = BasketFactory.getBasketQueryDAO();
		BasketServiceInterface bsi = BasketFactory.getBasketServiceIMplementation(bi);
		List<Book> basket = bsi.showBookOnBasket(emailSession);
		
		
		
		RequestDispatcher view = null;
  request.setAttribute("basket",basket);
  
  view = request.getRequestDispatcher("Basket.jsp");
  view.include(request, response); 
	}
}
