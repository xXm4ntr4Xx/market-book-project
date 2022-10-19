package model;

public class Book {
	private Integer bookId;
	private String bookTitle;
	private String bookAuthor; 	
	private Integer bookYear;
	private Double bookCost;
	
	//Constructor
	
	public Book() {}
	
	public Book(String bookTitle, Double bookCost) {
		super();
		this.bookTitle = bookTitle;
		this.bookCost = bookCost;
	}

	public Book( String bookTitle, String bookAuthor, Integer bookYear, Double bookCost) {
		super();
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookYear = bookYear;
		this.bookCost = bookCost;
	}
	
	public Book(Integer bookId, String bookTitle, String bookAuthor, Integer bookYear, Double bookCost) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookYear = bookYear;
		this.bookCost = bookCost;
	}
	//Getters
	public Integer getBookId() {
		return bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public Integer getBookYear() {
		return bookYear;
	}
	public Double getBookCost() {
		return bookCost;
	}
	//Setters
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public void setBookYear(Integer bookYear) {
		this.bookYear = bookYear;
	}
	public void setBookCost(Double bookCost) {
		this.bookCost = bookCost;
	}
	//ToString
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookYear="
				+ bookYear + ", bookCost=" + bookCost + "]";
	}
	
	
}
