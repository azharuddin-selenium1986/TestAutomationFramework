package cpqPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import core.BasePage;
import logger.LOGGER;

public class CPQDashboardPage extends BasePage{

	public CPQDashboardPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="new_search_id")
	WebElement refineQuote;
	@FindBy(xpath="//td[contains(text(),'Quote Number') or contains(text(),'Numéro de')] /../td[2]/select")
	WebElement quoteNumberAttributeDropdown;
	@FindBy(xpath="//*[contains(@href,'displaySavedSearch')]")
	WebElement refineBy_btn;
	@FindBy(xpath="//*[@id='critTableBody']//input[2] | //table/tbody[@id='critTableBody']/tr/td[@class='form-input']/td/input")
	WebElement quoteNum_txtBox;
	@FindBy(id="search")
	WebElement searchBtn;
	@FindBy(xpath="//table[@aria-describedby='cm-manager-content-heading']/tbody/tr/td/div/a[@class='list-field']")
	List<WebElement> listOfQuoteNumbers;
	@FindBy(id="new_transaction")
	WebElement newTransaction;
	
	public boolean isPageLoaded() {
		return isPageLoaded(newTransaction) && isPageLoaded(newTransaction);
	}
	
	public QuoteInformationPage clickCreateNewTransaction() {
		try {
			Assert.assertTrue(isPageLoaded());
			uiAction.click(newTransaction, "Normal Click");
			extentLogger.addInfo("Click on New Transaction Button to create a new Quote.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on New Transaction Button to create a new Quote.");
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logInfo(this.getClass().getSimpleName(),"New Transaction Button is not interactable");
			Assert.fail("New Transaction Button is not interactable");
		}
		return GetInstance1(QuoteInformationPage.class);
	}
}
