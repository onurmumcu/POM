package com.prestashop.tests;


import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prestashop.pages.AccountPage;
import com.prestashop.pages.HomePage;
import com.prestashop.pages.LoginPage;
import com.prestashop.utilities.Configuration;

public class LoginTests {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Selenium\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
		
		
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isAt());
		
		assertTrue(loginPage.createAccountLabel.isDisplayed());
		assertTrue(loginPage.alreadyRegisteredLabel.isDisplayed());
		
		loginPage.login(Configuration.getProperty("email"), 
				        Configuration.getProperty("password"));
		
		
		AccountPage accountPage = new AccountPage(driver);
		assertTrue(accountPage.isAt(), "Account page is not loaded/displayed");
		
		assertTrue(accountPage.verifyUserOptions(
				"ORDER HISTORY AND DETAILS",
				"MY CREDIT SLIPS", 
				"MY ADDRESSES", 
				"MY PERSONAL INFORMATION", 
				"MY WISHLISTS"));
		
		
		
	}
}
