package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.AddressPage;
import pom.CartPage;
import pom.LoginPage;
import pom.NaaptolHomePage;
import pom.NaaptolResultPage;
import pom.ProductDetailPage;

@Listeners(test.Listeners.class)


public class LoginOrRegisterTest extends BaseTest {
	
	@Parameters ({"name"})
	@BeforeMethod
	public void openApplication(String name) {
		driver =Browser.launchApplication(name);
	}
	
	@Test
	public void verifyLoginOrRegesterPage() throws EncryptedDocumentException, IOException, InterruptedException {
		// search and click on product
		
		test= reports.createTest("verifyLoginOrRegesterPage");
		
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("Toys");
		naaptolHomePage.clickOnSearch();
		
		naaptolResultPage = new NaaptolResultPage(driver);
		naaptolResultPage.moveToDesiredProduct(driver, 0);
		naaptolResultPage.clickOnQuickView(0);
		
		//put product to cart
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.clickHereToBuy();
		
		// click on checkout to move to login page
		cartPage = new CartPage(driver);
		cartPage.clickOnProceedToCheckout();
		
		loginPage =new LoginPage(driver);
		loginPage.enterMobileNumber("naaptolRegistration", 0, 1);
		loginPage.clickOnContinueButton();
		
		Thread.sleep(60000);
		
		loginPage.clickOnSubmit();
		
		loginPage.selectNameTitle("1");
		loginPage.enterFirstName("naaptolRegistration", 1, 1);
		loginPage.enterLastName("naaptolRegistration", 2, 1);
		loginPage.enterAddress("naaptolRegistration", 3, 1);
		loginPage.enterPinCode("naaptolRegistration", 4, 1);
		
		loginPage.selectState("520");
		loginPage.selectCity("DODAMARG");
		loginPage.enterMobileNumberForRegistration("naaptolRegistration", 0, 1);
		loginPage.clickOnSaveAndProceed();
		
		AddressPage addressPage = new AddressPage(driver);
		Assert.assertTrue(addressPage.getNumberOfAddress()>4);
	}

}
