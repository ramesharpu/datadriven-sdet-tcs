package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common {
	private WebDriver driver;
	
	public void setupBrowser(String browser, String url) {
		//browser invocation
		if(browser.equals("chrome"))
			this.driver = new ChromeDriver();
		else if(browser.equals("firefox"))
			this.driver = new FirefoxDriver();
		else if(browser.equals("edge"))
			this.driver = new EdgeDriver();
		else {
			System.out.println("valid browser was not provided, hence quitting the automation run");
			System.exit(0);
		}
		
		//url
		if(!url.isBlank())
			this.driver.get(url);
		else
			this.driver.get("about blank");
		
	}
	
	public WebDriver getBrowser() {
		return this.driver;
	}
	
	public void closeTab() {
		this.driver.close();
	}
	
	public void quitBrowser() {
		this.driver.quit();
	}

}
