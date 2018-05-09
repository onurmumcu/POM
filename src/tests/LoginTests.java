package tests;


import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.LoginPage;
import utilities.Configuration;

public class LoginTests {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",
				Configuration.getProperty("winfirefoxdriverpath"));
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(Configuration.getProperty("url"));
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void positiveLoginTest() {
		//create object from Page class
		HomePage homePage = new HomePage(driver);
		//verify at page
		assertTrue(homePage.isAt());
		
		//verify logo is displayed
		assertTrue(homePage.logo.isDisplayed());
		
		
		homePage.gotoLoginPage();
		
		
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isAt());
		
		assertTrue(loginPage.createAccountLabel.isDisplayed());
		assertTrue(loginPage.alreadyRegisteredLabel.isDisplayed());
		
		loginPage.login(Configuration.getProperty("email"), Configuration.getProperty("password"));
		
		
	}
}
