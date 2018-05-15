package com.prestashop.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBaseClass {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void setp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Selenium\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(Configuration.getProperty("url"));
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
