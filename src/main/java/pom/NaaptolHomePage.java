package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolHomePage {
	
	@FindBy (xpath ="//a[@id='login-panel-link']")private WebElement loginOrRegester;
	@FindBy (xpath = "//div[@id='cate_head']")private WebElement shoppingCategories;
	@FindBy (xpath = "//input[@id='header_search_text']")private WebElement searchField;
	@FindBy (xpath = "(//div[@class='search'])[2]//a")private WebElement search;
	@FindBy (xpath = "(//a[@id='cart-panel-link'])[2]")private WebElement cart;
	@FindBy (xpath = "//a[text()='Track Order']")private WebElement trackOrder;
	@FindBy (xpath= "(//div[@id='mainMenuContent']//nav//ul//li)[4]")private WebElement listItem;
	@FindBy (xpath = "//div[@class='grid_Square ']")private List<WebElement> productList;
	@FindBy (xpath = "//section[@id='registerSignBox']")private WebElement loginRegesterPopup;
	@FindBy (xpath = " //p[@class='staticDiscNote']")private WebElement trackOrderNote;
	@FindBy (xpath ="//p[text()='Login / Register']")private WebElement loginregesterText;
	
	
	
	 public NaaptolHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	 public void clickOnLoginOrRegester() {
		 loginOrRegester.click();
	 }
	 public void clickOnTrackOrder() {
		 trackOrder.click();
	 }
	 public void enterProductToSearch(String product) {
		 searchField.sendKeys(product);
	 }
	 public void clickOnSearch() {
		 search.click();
	 }
	 public void viewShoppingCategories(WebDriver driver) {
		 Actions actions = new Actions(driver);
		 actions.moveToElement(shoppingCategories).perform();;
	 }
	 public void clickOnAddToCart() {
		 cart.click();
	 }
	public boolean isListItemDisplayed() {
		return listItem.isDisplayed();
	}
	public int getNumberofProductDisplayed() {
		return productList.size();
	}
	public boolean isShoppingCategoriesDisplayed() {
		return	shoppingCategories.isDisplayed();
	}
	public boolean isLoginOrregesterPopupDisplayed() {
		return	loginRegesterPopup.isDisplayed();
	}
	public boolean isTrackOrderPageDisplayed() {
		return trackOrderNote.isDisplayed();
	}
	public boolean isLoginOrRegesterTextVisible() {
		return loginregesterText.isDisplayed();
	}
	public void clearSearchField() {
		searchField.clear();
	}
	
}
