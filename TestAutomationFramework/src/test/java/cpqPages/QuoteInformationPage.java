package cpqPages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import baseinterfaces.IAction.clickType;
import core.BasePage;
import logger.LOGGER;

public class QuoteInformationPage extends BasePage {

	public QuoteInformationPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}

	// Page Locators
	@FindBy(xpath = "//*[@class='oj-button-icon oj-start user-icon']")
	WebElement startUserIcon;

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

	public boolean isPageLoaded() {
		return isPageLoaded(startUserIcon);
	}

	
	public void saveAndPrice() {
		try {
			uiAction.click(SaveAndPrice, "Normal Click");
			extentLogger.addInfo("Click on Save & Price Button to call Pricing.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Save & Price Button to call Pricing.");
			waitForProgress();
		} catch (Exception ex) {
			LOGGER.logError(this.getClass().getSimpleName(), "Save and Price Button is not Interactable to Click.");
			extentLogger.addFail(ex.getMessage());
			Assert.fail("Save and Price Button is not Interactable to Click.");
		}
	}

	public void clickOnSubmitQuoteButton() {
		try {
			uiAction.click(submitBtn, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Click on Submit Button to submit Quote.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Submit Button to submit Quote.");
			Thread.sleep(10000);
			waitForProgress();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.logError(this.getClass().getSimpleName(), "Submit button is not interactable to click or not visible to click.");
			extentLogger.addFail(ex.getMessage());
			Assert.fail("Submit button is not interactable to click or not visible to click.");
		}
	}

	public void clickOnFullOrderButton() {
		try {
			uiAction.click(fullOrderButton, "Normal Click");
			extentLogger.addInfo("Click on Full Order Button to Create Full Order.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Full Order Button to Create Full Order.");
			waitForProgress();
		} catch (Exception ex) {
			LOGGER.logError(this.getClass().getSimpleName(),"Full Order button is not interactable to click or not visible to click.");
			extentLogger.addFail(ex.getMessage());
			Assert.fail("Full Order button is not interactable to click or not visible to click.");
		}

	}

	public void clickOnCreateOrderButton() {
		try {
			uiAction.click(createOrderButton, "Normal Click");
			extentLogger.addInfo("Click on Create Order Button to Create Order.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Create Order Button to Create Order.");
			wait = new WebDriverWait(driver, 120);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			//uiAction.addInfoScreenshotusingRobotClass();
			alert.accept();
			LOGGER.logInfo(this.getClass().getSimpleName(), "Alert Accepted.");
			waitForProgress();
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"Create Order button is not interactable to click or not visible to click.");
			Assert.fail("Create Order button is not interactable to click or not visible to click.");

		}

	}

	public void clickOnSaveButton() {
		try {
			uiAction.click(saveButton, "Normal Click");
			extentLogger.addInfo("Click on Save Button to Save Quote.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Save Button to Save Quote.");
			waitForProgress();
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"Create Order button is not interactable to click or not visible to click.",ex.getMessage());
			Assert.fail("Create Order button is not interactable to click or not visible to click.");
		}

	}

}
