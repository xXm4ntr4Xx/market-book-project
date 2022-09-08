//package utilities;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class BookConnection {
//
//	private BookConnection() {}
//	
//	private static Connection con;
//	
//	public static Connection getBookConnection() {
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		return con;
//		
//	}}
