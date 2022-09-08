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
 
 
 
 private ArrayList<Book> basket = new ArrayList<Book>();
 private ArrayList<Book> list = new ArrayList<Book>();
 
 
 public ArrayList<Book> showBookOnBasket(){
		con = SingletonConnection.getConnection();
		var query = "SELECT * FROM basket";
		

		try {
		 pst= con.prepareStatement(query);
		 res = pst.executeQuery();
		while(res.next()) {
		 Book book = new Book();
		 book.setBookId(res.getInt("id"));
		 book.setBookTitle(res.getString("title"));
		 book.setBookCost(res.getDouble("cost"));
		 basket.add(book);	
		 
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
		System.out.println(basket);
		return basket; 
	}
 
	public ArrayList<Book> searchBooksAndInsertOnBasket(String id){
		con = SingletonConnection.getConnection();
		String query = "SELECT * FROM book WHERE id = ?" ;
						
		try {
		 pst= con.prepareStatement(query);
		 pst.setString(1, id);
		 res = pst.executeQuery();
					
		while(res.next()) {
		 Book book = new Book();
		 book.setBookId(res.getInt("id"));
		 book.setBookTitle(res.getString("title"));
		 book.setBookAuthor(res.getString("author"));
		 book.setBookYear(res.getInt("year"));
		 book.setBookCost(res.getDouble("cost"));				
		 list.add(book);	
		 //add to basket 
		 String insertQuery = "INSERT INTO basket (title,cost) VALUES (?,?)";
		 
		 pst= con.prepareStatement(insertQuery);
		 pst.setString(1, book.getBookTitle());
		 pst.setDouble(2, book.getBookCost());
		 pst.executeUpdate();
		 basket.add(book);
			}		
		    } catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					res.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println(list);
				return basket;	
	};
	
	

	@Override
	public ArrayList<Book> searchBooksAndDeleteFromBasket(String num) {
		con = SingletonConnection.getConnection();
		var query = "SELECT * FROM basket WHERE id = ?" ;
				
		
		basket = new ArrayList<Book>();
				
		try {
		 pst= con.prepareStatement(query);
		 pst.setString(1, num);
		 res = pst.executeQuery();
					
		while(res.next()) {
		 Book book = new Book();
		 book.setBookId(res.getInt("id"));
		 book.setBookTitle(res.getString("title"));
		 book.setBookCost(res.getDouble("cost"));				
		 basket.add(book);	
		 
		 //add to basket 
		 var insertQuery = "DELETE FROM basket WHERE id = ?" ;
		 
		 pst= con.prepareStatement(insertQuery);
		 pst.setString(1, num);;
		 
		 pst.executeUpdate();
		 basket.remove(book);
			}
		    } catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					res.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return basket;
	}
//show total amount of basket
	@Override
	public String showTotalCost() {
		String sum =null;
	
		con = SingletonConnection.getConnection();
		var query = "SELECT SUM(cost)as sumprice FROM basket";
		
		
		try {
			pst= con.prepareStatement(query);
		 res = pst.executeQuery();
		 if(res.next()){
	    sum = res.getString("sumprice");
		 }
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			res.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	
	
}
