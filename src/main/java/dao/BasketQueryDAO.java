package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Book;
import utilities.SingletonConnection;

public class BasketQueryDAO implements BasketInterfaceDAO{
	private Connection con;
 private PreparedStatement pst;
 private ResultSet res;
 
 
 ArrayList<Book> list = new ArrayList<>();
 
	public ArrayList<Book> searchBooksAndInsertOnBasket(String id,String email){
		con = SingletonConnection.getConnection();
		
		String query = "SELECT * FROM book WHERE id = ?";
		
		try {
		 pst= con.prepareStatement(query);
		 pst.setString(1, id);
		 res = pst.executeQuery();
					
		while(res.next()){
			Book book = new Book();
		 book.setBookId(res.getInt("id"));
		 book.setBookTitle(res.getString("title"));
		 book.setBookAuthor(res.getString("author"));
		 book.setBookYear(res.getInt("year"));
		 book.setBookCost(res.getDouble("cost"));		
		 list.add(book);
	}
		
		}catch (Exception e) {
e.printStackTrace();		
}
////basket database test // new implementation neededed
	String query2="INSERT INTO basket(bookTitle,bookAuthor,bookYear,bookCost,userEmail) VALUES (?,?,?,?,?)";
		try {
			pst= con.prepareStatement(query2);
			
			pst.setString(1,list.get(0).getBookTitle());
			pst.setString(2,list.get(0).getBookAuthor());
			pst.setInt(3,list.get(0).getBookYear());
			pst.setDouble(4,list.get(0).getBookCost());
			pst.setString(5,email);
			
		 pst.executeUpdate();
			System.out.println(email+"insert");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public ArrayList<Book> searchBooksAndDeleteFromBasket(String id,String email) {
		con = SingletonConnection.getConnection();
		
		String query = "SELECT * FROM basket WHERE userEmail = ?";
		
		try {
		 pst= con.prepareStatement(query);
		 pst.setString(1, email);
		 res = pst.executeQuery();
					
		while(res.next()){
			Book book = new Book();
		 book.setBookId(res.getInt("id"));
		 book.setBookTitle(res.getString("bookTitle"));
		 book.setBookAuthor(res.getString("bookAuthor"));
		 book.setBookYear(res.getInt("bookYear"));
		 book.setBookCost(res.getDouble("bookCost"));	
		 book.setUserEmail(email);
		 list.add(book);
	}
		
		}catch (Exception e) {
	e.printStackTrace();		
	}
		
		String query3 = "DELETE FROM basket WHERE id = ?";
			try {
				pst= con.prepareStatement(query3);
				pst.setString(1, id);
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				return list;
	}
//show total amount of basket
	

@Override
public ArrayList<Book> showBookOnBasket(String email) {
	con = SingletonConnection.getConnection();
	String query = "SELECT * FROM basket WHERE userEmail = ?";
	
	try {
	 pst= con.prepareStatement(query);
	 pst.setString(1, email);
	 res = pst.executeQuery();
				
	while(res.next()){
		Book book = new Book();
	 book.setBookId(res.getInt("id"));
	 book.setBookTitle(res.getString("bookTitle"));
	 book.setBookAuthor(res.getString("bookAuthor"));
	 book.setBookYear(res.getInt("bookYear"));
	 book.setBookCost(res.getDouble("bookCost"));	
	 book.setUserEmail(email);
	 list.add(book);
}
	
	}catch (Exception e) {
e.printStackTrace();		
}
	System.out.println(list);
	return list;
}


	
}
