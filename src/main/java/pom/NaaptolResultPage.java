package pom;


import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolResultPage extends BasePage{
	
	@FindBy (xpath = "//div[@class='grid_Square ']") private List<WebElement> products;
	@FindBy (xpath = "//a[@class='bt_compare icon chat quickFancyBox']")private List<WebElement> quickView;
	@FindBy (xpath = "//div[@class='item_title']")private List<WebElement> productTitle;
	@FindBy (xpath = "//span[@class='offer-price']")private List<WebElement> productPrice;
	@FindBy (xpath = "//div[@id='square_Details']//h1") private WebElement productTitleOnQuickView;
	@FindBy (xpath = "//li[@id='productPriceDisplay']//span[@class='offer-price']") private WebElement productPriseOnQuickView;
	@FindBy (xpath = "//div[@id='square_Details']//h1") private WebElement productTitleOnNewPage;
	@FindBy (xpath = "//li[@id='productPriceDisplay']//span[@class='offer-price']") private WebElement productPriseOnNewPage;
	
	
	public NaaptolResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void moveToDesiredProduct(WebDriver driver, int index) {
		Actions actions = new Actions(driver);
		actions.moveToElement(products.get(index)).perform();
	}
	
	public void clickOnDesiredProduct(int index) {
		products.get(index).click();
	}


	public void clickOnQuickView(int index) {
		quickView.get(index).click();
	}

	public void isProductsDisplayed(int index) {
		products.get(index).click();
	}

	public String getProductTitle(int index) {
		return productTitle.get(index).getText();
	}

	public boolean getProductPrice(int index) {
		return Boolean.parseBoolean(removeCommaFromString(productPrice.get(index).getText()));
	}

	public String getProductTitleOnQuickView() {
		return productTitleOnQuickView.getText();
	}

	public boolean getProductPriceOnQuickView() {
		String[] price = productPriseOnQuickView.getText().split(" ");
		return Boolean.parseBoolean(removeCommaFromString(price[0]));  
	}

	public boolean getProductPriceOnNewPage() {
		String[] price = productPriseOnNewPage.getText().split(" ");
		return Boolean.parseBoolean(removeCommaFromString( price[0]));
	}

	public String getProductTitleOnNewPage() {
		return productTitleOnNewPage.getText();
	}
}
