package com.amazonaws.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AwsCalculatorPage {
	private WebDriver driver;
	
	public AwsCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean isAt() {
		return driver.getTitle().equals("Amazon Web Services Simple Monthly Calculator");
		
	}
	
	@FindBy(className="billLabel")
	public WebElement billLabel;
	
	@FindBy(xpath="(//*[@class='gwt-PushButton small gwt-PushButton-up'])[1]/img" )
	public WebElement addEc2;
	
	
	
	

}
