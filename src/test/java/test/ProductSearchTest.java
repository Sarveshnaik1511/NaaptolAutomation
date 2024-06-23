package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaaptolHomePage;


public class ProductSearchTest extends BaseTest {

	@BeforeMethod
	public void openApplication() {
		
	driver =	Browser.launchApplication();
	
	}
	
	@AfterMethod
	public void closeApplication() {
		driver.close();
	}
	
	@Test
	public void verifyIfUserIsAbleToLaunchNaaptolOnBrowser() {
		// we can declare class name in baseTest globally for objects
		// so we will write object name and constructor in Tests
		naaptolHomePage =new NaaptolHomePage(driver);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.naaptol.com/"));
		Assert.assertTrue(naaptolHomePage.isShoppingCategoriesDisplayed());
	}
	@Test
	public void verifyIfUserIsAbleToGoToLoginOrRegesterPopup() {
		naaptolHomePage =new NaaptolHomePage(driver);
		naaptolHomePage.clickOnLoginOrRegester();
		Assert.assertTrue(naaptolHomePage.isLoginOrregesterPopupDisplayed());
		Assert.assertTrue(naaptolHomePage.isLoginOrRegesterTextVisible()); 
	}
	
	@Test
	public void verifyIfUserIsAbleToGoToTrackOrderPage() {
		naaptolHomePage =new NaaptolHomePage(driver);
		naaptolHomePage.clickOnTrackOrder();
		Assert.assertTrue(naaptolHomePage.isTrackOrderPageDisplayed());
		
		Assert.assertTrue(driver.getCurrentUrl().contains("track-order.html"));
	}
	@Test
	public void verifyIfUserIsAbleToSearchProduct() {
		naaptolHomePage =new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("toys");
		naaptolHomePage.clickOnSearch();
		Assert.assertTrue(driver.getTitle().contains("toys"));
		Assert.assertTrue(naaptolHomePage.getNumberofProductDisplayed()>0);	
	}
	@Test 
	public void verifyIfUserIsAbleToSeeShopingCategories() {
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.viewShoppingCategories(driver);
		Assert.assertTrue(naaptolHomePage.isListItemDisplayed());
	}
	
}
