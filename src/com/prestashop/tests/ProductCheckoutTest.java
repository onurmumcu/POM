package com.prestashop.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ProductPage;
import com.prestashop.utilities.Configuration;

public class ProductCheckoutTest {
	WebDriver driver;
	String productName ="Printed Summer Dress";
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				Configuration.getProperty("driverpath"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(Configuration.getProperty("url"));
	}
	
	/*
	 *  open the prestashop 
	 *  click on product Printed Summer Dress on the home page
	 *  verify the product name is Printed Summer Dress
	 */
	
	@Test (priority = 0)
	public void productListing(){
		HomePage homePage = new HomePage(driver);
		homePage.listing(productName).click();
		ProductPage productPage = new ProductPage(driver);
		assertEquals(productPage.name.getText(), productName);
		
	}
	
	
	/*
	 *  open the product details page, add a product to the cart
	 *  verify that confirmation message is displayed
	 */
	
	@Test (priority = 1, dependsOnMethods = "productListing", enabled = true)
	public void checkoutTest(){
		ProductPage productPage = new ProductPage(driver);
		productPage.addToCart.click();
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(productPage.confirmation));

		assertTrue(productPage.confirmation.isDisplayed(), 
				" Confirmation message was not displayed");
		String confirmation = "Product successfully added to your shopping cart";
		assertEquals(productPage.confirmation.getText().trim(), confirmation);
		
		
	}
	
}