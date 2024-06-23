package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	@FindBy (xpath ="//ul[@class='myAddress']") private List<WebElement> address;
	
	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getNumberOfAddress() {
		return address.size();
	}
}
