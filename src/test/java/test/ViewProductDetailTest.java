package test;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.NaaptolHomePage;
import pom.NaaptolResultPage;

@Listeners(test.Listeners.class)

public class ViewProductDetailTest extends BaseTest{
	
	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}
	@AfterMethod
	public void closeApplication() {
		driver.close();
	}
	
	@Test
	public void verifyIfUserIsAbleToViewProductdetailsOnQuickView() {
		
		test =reports.createTest("verifyIfUserIsAbleToViewProductdetailsOnQuickView");
		
		// while creating Object, we can declare the className in BaseTest,
		// and here we will give only object name and constructor,
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolResultPage = new NaaptolResultPage(driver);

		naaptolHomePage.enterProductToSearch("toys");
		naaptolHomePage.clickOnSearch();
		
		naaptolResultPage.moveToDesiredProduct(driver, 0);
		String productTitle = naaptolResultPage.getProductTitle(0);
		boolean productPrice = naaptolResultPage.getProductPrice(0);
		
		naaptolResultPage.clickOnQuickView(0);
		String ProductTitleOnQuickView = naaptolResultPage.getProductTitleOnQuickView();
		boolean ProductPriceOnQuickView = naaptolResultPage.getProductPriceOnQuickView();
		Assert.assertEquals(ProductTitleOnQuickView, productTitle);
		Assert.assertEquals(ProductPriceOnQuickView, productPrice);
	
	}
	@Test
	public void verifyIfUserIsAbleToOpenProductOnNewTab() {
		
		test = reports.createTest("verifyIfUserIsAbleToOpenProductOnNewTab");
		
		 naaptolHomePage = new NaaptolHomePage(driver);
		 naaptolResultPage = new NaaptolResultPage(driver);
		
		naaptolHomePage.enterProductToSearch("toys");
		naaptolHomePage.clickOnSearch();
		
		String productTitle =naaptolResultPage.getProductTitle(0);
		boolean productPrice = naaptolResultPage.getProductPrice(0);
		
		naaptolResultPage.clickOnDesiredProduct(0);
		naaptolResultPage.clickOnDesiredProduct(0);
		
//		Set<String> Handles = driver.getWindowHandles();
//		Iterator<String> i=	Handles.iterator();
		
//		while(i.hasNext()) {
//			String handle =i.next();
//			driver.switchTo().window(handle);
//			
//			if(driver.getTitle().contains(productTitle)) {
//				Assert.assertEquals(productTitle, naaptolResultPage.getProductTitleOnNewPage());
//				Assert.assertEquals(productPrice, naaptolResultPage.getProductPriceOnNewPage());
//			}
//		}
		
		// in first switch, selenium focus will be on first page,
		// on second switch, it will get switch to the next page
			//	driver.switchTo().window(i.next());
			//	driver.switchTo().window(i.next());
		
		switchToChildBrowser();
		
		Assert.assertEquals(productTitle, naaptolResultPage.getProductTitleOnNewPage());
		Assert.assertEquals(productPrice, naaptolResultPage.getProductPriceOnNewPage());
		
		
	}

}
