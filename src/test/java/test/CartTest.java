package test;




import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.CartPage;
import pom.NaaptolHomePage;
import pom.NaaptolResultPage;
import pom.ProductDetailPage;

public class CartTest extends BaseTest {

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@AfterMethod
	public void closeApplication() {
		driver.close();
	}

	@Test
	public void verifyAddToCartFromOrderDetailsUsingQuickView() {
		
		// search and add product to cart from QuickView
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("toys");
		naaptolHomePage.clickOnSearch();

		naaptolResultPage = new NaaptolResultPage(driver);
		naaptolResultPage.moveToDesiredProduct(driver, 0);
		naaptolResultPage.clickOnQuickView(0);
		
		// get details from productPage to verify later
		productDetailPage = new ProductDetailPage(driver);
		String expectedProductName = productDetailPage.getProductTitleOnQuickView();
		double expectedProductPrice = productDetailPage.getProductPriceOnQuickView();
		double expectedShipingPrice = productDetailPage.getProductShipingPrice();
		productDetailPage.clickHereToBuy();
		
		// verify product that selected vs product which got stored in the cart
		CartPage cartPage = new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 1);
		Assert.assertEquals(cartPage.getProductName(0), expectedProductName);
		Assert.assertEquals(cartPage.getUnitPrice(0), expectedProductPrice);
		Assert.assertEquals(cartPage.getShippingPrice(0), expectedShipingPrice);

	}

	@Test
	public void verifyAddToCartFromProductDetail() {
		// search and add product to cart directly 
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("toys");
		naaptolHomePage.clickOnSearch();

		naaptolResultPage = new NaaptolResultPage(driver);
		naaptolResultPage.clickOnDesiredProduct(0);
		
		// switch to child browser
		switchToChildBrowser();
		
		// get details from productPage to verify later
		productDetailPage = new ProductDetailPage(driver);
		String expectedProductName = productDetailPage.getProductTitleOnQuickView();
		double expectedProductPrice = productDetailPage.getProductPriceOnQuickView();
		double expectedShipingPrice = productDetailPage.getProductShipingPrice();
		productDetailPage.clickHereToBuy();
		
		// verify product that selected vs product which got stored in the cart
		cartPage = new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 1);
		Assert.assertEquals(cartPage.getProductName(0), expectedProductName);
		Assert.assertEquals(cartPage.getUnitPrice(0), expectedProductPrice);
		Assert.assertEquals(cartPage.getShippingPrice(0), expectedShipingPrice);

	}

	@Test
	public void verifyAddingTwoProductsInTheCart() {
		
		// search and add 1st product in the cart
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("toys");
		naaptolHomePage.clickOnSearch();

		naaptolResultPage = new NaaptolResultPage(driver);
		naaptolResultPage.moveToDesiredProduct(driver, 0);
		naaptolResultPage.clickOnQuickView(0);

		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.clickHereToBuy();
		
		// verify 1st product got successfully added to cart
		cartPage = new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 1);
		
		// close the cart page and return to result page
		cartPage.clickOnClose();
		
		// clear search field and enter 2nd product and search it and click on product directly
		naaptolHomePage.clearSearchField();
		naaptolHomePage.enterProductToSearch("mobiles");
		naaptolHomePage.clickOnSearch();
		naaptolResultPage.clickOnDesiredProduct(1);
		
		// switch to childBrowser and click on buy
		switchToChildBrowser();
		
		productDetailPage.clickHereToBuy();
		
		// verify 2nd product got added or not by cart size 
		Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 2);

	}
	
	@Test
	public void verifyRemoveFunctionalityOfCart() throws InterruptedException {
		
		// search and add product to cart
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("toys");
		naaptolHomePage.clickOnSearch();

		naaptolResultPage = new NaaptolResultPage(driver);
		naaptolResultPage.moveToDesiredProduct(driver, 0);
		naaptolResultPage.clickOnQuickView(0);
		
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.clickHereToBuy();
		 
		
		cartPage = new CartPage(driver);
		// get number of products in the cart
		int productsInCart =cartPage.getNumberOfProductsInCart();
		Assert.assertEquals(productsInCart, 1);
		
		// remove product from the cart
		cartPage.removeItemFromCart();
		
		// wait for the cart to update
		Thread.sleep(2000);
		
		// verify product has bee removed or not
		int productsInCartAfterRemoving =cartPage.getNumberOfProductsInCart();
		Assert.assertNotEquals(productsInCartAfterRemoving, 1);
		
	}
	
	@Test
	public void verifyAmountsInTheCart() {
		
		// search and add product in the cart
		naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("mobile");
		naaptolHomePage.clickOnSearch();
		
		naaptolResultPage =new NaaptolResultPage(driver);
		naaptolResultPage.moveToDesiredProduct(driver, 1);
		naaptolResultPage.clickOnQuickView(1);
		
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.clickHereToBuy();
		
		cartPage = new CartPage(driver);
		// verify orderAmount matches unitPrice+shipping price
		Assert.assertEquals(cartPage.getOrderAmount(0), cartPage.getUnitPrice(0) + cartPage.getShippingPrice(0));
		
	}
	
	@Test
	public void verifyAmountsInTheCartForMultipleProducts() throws InterruptedException, EncryptedDocumentException, IOException {
		//perform search and add 1st product on cart
		naaptolHomePage=new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("toys");
		naaptolHomePage.clickOnSearch();
		
		naaptolResultPage= new NaaptolResultPage(driver);
		naaptolResultPage.moveToDesiredProduct(driver, 0);
		naaptolResultPage.clickOnQuickView(0);
		
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.clickHereToBuy();
		
		cartPage = new CartPage(driver);
		// continue shopping after adding 1 product
		cartPage.clickOnContinueShopping();
		
		// add 2nd product to cart
		naaptolResultPage.moveToDesiredProduct(driver, 1);
		naaptolResultPage.clickOnQuickView(1);
		productDetailPage.clickHereToBuy();
		
		// wait for the cart to update
		Thread.sleep(2000);
		
		// verify number of products in the cart
		int actualSize =cartPage.getNumberOfProductsInCart();
		Assert.assertEquals(actualSize, 2);
		
		// verify totalOrderAmounts of 2 product matches the total final Amount
		double totalOrderAmount=cartPage.getOrderAmount(0)+ cartPage.getOrderAmount(1);
		double totalFinalAmount=cartPage.getTotalPayabaleAmount();
		Assert.assertEquals(totalOrderAmount, totalFinalAmount);
		
		//checkout product
		cartPage.clickOnProceedToCheckout();
		
		
		
		
	}
	
	

}
