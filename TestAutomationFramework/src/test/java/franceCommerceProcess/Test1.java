package franceCommerceProcess;
import static org.testng.Assert.assertTrue;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import core.TestBase;
import driverfactory.TestUtil;
import utility.Xls_Reader;
import logger.LOGGER;
import managers.ExtentTestManager;
import pages.LoginPage;

/** 
 * @author SESA443020
 * 
 * 
 *
 */


public class Test1 extends TestBase {
	
	@Test(priority=1)
	public void login() throws InterruptedException{
		ExtentTestManager.getTest().setDescription("Testing Upload Functionality from Cloud...");
       page.GetInstance1(LoginPage.class).navigateToApplication("https://blueimp.github.io/jQuery-File-Upload/");
       //page.GetInstance1(LoginPage.class).enterText(data.get("username"));
       
       //driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		Thread.sleep(2000);
		WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
		addFile.sendKeys("C:/Users/azhar/eclipse-workspace/TestAutomationFramework/familyTree_600.jpg");
		LOGGER.logInfo(this.getClass().getSimpleName(),"Upload File");
		
		driver.findElement(By.xpath(".//span[text()='Start upload']")).click();

		Thread.sleep(2000);
		if(driver.findElement(By.xpath(".//a[text()='familyTree_600.jpg']")).isDisplayed()) {
			assertTrue(true, "Image Uploaded");
		}else {
			assertTrue(false, "Image not Uploaded");
		}
		driver.findElement(By.xpath(".//a[text()='familyTree_600.jpg']")).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.FAIL,ExtentTestManager.getTest().addScreenCapture(TestBase.addScreenshot()));
	}
	
	@Test(dataProvider="jsonDP",dataProviderClass=dataProvider.TestUtil.class,priority=2)
	public void loginTest1(HashMap<String,String> data) throws InterruptedException{
       page.GetInstance1(LoginPage.class).navigateToApplication("https://google.com");
       page.GetInstance1(LoginPage.class).enterText(data.get("username"));
 
	}
	
	@DataProvider(name = "multipleIter")
	public Object[][] getData() {
		xls_reader = new Xls_Reader("C:\\Users\\azhar\\eclipse-workspace\\CPQ_Project\\resources\\xls\\TestData.xlsx");
		return TestUtil.getTestdataUsingTable(xls_reader,"LoginTest");
	}

}
