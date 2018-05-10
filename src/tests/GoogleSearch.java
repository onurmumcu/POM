package tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.GoogleHomePage;
import pages.SearchResultsPage;



public class GoogleSearch {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Selenium/Documents/selenium dependencies/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://google.com");
	}
	
	@Test
	public void googleSearch() {
		GoogleHomePage googleHomePage = new GoogleHomePage(driver);
		assertTrue(googleHomePage.isAt());
		googleHomePage.searchFor("Java Programming");
		
		SearchResultsPage resultPage = new SearchResultsPage(driver);
		assertTrue(driver.getTitle().startsWith("Java Programming"));
		assertTrue(resultPage.resultStats.isDisplayed());
			
		
	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
	
	

}
