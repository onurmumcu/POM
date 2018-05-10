package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
	private WebDriver driver;
	
	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	private WebElement searchField;
	
	public boolean isAt() {
		return driver.getTitle().equals("Google");
	}
	
	public void searchFor(String item) {
		searchField.sendKeys(item + Keys.ENTER);
	}

}
