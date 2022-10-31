package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.User;

class UserTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("check the user name")
	void checkUser() {
		User u1 = new User("Sam","Bil","s@gmail.com","456374");
		String expectedResult = "Sam";
		String actual = u1.getUsername();
		Assert.assertEquals(expectedResult,actual);
	}
	
	@Test
	@DisplayName("check user password")
	void checkPassword() {
		User u1 = new User("Tom","Sotw","t@gmail.com","936647");
		String expectedResult = "936647";
		String actual = u1.getUserPassword();
		Assert.assertEquals(expectedResult,actual);
	}
}
