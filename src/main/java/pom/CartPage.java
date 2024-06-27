package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {
	@FindBy (xpath ="//ul[@id='cartData']") private List<WebElement> products;
	@FindBy (xpath ="//div[@class='cart_info']//h2") private List<WebElement> productName;
	@FindBy (xpath ="//ul[@id='cartData']//li[@class='head_UPrice']") private List<WebElement> unitPrice;
	@FindBy (xpath ="//ul[@id='cartData']//li[@class='head_ship']") private List<WebElement> productShippingPrice;
	@FindBy (xpath ="//ul[@id='cartData']//li[@class='head_Amount']")private List<WebElement> orderAmount;
	@FindBy (xpath ="//div[@class='fancybox-skin']//a[@title='Close']") private WebElement close;
	@FindBy (xpath ="//a[@class='link_Continue']") private WebElement continueShopping;
	@FindBy (xpath ="//p[@class='chintu']//a")private WebElement removeItem;
	@FindBy (xpath ="(//ul[@id='cartTotal']//li//label)[1]")private WebElement cartAmount;
	@FindBy (xpath ="//span[@id='totalPayableAmount']")private WebElement totalPayableAmount;
	@FindBy (xpath ="//div[@class='right']//a[@class='red_button2']") private WebElement proceedToCheckout;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getNumberOfProductsInCart() {
		return products.size();
	}
	
	public String getProductName(int index) {
		return productName.get(0).getText();
	}
	
	
	public double getUnitPrice(int index) {
		
		//price will be in the string and it might contain comma i.e (,) eg:- 1,999
		//so we have to remove comma first and then have to convert that value into double
		//firstly we will get the text value, then if comma present in it, it will get removed and then it will converted to double.
		
		// in this case, string returns Rs.1,999
		// we will take the string starting from 1,999
		// so we use substring method substring(3), 3 indicate starting from index 3
		return Double.parseDouble(removeCommaFromString(unitPrice.get(index).getText().substring(3)));
	}
	
 
	public double getShippingPrice(int index) {
		return Double.parseDouble(removeCommaFromString(productShippingPrice.get(index).getText().substring(3)));
	}
	
	public double getOrderAmount(int index) {
		return Double.parseDouble(removeCommaFromString(orderAmount.get(index).getText()));
	}
	
	public double getCartAmount() {
		return Double.parseDouble(removeCommaFromString(cartAmount.getText()));
	}
	
	public double getTotalPayabaleAmount() {
		return Double.parseDouble(removeCommaFromString(totalPayableAmount.getText()));
		
	}
	public void clickOnProceedToCheckout() {
		proceedToCheckout.click();
	}
	
	public void clickOnContinueShopping() {
		continueShopping.click();
	}
	
	public void clickOnClose() {
		close.click();
	}
	
	public void removeItemFromCart() {
		removeItem.click();
	}
	public void waitUntilCartUpdates(WebDriver driver, int productsInCart ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//ul[@id='cartData']"), productsInCart ));
	}
	

}
