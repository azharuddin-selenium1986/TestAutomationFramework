package cpqPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import core.BasePage;

public class CPQHeadersPage extends BasePage {

	public CPQHeadersPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	// Page Locators
	@FindBy(css = "button[name='save']")
	private WebElement saveButton;

	@FindBy(name = "save_and_price")
	WebElement SaveAndPrice;

	@FindBy(name = "submit")
	WebElement submitBtn;

	@FindBy(name = "submit_doa")
	WebElement submitDOAButton;

	@FindBy(name = "copy")
	private WebElement copyButton;

	@FindBy(xpath = "//*[@class='oj-dialog-footer']//*[text()='Submit']")
	List<WebElement> submitCom;

	@FindBy(xpath = "//*[@class='oj-dialog-body dialog-templat']//textarea")
	WebElement performerComment;

	@FindBy(xpath = "//*[@class='oj-dialog-footer']//*[text()='Submit']")
	WebElement submitCommentsButton;

	@FindBy(name = "full_order")
	private WebElement fullOrderButton;
	@FindBy(name = "createOrder_quote_fakeBtn0")
	private WebElement createOrderButton;
	
	public void saveAndPrice() {
		try {
			uiAction.click(SaveAndPrice,"Normal Click");
			Thread.sleep(15000);
			test.log(LogStatus.INFO, "Click on Save & Price Button to call Pricing.");
			waitForProgress();
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Save and Price Button is not Interactable to Click.");
			test.log(LogStatus.FAIL, ex.getMessage());
			Assert.fail("Save and Price Button is not Interactable to Click.");
		}
	}
	
	public void clickOnSubmitQuoteButton()
	{
		try{	
			uiAction.click(submitBtn, "Normal Click");
            extentLogger.addInfo("Click on Submit Button to submit Quote.");
            Thread.sleep(10000);
            waitForProgress();
            test.log(LogStatus.INFO, test.addScreenCapture(addScreenshot()));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			test.log(LogStatus.FAIL, "Submit button is not interactable to click or not visible to click.");
			Assert.fail("Submit button is not interactable to click or not visible to click.");
		}
	}

	/*public void clickOnFullOrderButton() {
		try{	
			uiAction.click(fullOrderButton, "Normal Click");
            uiAction.addInfoLogStep("Click on Full Order Button to Create Full Order.");
            LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Full Order Button to Create Full Order.");
            waitForProgress();
            uiAction.addInfoScreenshot();
		}
		catch(Exception ex)
		{
			uiAction.reportException(ex, "Full Order button is not interactable to click or not visible to click.");
			LOGGER.logError(this.getClass().getSimpleName(), "Full Order button is not interactable to click or not visible to click.", ex.getMessage());
			Assert.fail(addScreenshot());
			
		}
		
	}

	public void clickOnCreateOrderButton() {
		try{
			uiAction.click(createOrderButton, "Normal Click");
            uiAction.addInfoLogStep("Click on Create Order Button to Create Order.");
            LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Create Order Button to Create Order.");
            wait = new WebDriverWait(driver, 120);
    	   Alert alert= wait.until(ExpectedConditions.alertIsPresent());
    	   uiAction.addInfoScreenshotusingRobotClass();
           alert.accept();
           LOGGER.logInfo(this.getClass().getSimpleName(), "Alert Accepted.");
           waitForProgress();
		}catch(Exception ex){
			uiAction.reportException(ex, "Create Order button is not interactable to click or not visible to click.");
			LOGGER.logError(this.getClass().getSimpleName(), "Create Order button is not interactable to click or not visible to click.", ex.getMessage());
			Assert.fail(addScreenshot());
			
		}
		
	}

	
	public void clickOnSaveButton() {
		try{
			uiAction.click(saveButton, "Normal Click");
            uiAction.addInfoLogStep("Click on Save Button to Save Quote.");
            LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Save Button to Save Quote.");
           waitForProgress();
		}catch(Exception ex){
			uiAction.reportException(ex, "Create Order button is not interactable to click or not visible to click.");
			LOGGER.logError(this.getClass().getSimpleName(), "Create Order button is not interactable to click or not visible to click.", ex.getMessage());
			Assert.fail(addScreenshot());
			
		}
		
	}*/

}
