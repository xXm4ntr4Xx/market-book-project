package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInterfaceDAO;
import dao.UserQueryDAO;
import services.UserServiceImplemantation;
import services.UserServiceInterface;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }
//target input text on jsp file
//take data passed in the input text
//update the relative user info
    
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException {
		var email= request.getParameter("email");
		var password = request.getParameter("password");
		
		var newName = request.getParameter("newName");
		var newSurname = request.getParameter("newSurname");
		var newEmail = request.getParameter("newEmail");
		var newPassword = request.getParameter("newPassword");
		 
		
		UserInterfaceDAO uDao = new UserQueryDAO();
		UserServiceInterface usi = new UserServiceImplemantation(uDao);
//		var status = usi.checkUser(email,password);

	var status = 	usi.updateUser(email,password,newName,newSurname,newEmail,newPassword);
if(status == "success") {
response.sendRedirect("Success.jsp");
}else {
response.sendRedirect("Fail.jsp");
}
		
	}

}
