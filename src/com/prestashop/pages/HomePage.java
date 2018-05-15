package com.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sign in")
	public WebElement signInLink;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	public WebElement logo;
	
	public WebElement search_query;
	
	public boolean isAt() {
		return driver.getTitle().equals("My Store");
	}
	
	public void gotoLoginPage() {
		signInLink.click();
	}
	
	public WebElement listing(String product){		
		return driver.findElement(By.cssSelector(
				"a.product-name[title='"+product+"']"));
	}
	
	
}

