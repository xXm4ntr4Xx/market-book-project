 package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import utilities.SingletonConnection;


public class UserQueryDAO implements UserInterfaceDAO{

	private Connection con;
	private PreparedStatement pst;
	private ResultSet res;
	
	
	@Override
	public User registerUser(User user) {
		con = SingletonConnection.getConnection();
		var query = "INSERT INTO user (name,surname,email,password) VALUES(?,?,?,?)";

		try {
			pst= con.prepareStatement(query);
			
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getUserSurname());
			pst.setString(3, user.getUserEmail());
			pst.setString(4, user.getUserPassword());
			
			int value = pst.executeUpdate();
			System.out.println(user);
			System.out.println(value);
			
			if(value>0) {
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public String checkUser(String email,String password) {	
			con = SingletonConnection.getConnection();
			String status=null;
			
			var query = "SELECT * FROM user WHERE email =? AND password =?";
//		var query = "UPDATE user SET name=?, surname=?, email=?, password=?  WHERE id = ?";
		try {
			pst = con.prepareStatement(query);
			
			pst.setString(1,email);
			pst.setString(2,password);
			
			res=pst.executeQuery();
			
			if(res.next()) {
				status = "found";
			}else {
				status = "notfound";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(status);
		return status;
//	UPDATE Customers
		//SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
			//	WHERE CustomerID = 1;
		
	}
	
	@Override
	public String loginUser(String email, String password) {
      String loginStatus=null;
		
      con = SingletonConnection.getConnection();
		var query = "SELECT * FROM user WHERE email =? AND password =?";
		try {
			pst = con.prepareStatement(query);
			//replace the ? with email and password details
			pst.setString(1, email);
			pst.setString(2, password);
			
			res=pst.executeQuery();
			
			if(res.next()) {
				loginStatus = "success";
			}else {
				loginStatus = "failure";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		
		return loginStatus;

	}

	@Override
	public String updateUser(
			String email, String password, 
			String newName, String newSurname,
			String newEmail,String newPassword) {
		String updateStatus=null;
		con = SingletonConnection.getConnection();

				var query ="UPDATE user SET name =?,surname =?,email =?,password =? WHERE email =?";
				try {
					pst = con.prepareStatement(query);
					
					pst.setString(1, newName);
					pst.setString(2, newSurname);
					pst.setString(3, newEmail);
					pst.setString(4, newPassword);
					pst.setString(5, email);
//					pst.setString(6, password);
					
					Integer  value =pst.executeUpdate();
					System.out.println(newName);
					System.out.println(newEmail);
					System.out.println(newPassword);
					
					System.out.println(email);
					System.out.println(password);
					
				System.out.println(value);
				
				if(value ==1) {
				updateStatus = "success";
				}else {
					updateStatus = "failure";
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		return updateStatus;
	}
}
