package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Sing in")
	public WebElement signInLink;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	public WebElement logo;
	
	public boolean isAt() {
		return driver.getTitle().equals("My Store");
		
	}
	
	public void gotoLoginPage() {
		signInLink.click();
	}
	

}
