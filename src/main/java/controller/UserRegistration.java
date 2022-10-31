package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInterfaceDAO;
import factories.UserFactory;
import model.User;
import services.UserServiceInterface;

//jenkins job testing
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserRegistration() {
        super();
    }
    @Override
				protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        var name = request.getParameter("name");
        var surname = request.getParameter("surname");
        var email = request.getParameter("email");
        var password = request.getParameter("password");
        //use of factory pattern
        User us = UserFactory.getUser(name, surname, email, password);

        UserInterfaceDAO dao = UserFactory.getUserQueryDAO();

        UserServiceInterface usi = UserFactory.getUserServiceImplementation(dao);

        User registeredUser = usi.registerUser(us);

        if (registeredUser != null) {
            response.sendRedirect("Success.jsp");
        } else {
            response.sendRedirect("Fail.jsp");
        }
    }
}
