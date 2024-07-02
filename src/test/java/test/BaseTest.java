package test;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import pom.CartPage;
import pom.LoginPage;
import pom.NaaptolHomePage;
import pom.NaaptolResultPage;
import pom.ProductDetailPage;

public class BaseTest {
	
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public void switchToChildBrowser()
	{
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> i = handles.iterator();
		
		driver.switchTo().window(i.next());
		driver.switchTo().window(i.next());

	}
	public NaaptolHomePage naaptolHomePage;
	public NaaptolResultPage naaptolResultPage;
	public ProductDetailPage productDetailPage;
	public CartPage cartPage;
	public LoginPage loginPage;
}
