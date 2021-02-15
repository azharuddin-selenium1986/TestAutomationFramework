package cpqPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import core.BasePage;
import logger.LOGGER;
import managers.ExtentTestManager;

public class CPQAccountsPage extends BasePage {

	public CPQAccountsPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id='setBillTo_quote']/button")
	private WebElement soldToSearchMagnfyingIcon;
	@FindBy(xpath = "//*[@id='setSoldTo_quote']/button")
	private WebElement quoteToSerachMagnifyingIcon;
	@FindBy(css = "button[class='cyp_pw_btn_search']")
	private WebElement soldTosearchButton;
	@FindBy(xpath = "(//button[@class='cyp_pw_btn_search'])[2]")
	private WebElement quoteToSearchButton;
	@FindBy(xpath = "//table/tbody/tr[1]/td[contains(text(),'Account Numbe') or contains(text(),'Sold To')]/following-sibling::td/input[@name='cyp_pw_txt_customer_number']")
	private WebElement soldToAccountNumberTextbox;

	@FindBy(xpath = "//table/tbody/tr[1]/td[contains(text(),'Account Number')]/following-sibling::td/input[@name='cyp_pw_txt_customer_number']")
	private WebElement soldToAccountNumberTextforMalysia;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[2]/input[@name='cyp_pw_txt_customer_number'])[2]")
	private WebElement quoteToAccountNumberTextbox;
	@FindBy(xpath = "//table[@class='cyp_pw_cls_search_list']/tbody/tr[2]/td[1]/a[contains(text(),'Select')]")
	private WebElement selectLink;

	@FindBy(name = "add_selected_contact_to_the_contacts_tab")
	WebElement addToContacts;

	@FindBy(xpath = "(//button[@name='refresh_contacts'])[1]")
	private WebElement refreshContactsButton;

	public boolean isPageLoaded() {
		return isPageLoaded(soldToSearchMagnfyingIcon);
	}

	

	private void clickOnSoldToSearchMagnifyingGlassIcon() {
		try {
			isElementInteractable(soldToSearchMagnfyingIcon);
			uiAction.click(soldToSearchMagnfyingIcon, "JSClick");
			extentLogger.addInfo("Click on Sold to Search Magnifying Icon.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Sold to Search Magnifying Icon.");
			Thread.sleep(5000);
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"SoldToSearchMagnfyingIcon is not Intercatble to click or not Present in UI to Click",
					ex.getMessage());
			Assert.fail("SoldToSearchMagnfyingIcon is not Intercatble to click or not Present in UI to Click");
		}
		

	}
	
	private void clickOnQuoteToSearchMagnifyingGlassIcon() {
		try {
			isElementInteractable(quoteToSerachMagnifyingIcon);
			uiAction.click(quoteToSerachMagnifyingIcon, "JSClick");
			extentLogger.addInfo("Click on Quote to Search Magnifying Icon.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Quote to Search Magnifying Icon.");
			Thread.sleep(5000);
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"Quote to Search Magnifying Icon is not Interactable to click or not Present in UI to Click",
					ex.getMessage());
			Assert.fail("Quote to Search Magnifying Icon is not Interactable to click or not Present in UI to Click");
		}
		

	}

	private void waitForSoldToSearchTableIsPresent() {
		try {
			isElementVisible(soldToAccountNumberTextbox);
			isElementInteractable(soldToAccountNumberTextbox);
			extentLogger.addInfo("Sold To Search Table is Present.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Sold To Search Table is Present.");
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"Sold to Search Table is not present in UI while clicking on Sold to Search magnifying glass icon.",
					ex.getMessage());
			Assert.fail(
					"Sold to Search Table is not present in UI while clicking on Sold to Search magnifying glass icon.");
		}

	}
	private void waitForQuoteToSearchTableIsPresent() {
		try {
			isElementVisible(quoteToAccountNumberTextbox);
			isElementInteractable(quoteToAccountNumberTextbox);
			extentLogger.addInfo("Quote To Search Table is Present.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Quote To Search Table is Present.");
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"Quote to Search Table is not present in UI while clicking on Quote to Search magnifying glass icon.",
					ex.getMessage());
			Assert.fail(
					"Quote to Search Table is not present in UI while clicking on Quote to Search magnifying glass icon.");
		}

	}

	private void enterSoldToAccountNumberToSearch(String soldToAccountNumber) {
		try {
			uiAction.enterTextUsingJavaScript(soldToAccountNumberTextbox, soldToAccountNumber);
			extentLogger.addInfo("Enter Sold To Account Number as " + soldToAccountNumber);
			LOGGER.logInfo(this.getClass().getSimpleName(), "Enter Sold To Account Number as " + soldToAccountNumber);
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), "Sold To Account Number Textbox is not interactable.",
					ex.getMessage());
			Assert.fail("Sold To Account Number Textbox is not interactable.");
		}
	}
	
	private void enterQuoteToAccountNumberToSearch(String quoteToAccountNumber) {
		try {
			uiAction.enterTextUsingJavaScript(quoteToAccountNumberTextbox, quoteToAccountNumber);
			extentLogger.addInfo("Enter Quote To Account Number as " + quoteToAccountNumber);
			LOGGER.logInfo(this.getClass().getSimpleName(), "Enter Quote To Account Number as " + quoteToAccountNumber);
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), "Quote To Account Number Textbox is not interactable.",
					ex.getMessage());
			Assert.fail("Quote To Account Number Textbox is not interactable.");
		}
	}

	private void clickOnSearchButton() {
		try {
			uiAction.click(soldTosearchButton, "JSClick");
			extentLogger.addInfo("Click on Search Button to search account.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Search Button to search account.");
		} catch (Exception ex) {
			extentLogger.addInfo(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), "Search Button is not interactable to click.",
					ex.getMessage());
			Assert.fail("Search Button is not interactable to click.");
		}
	}
	
	private void clickOnQuoteToSearchButton() {
		try {
			uiAction.click(quoteToSearchButton, "JSClick");
			extentLogger.addInfo("Click on Search Button to search account.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Search Button to search account.");
		} catch (Exception ex) {
			extentLogger.addInfo(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), "Search Button is not interactable to click.",
					ex.getMessage());
			Assert.fail("Search Button is not interactable to click.");
		}
	}

	private void selectAccount() {
		try{
			Assert.assertTrue(isSelectLinkVisible());
			uiAction.click(selectLink, "JSClick");
			extentLogger.addInfo("Click on Select link to select account.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Select link to select account.");
			waitForProgress();
			Thread.sleep(15000);
		}catch(Exception ex){
			extentLogger.addFail(ex.getMessage());
			  LOGGER.logError(this.getClass().getSimpleName(), "Select Link is not interactable to click or Account Number is not displayed to select.");
			  Assert.fail("Select Link is not interactable to click or Account Number is not displayed to select.");
		}
		
	}
	
	
	private void clickOnRefreshContactsButton(){
		try{
			isElementVisible(refreshContactsButton);
			isElementInteractable(refreshContactsButton);
			//uiAction.click(refreshContactsButton,"JSClick");
			uiAction.click(driver.findElement(By.xpath("(//button[@name='refresh_contacts'])[1]")),"JSClick");
			extentLogger.addInfo("Click on Refresh Contacts Button.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Refresh Contacts Button.");
			waitForProgress();
			Thread.sleep(20000);
		}catch(Exception ex){
			extentLogger.addFail(ex.getMessage());
			  LOGGER.logError(this.getClass().getSimpleName(), "Refresh Contacts Button is not visible to click or not iteractable",ex.getMessage());
			  Assert.fail("Refresh Contacts Button is not visible to click or not iteractable");
		}
	}
	
	public boolean isSelectLinkVisible() {
		return isElementVisible(selectLink)&&isElementInteractable(selectLink);
	}
	
	@FindBy(id="SelectAContactFromBillToAccount")
	private WebElement multiSelectDropdown;
	private void selectContact(String conactName) {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id("SelectAContactFromBillToAccount")));
			Select select = new Select(driver.findElement(By.id("SelectAContactFromBillToAccount")));
			System.out.println(select.isMultiple());
			Assert.assertTrue(isElementVisible(multiSelectDropdown));
			if(select.isMultiple()){
				System.out.println("True");
				List<WebElement> options = select.getOptions();
				for(int i=0;i<options.size();i++){
					System.out.println(options.get(i).getText());
					if(options.get(i).getText().equals(conactName)){
						select.selectByVisibleText(conactName);
						extentLogger.addInfo("Selected Contact Name as "+conactName);
						LOGGER.logInfo(this.getClass().getSimpleName(), "Selected Contact Name as "+conactName);
						break;
					}
				}
			}
		} catch (Exception ex) {
			extentLogger.addFail(conactName+" Contact is not available in contacts dropdown");
			  LOGGER.logError(this.getClass().getSimpleName(), conactName+" Contact is not available in contacts dropdown",ex.getMessage());
			  Assert.fail(conactName+" Contact is not available in contacts dropdown");
		}
	}

	private void clickOnAddToContactsButton(){	
		try{
			uiAction.click(addToContacts, "Normal Click");
			extentLogger.addInfo("Click on Add To Contacts Button.");
			LOGGER.logInfo(this.getClass().getSimpleName(),"Click on Add To Contacts Button.");
			waitForProgress();
			Thread.sleep(15000);
		}catch(Exception ex){
			extentLogger.addFail("Failed to Click on Add To Contacts Button or Add To Contacts button is not iteractable");
			  LOGGER.logError(this.getClass().getSimpleName(),"Failed to Click on Add To Contacts Button or Add To Contacts button is not iteractable");
			  Assert.fail("Failed to Click on Add To Contacts Button or Add To Contacts button is not iteractable");
		}
	}
	
	
	public CPQAccountsPage addQuoteToAccount(String quoteToAccountNumber) {
		this.clickOnQuoteToSearchMagnifyingGlassIcon();
		this.waitForQuoteToSearchTableIsPresent();
		this.enterQuoteToAccountNumberToSearch(quoteToAccountNumber);
		this.clickOnQuoteToSearchButton();
		this.selectAccount();
		return GetInstance1(CPQAccountsPage.class);
	}
	
	public CPQAccountsPage addSoldToAccount(String soldToAccountNumber) {
		this.clickOnSoldToSearchMagnifyingGlassIcon();
		this.waitForSoldToSearchTableIsPresent();
		this.enterSoldToAccountNumberToSearch(soldToAccountNumber);
		this.clickOnSearchButton();
		this.selectAccount();
		return GetInstance1(CPQAccountsPage.class);
	}
	
	public void addContactsFromAccountsPage(String contactName) {
		this.clickOnRefreshContactsButton();
		this.selectContact(contactName);
		this.clickOnAddToContactsButton();
	}
}
