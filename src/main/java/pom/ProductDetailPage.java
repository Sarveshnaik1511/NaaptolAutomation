package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {
	
	@FindBy (xpath =" //div[@id='square_Details']//h1") private WebElement productNameOnQuickView;
	@FindBy (xpath ="//div[@id='square_Details']//span[@class='offer-price']") private WebElement productPriceOnQuickView;
	@FindBy (xpath ="//a[@id='cart-panel-button-0']") private WebElement clickToBuy;
	
	
	public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getProductTitleOnQuickView() {
		return productNameOnQuickView.getText();
	}

	public double getProductPriceOnQuickView() {

		String[] price = productPriceOnQuickView.getText().split(" ");
		return Double.parseDouble(removeCommaFromString(price[0]));

	}

	public double getProductShipingPrice() {
		String[] price = productPriceOnQuickView.getText().split(" ");
		return Double.parseDouble(removeCommaFromString(price[2]));
	}
	
	
	public void clickHereToBuy() {
		clickToBuy.click();
	}
	
	
	
	

}
