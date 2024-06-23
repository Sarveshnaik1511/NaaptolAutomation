package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Parametrization;





public class LoginPage {
	@FindBy (xpath ="//input[@id='gc-registration-basic-panel-mobile']") private WebElement MobilenumberInputField;
	@FindBy (xpath ="//input[@id='gc-registration-basic-panel-submit']") private WebElement continueButton;
	@FindBy (xpath ="//input[@id='gc-registration-otp-panel-otp']") private WebElement otpField;
	@FindBy (xpath ="//input[@id='gc-registration-otp-panel-submit']") private WebElement submitButton;
	@FindBy (xpath ="//select[@id='fktitle_id']") private WebElement title;
	@FindBy (xpath ="//input[@id='firstName']") private WebElement firstName;
	@FindBy (xpath ="//input[@id='lastName']") private WebElement lastName;
	@FindBy (xpath ="//textarea[@id='address']") private WebElement address;
	@FindBy (xpath ="//input[@id='pincode']") private WebElement pincode;
	@FindBy (xpath ="//select[@id='state']") private WebElement state;
	@FindBy (xpath ="//select[@id='city']") private WebElement city;
	@FindBy (xpath ="//input[@id='mobile']") private WebElement mobileNumber;
	@FindBy (xpath ="//a[@id='addEditButton']") private WebElement saveAndProceed;
	
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileNumber(String sheet, int row, int column) throws EncryptedDocumentException, IOException {
		MobilenumberInputField.sendKeys(Parametrization.getTestData(sheet, row, column));
		
	}
	public void clickOnContinueButton() {
		continueButton.click();
	}
	public void enterOtp(String otp) {
		otpField.sendKeys();
	}
	public void clickOnSubmit() {
		submitButton.click();
	}
	public void selectNameTitle(String value) {
		Select selectTitle = new Select(title);
		selectTitle.selectByValue(value);
	}
	public void enterFirstName(String sheet , int row , int column) throws EncryptedDocumentException, IOException {
	firstName.sendKeys(Parametrization.getTestData(sheet, row, column));
	}
	
	public void enterLastName(String sheet , int row , int column) throws EncryptedDocumentException, IOException {
	lastName.sendKeys(Parametrization.getTestData(sheet, row, column));	
	}
	
	public void enterAddress(String sheet , int row , int column) throws EncryptedDocumentException, IOException {
		address.sendKeys(Parametrization.getTestData(sheet, row, column));
	}
	
	public void enterPinCode(String sheet , int row , int column) throws EncryptedDocumentException, IOException {
		pincode.sendKeys(Parametrization.getTestData(sheet, row, column));
	}
	
	
	public void selectState (String stateByValue) {
		Select chooseState = new Select(state);
		chooseState.selectByValue(stateByValue);
	}
	public void selectCity (String value) {
		Select chooseCity = new Select(city);
		chooseCity.selectByValue(value);
	}
	public void enterMobileNumberForRegistration(String sheet , int row , int column) throws EncryptedDocumentException, IOException {
		mobileNumber.sendKeys(Parametrization.getTestData(sheet, row, column));
	}
	
	public void clickOnSaveAndProceed() {
		saveAndProceed.click();
	}
	
}
