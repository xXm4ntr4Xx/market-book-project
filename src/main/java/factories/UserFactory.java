package factories;

import dao.UserQueryDAO;
import dao.UserInterfaceDAO;
import model.User;
import services.UserServiceImplemantation;
import services.UserServiceInterface;

public class UserFactory {
	
	public static User getUser(Integer userId,String userName,String userSurname,String userEmail,String userPassword) {
		return new User(userId, userName, userSurname, userEmail, userPassword);
	}
	//Overload
	public static User getUser(String userName,String userSurname,String userEmail,String userPassword) {
		return new User(userName, userSurname, userEmail, userPassword);
	}
	
	public static UserInterfaceDAO getUserQueryDAO() {
		return new UserQueryDAO();
	}
	
	public static UserServiceInterface getUserServiceImplementation(UserInterfaceDAO dao) {
		return  new UserServiceImplemantation(dao);
	}
	
}

//
//UserInterfaceDAO dao = new UserQueryDAO();
//UserServiceInterface usi = new UserServiceImplemantation(dao);