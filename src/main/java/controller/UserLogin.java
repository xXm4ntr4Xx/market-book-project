package controller;

import dao.UserInterfaceDAO;
import factories.UserFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import services.UserServiceInterface;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
    }

    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        var email = request.getParameter("email");
        var password = request.getParameter("password");
        //factory pattern
        UserInterfaceDAO dao = UserFactory.getUserQueryDAO();
        UserServiceInterface usi = UserFactory.getUserServiceImplementation(dao);
        var status = usi.loginUser(email, password);

        System.out.println("here  " + status);
        if (status.equals("success")) {
         RequestDispatcher view = null;
         request.setAttribute("res", email);
         HttpSession session = request.getSession(true);
         session.setAttribute("email", email);
       	 view = request.getRequestDispatcher("index.jsp");
       	 view.include(request, response);	
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("Fail.jsp");
        }
    }
}

