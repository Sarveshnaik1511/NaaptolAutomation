package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.NaaptolHomePage;

@Listeners(test.Listeners.class)


public class ProductSearchTest extends BaseTest {

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@AfterMethod
	public void closeApplication() {
		driver.close();
	}

	
	@Test
	public void verifyIfUserIsAbleToLaunchNaaptolOnBrowser() {
		// to create reporting
		test = reports.createTest("verifyIfUserIsAbleToLaunchNaaptolOnBrowser");

		// we can declare class name in baseTest globally for objects
		// so we will write object name and constructor in Tests
		naaptolHomePage = new NaaptolHomePage(driver);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.naaptol.com/"));
		Assert.assertTrue(naaptolHomePage.isShoppingCategoriesDisplayed());
	}

	
	@Test
	public void verifyIfUserIsAbleToGoToLoginOrRegesterPopup() {

		test = reports.createTest("verifyIfUserIsAbleToGoToLoginOrRegesterPopup");

		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.clickOnLoginOrRegister();
		Assert.assertTrue(naaptolHomePage.isLoginOrRegisterPopupDisplayed());
		Assert.assertTrue(naaptolHomePage.isLoginOrRegisterTextVisible());
	}
	

	@Test
	public void verifyIfUserIsAbleToGoToTrackOrderPage() {

		test = reports.createTest("verifyIfUserIsAbleToGoToTrackOrderPage");

		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.clickOnTrackOrder();
		Assert.assertTrue(naaptolHomePage.isTrackOrderPageDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("track-order.html"));
	}

	
	@Test
	public void verifyIfUserIsAbleToSearchProduct() {

		test = reports.createTest("verifyIfUserIsAbleToSearchProduct");
		
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("toys");
		naaptolHomePage.clickOnSearch();
		Assert.assertTrue(driver.getTitle().contains("toys"));
		Assert.assertTrue(naaptolHomePage.getNumberofProductDisplayed() > 0);
	}

	
	@Test
	public void verifyIfUserIsAbleToSeeShopingCategories() {

		test = reports.createTest("verifyIfUserIsAbleToSeeShopingCategories");
		
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.viewShoppingCategories(driver);
		Assert.assertTrue(naaptolHomePage.isListItemDisplayed());
	}

}
