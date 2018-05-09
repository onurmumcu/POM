package tests;


import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.Configuration;

public class LoginTests {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				Configuration.getProperty("windriverpath"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(Configuration.getProperty("url"));
		
	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}

	@Test
	public void positiveLoginTest() {
		//create object from Page class
		HomePage homePage = new HomePage(driver);
		//verify at page
		assertTrue(homePage.isAt());
		
		//verify logo is displayed
		assertTrue(homePage.logo.isDisplayed());
		
		homePage.gotoLoginPage();
		
	}
}
