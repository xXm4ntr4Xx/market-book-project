package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Book;

import utilities.SingletonConnection;

public class BookQueryDAO implements BookInterfaceDAO{
 private Connection con;
 private PreparedStatement pst;
 private ResultSet res;
 private ArrayList<Book> list;
	
public ArrayList<Book> showBooks() {
	con = SingletonConnection.getConnection();
 var query = "SELECT * FROM book";
 list = new ArrayList<Book>();
try {
 pst= con.prepareStatement(query);
 res = pst.executeQuery();
while(res.next()) {
 Book book = new Book();
 book.setBookId(res.getInt("id"));
 book.setBookTitle(res.getString("title"));
 book.setBookAuthor(res.getString("author"));
 book.setBookYear(res.getInt("year"));
 book.setBookCost(res.getDouble("cost"));
 list.add(book);	
	}		
} catch (SQLException e) {
			
 e.printStackTrace();
}
try {
 res.close();
 con.close();
} catch (SQLException e) {
			// TODO Auto-generated catch block
 e.printStackTrace();
}
return list;}


public ArrayList<Book> searchBooks(String num) {
	con = SingletonConnection.getConnection();
var query = "SELECT * FROM book WHERE id = ?" ;
		
list = new ArrayList<Book>();
		
try {
 pst= con.prepareStatement(query);
 pst.setString(1, num);
 res = pst.executeQuery();
			
while(res.next()) {
 Book book = new Book();
 book.setBookId(res.getInt("id"));
 book.setBookTitle(res.getString("title"));
 book.setBookAuthor(res.getString("author"));
 book.setBookYear(res.getInt("year"));
 book.setBookCost(res.getDouble("cost"));				
 list.add(book);	
	}
			
    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			res.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}









}

