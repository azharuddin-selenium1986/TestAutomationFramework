package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import logger.ExtentLogger;
import logger.LOGGER;
//import webutilities.UiAction;
import actions.UiAction;
import configFactory.CONFIG;
import driverfactory.LocalDriverManager;

public class BasePage extends Page {
	protected UiAction uiAction;
	protected ExtentLogger extentLogger;
	 public BasePage(WebDriver driver, WebDriverWait wait,ExtentTest test) {
	        super(driver, wait,test);
	        wait=new WebDriverWait(driver,120);
	        uiAction = new UiAction(driver);
	        extentLogger=new ExtentLogger(test);
	    }
	
	 
		public void navigateToApplication(){
			driver.get(config.getProperty("applicationUrl", CONFIG.APPLICATION));
			extentLogger.addInfo("Open Application URL :"+ config.getProperty("applicationUrl", CONFIG.APPLICATION));
			LOGGER.logInfo("LoginPage", "Open Application URL :"+ config.getProperty("applicationUrl", CONFIG.APPLICATION));
		}
		
		public void navigateToApplication(String url){
			driver.get(config.getProperty("applicationUrl", CONFIG.APPLICATION));
			extentLogger.addInfo("Open Application URL :"+ config.getProperty("applicationUrl", CONFIG.APPLICATION));
			LOGGER.logInfo("LoginPage", "Open Application URL :"+ config.getProperty("applicationUrl", CONFIG.APPLICATION));
		}
		
		public String addScreenshot() {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String encodedBase64 = null;
			FileInputStream fileInputStreamReader = null;
			try {
				fileInputStreamReader = new FileInputStream(scrFile);
				byte[] bytes = new byte[(int) scrFile.length()];
				fileInputStreamReader.read(bytes);
				encodedBase64 = new String(Base64.encodeBase64(bytes));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				test.log(LogStatus.FAIL, e.getMessage());
				extentLogger.addFail(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				extentLogger.addFail(e.getMessage());
			}
			return "data:image/png;base64," + encodedBase64;
		}
		
		
		public boolean waitForElementToBeDisplayed(WebElement element) {
			return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		}
		
		public boolean waitForElementToBeClickable(WebElement element) {
			return wait.until(ExpectedConditions.elementToBeClickable((element))).isEnabled();
		}
		
		public boolean isPageLoaded(WebElement element) {
			return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed() 
					&& 
					wait.until(ExpectedConditions.elementToBeClickable((element))).isEnabled();
		}
		
		public boolean isElementInteractable(WebElement element) {
			return wait.until(ExpectedConditions.elementToBeClickable((element))).isEnabled();
		}
		
		public boolean isElementVisible(WebElement element) {
			return wait.until(ExpectedConditions.elementToBeClickable((element))).isDisplayed();
		}
		public void isAllElementVisible(List<WebElement> elements) {
			wait.until(ExpectedConditions.visibilityOfAllElements((elements)));
		}
		public void waitForProgress() throws InterruptedException{
			WebElement ele = LocalDriverManager.getDriver().findElement(By.xpath("//oj-progress[@role='progress'][@type='circle']"));
			try{
				
				while(ele.isDisplayed()){
					if(ele.getAttribute("title").equals("Completed")){
						System.out.println(ele.getAttribute("title"));
						break;
					}else{
						Thread.sleep(5000);
					}	
				}
			}catch(StaleElementReferenceException ex){
				ele = driver.findElement(By.xpath("//oj-progress[@role='progress'][@type='circle']"));
				String value = ele.getAttribute("title");
				System.out.println("Value "+ value);
			}
		}

}
