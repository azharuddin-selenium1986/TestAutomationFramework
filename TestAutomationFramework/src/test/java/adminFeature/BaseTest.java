/*package adminFeature;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import core.DriverManager;
import core.DriverManagerFactory;
import core.DriverType;

public class BaseTest {
	
	DriverManager driverManager;
	protected WebDriver driver;
	
	
	
	@BeforeTest
	public void setup() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver=driverManager.getWebDriver();
		driver.get("http://uatschneider.bigmachines.com/commerce/display_company_profile.jsp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}

   
	
	@AfterClass
	public void tearDown() {
		
		driverManager.getWebDriver().quit();
		
		
	}
}
*/