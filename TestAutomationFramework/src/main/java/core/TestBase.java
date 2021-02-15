package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import configFactory.CONFIG;
import configFactory.ProjectConfig;
import configFactory.ProjectConfigType;
import configFactory.ProjectFactory;
import core.Page;
import driverfactory.LocalDriverFactory;
import driverfactory.LocalDriverManager;
import managers.ExtentTestManager;
import utility.Xls_Reader;



public class TestBase {
	public static ProjectConfig config = ProjectFactory.getConfig(ProjectConfigType.INITCONFIG);
	public ExtentTest test;
	protected WebDriver driver;
	public Page page;
	public Xls_Reader xls_reader =null;
	@BeforeClass
	@Parameters({"browser"})  
	public void setup(String browser,ITestContext context){
		/*if(browser=="Clouds") {
			driver = LocalDriverFactory.createWebDriverInstance(config.getProperty("browserName", CONFIG.CLOUDBROWSERS));
		}*/
		driver = LocalDriverFactory.createWebDriverInstance(browser);
        LocalDriverManager.setWebDriver(driver);
        ExtentTestManager.startTest(context.getAllTestMethods()[0].getInstance().getClass().getSimpleName());
		page = new Page(driver, new WebDriverWait(driver,120), ExtentTestManager.getTest());
	}

	
	@AfterClass
	public void tearDown(){
		driver.close();
		driver.quit();
		ExtentTestManager.endTest();
	}
	
	@AfterSuite
	public void publishreport(){
		ExtentTestManager.publishReport();
	}
	
	public static String addScreenshot() {
		File scrFile = ((TakesScreenshot) LocalDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(scrFile);
			byte[] bytes = new byte[(int) scrFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return "data:image/png;base64," + encodedBase64;
	}

}
