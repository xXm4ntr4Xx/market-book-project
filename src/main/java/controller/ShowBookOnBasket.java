package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		BasketInterfaceDAO bi = BasketFactory.getBasketQueryDAO();
		BasketServiceInterface bsi = BasketFactory.getBasketServiceIMplementation(bi);
		List<Book> basket = bsi.showBookOnBasket();
		
		String basketTotal = bsi.showTotalCost();
		if(basketTotal==null)basketTotal="0";
		
		RequestDispatcher view = null;
  request.setAttribute("basket", basket);
  request.setAttribute("basketTotal", basketTotal);
  view = request.getRequestDispatcher("Basket.jsp");
  view.include(request, response); 
	}
}
