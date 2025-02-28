package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Login {
	private WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath = "//h2[@class='_8eso']")
	private WebElement welMsg;
	
	@CacheLookup
	@FindBy(id = "email")
	private WebElement email;
	
	@CacheLookup
	@FindBy(id = "pass")
	private WebElement pass;
	
	@CacheLookup
	@FindBy(tagName = "button")
	private WebElement loginBtn;
	
	@CacheLookup
	@FindBy(partialLinkText = "Forgotten password?")
	private WebElement forgotPasswordLink;
	
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getWelcomeMessage() {
		return welMsg.getText();
	}
	
	public void enterUsername(String username) {
		Reporter.log("username = " + username);
		email.clear();
		email.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		Reporter.log("password = " + password);
		pass.clear();
		pass.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginBtn.click();
	}
	
	public String getEmailPlaceholder() {
		return email.getDomAttribute("placeholder");
	}
	
	public String getPasswordPlaceholder() {
		return pass.getDomAttribute("placeholder");
	}
	
	public String getLoginButtonText() {
		return loginBtn.getText();
	}
	
	public void loginWithCredentials(String username, String password) {
		enterUsername(username);
		enterPassword(password);
//		clickLoginButton();
	}

}
