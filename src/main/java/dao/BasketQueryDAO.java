package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Book;
import model.User;
import utilities.SingletonConnection;

public class BasketQueryDAO implements BasketInterfaceDAO{
	private Connection con;
 private PreparedStatement pst;
 private ResultSet res;
 
 private User user;
 
 
 
	public ArrayList<Book> searchBooksAndInsertOnBasket(String id){
		con = SingletonConnection.getConnection();
		ArrayList<Book> list = new ArrayList<>();
	
		 
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
	String query2="INSERT INTO basket(bookTitle,bookAuthor,bookYear,bookCost) VALUES (?,?,?,?)";
		try {
			pst= con.prepareStatement(query2);
			
			pst.setString(1,list.get(0).getBookTitle());
			pst.setString(2,list.get(0).getBookAuthor());
			pst.setInt(3,list.get(0).getBookYear());
			pst.setDouble(4,list.get(0).getBookCost());
			
			int value = pst.executeUpdate();
			System.out.println(value);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public ArrayList<Book> searchBooksAndDeleteFromBasket(String num) {
		
				return null;
	}
//show total amount of basket
	@Override
	public String showTotalCost() {
		return null;
	}


@Override
public ArrayList<Book> showBookOnBasket() {
	System.out.println();
	return null;
}


	
}
