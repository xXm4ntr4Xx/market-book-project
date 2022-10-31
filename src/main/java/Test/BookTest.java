package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Book;

class BookTest {

	@BeforeEach
	void alertMessage() {
		System.out.println("Test completed");
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

	//String bookTitle, String bookAuthor, Integer bookYear, Double bookCost
	@Test
	@DisplayName("check book author")
	void checkUser() {
		Book b1 = new Book("The new Book","Steven Lee",2004,33.50);
		String expectedResult = "Steven Lee";
		String actualValue = b1.getBookAuthor();
		Assert.assertEquals(expectedResult,actualValue);
	}
}
