package services;

import model.User;

public interface UserServiceInterface {
	public User registerUser(User user);
	public String loginUser(String email,String password);
	public String checkUser(String email,String password);
	public String updateUser(String email, String password, String newName, String newSurname, String newEmail,
	  String newPassword);
}
