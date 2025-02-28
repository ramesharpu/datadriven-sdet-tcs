package test;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.Login;

public class LoginValidation extends BaseTest{
	
	@Test
	public void emailFieldPlaceholderValidation() {
		String expectedResult = "Email address or phone number";
		
		Login login = new Login(driver);
		String actualResult = login.getEmailPlaceholder();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the email textbox placeholder,");		
	}
	
	@Test
	public void passwordFieldPlaceholderValidation() {
		String expectedResult = "Password";
		
		Login login = new Login(driver);
		String actualResult = login.getPasswordPlaceholder();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the password textbox placeholder,");		
	}
	
	@Test
	public void loginButtonTextValidation() {
		String expectedResult = "Log in";
		
		Login login = new Login(driver);
		String actualResult = login.getLoginButtonText();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the login button text,");		
	}

	@Parameters({"validUsername", "validPassword"})
	@Test
	public void validUsernameValidPasswordTest(String username, String password) {
		Login login = new Login(driver);
		login.loginWithCredentials(username, password);	
	}
	
	@Parameters({"invalidUsername", "validPassword"})
	@Test
	public void invalidUsernameValidPasswordTest(String username, String password) {
		Login login = new Login(driver);
		login.loginWithCredentials(username, password);	
	}
	
	@Parameters({"validUsername", "invalidPassword"})
	@Test
	public void validUsernameInvalidPasswordTest(String username, String password) {
		Login login = new Login(driver);
		login.loginWithCredentials(username, password);	
	}
	
	@Parameters({"invalidUsername", "invalidPassword"})
	@Test
	public void invalidUsernameInvalidPasswordTest(String username, String password) {
		Login login = new Login(driver);
		login.loginWithCredentials(username, password);	
	}
	
	@Parameters({"validPassword"})
	@Test
	public void blankUsernameValidPasswordTest(String password) {
		String username = "";
		Login login = new Login(driver);
		login.loginWithCredentials(username, password);	
	}
	
	@Parameters({"validUsername"})
	@Test
	public void validUsernameBlankPasswordTest(String username) {
		String password = "";
		Login login = new Login(driver);
		login.loginWithCredentials(username, password);	
	}
	
	@Test
	public void blankUsernameBlankPasswordTest() {
		String username = "";
		String password = "";
		Login login = new Login(driver);
		login.loginWithCredentials(username, password);	
	}
	
	
	
}
