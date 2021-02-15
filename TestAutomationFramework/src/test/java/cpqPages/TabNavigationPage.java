package cpqPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import baseinterfaces.IAction.ScrollType;
import baseinterfaces.IAction.clickType;
import core.BasePage;
import driverfactory.LocalDriverManager;
import logger.LOGGER;
import managers.ExtentTestManager;

public class TabNavigationPage extends BasePage {

	public TabNavigationPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Opportunity and Quote Info']")
	private WebElement Opportunity_QuoteInfoTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Accounts']")
	private WebElement accountsTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Contacts']")
	private WebElement contactsTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Team']")
	private WebElement teamsTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Upload Products From Catalog']")
	private WebElement uploadProductsFromCatalogTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Upload Products']")
	private WebElement uploadProducts;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Approvals']")
	private WebElement approvalsTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='OutPut']")
	private WebElement outputTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Attachments']")
	private WebElement attachmentsTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Notes']")
	private WebElement notesTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Order Info']")
	private WebElement orderInfoTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Contract Info']")
	private WebElement contractInfoTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Revisions']")
	private WebElement revisionsTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Useful Link']")
	private WebElement usefulLinkTab;
	@FindBy(xpath="//ul[@role='presentation'][contains(@class,'tab-list')]/li/a[@title='Line Item Information']")
	private WebElement lineItemInformationTab;
	public Opportunity_QuoteInfoPage navigateToOpportunityAndQuoteInfoPage() {
		try {
			uiAction.click(Opportunity_QuoteInfoTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Opportunity and Quote Info Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Opportunity and Quote Info Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Opportunity and Quote Info Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Opportunity and Quote Info Tab");
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public CPQAccountsPage navigateToAccountsPage() {
		try {
			uiAction.click(accountsTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Accounts Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Accounts Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Accounts Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Accounts Tab");
		}
		return GetInstance1(CPQAccountsPage.class);
	}
	
	public CPQContactsPage navigateToContactsPage() {
		try {
			uiAction.click(contactsTab, clickType.JS_CLICK);
			extentLogger.addInfo("Navigate to Contacts Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Contacts Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Contacts Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Contacts Tab");
		}
		return GetInstance1(CPQContactsPage.class);
	}
	
	public Opportunity_QuoteInfoPage navigateToTeamsPage() {
		try {
			uiAction.click(teamsTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Teams Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Teams Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Teams Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Teams Tab");
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public Opportunity_QuoteInfoPage navigateToUploadProductsFromCatalogPage() {
		try {
			uiAction.click(uploadProductsFromCatalogTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Upload Products From Catalog Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Upload Products From Catalog Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Upload Products From Catalog Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Upload Products From Catalog Tab");
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	
	public Opportunity_QuoteInfoPage navigateToApprovalsPage() {
		try {
			uiAction.click(uploadProductsFromCatalogTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Approvals Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Approvals Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Approvals Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Approvals Tab");
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public Opportunity_QuoteInfoPage navigateToOutputPage() {
		try {
			uiAction.click(uploadProductsFromCatalogTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Output Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Output Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Output Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Output Tab");
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public CPQAttachmentsPage navigateToAttachmentsPage() {
		try {
			uiAction.click(attachmentsTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Attachments Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Attachments Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Attachments Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Attachments Tab");
		}
		return GetInstance1(CPQAttachmentsPage.class);
	}
	
	public CPQNotesPage navigateToNotesPage() {
		try {
			uiAction.click(notesTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Notes Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Notes Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Notes Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Notes Tab");
		}
		return GetInstance1(CPQNotesPage.class);
	}
	
	public Opportunity_QuoteInfoPage navigateToOrderInfoPage() {
		try {
			uiAction.click(orderInfoTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Order Info Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Order Info Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Order Info Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Order Info Tab");
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public Opportunity_QuoteInfoPage navigateToContractInfoPage() {
		try {
			uiAction.click(orderInfoTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Contract Info Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Contract Info Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Contract Info Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Contract Info Tab");
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public Opportunity_QuoteInfoPage navigateToRevisionPage() {
		try {
			uiAction.click(orderInfoTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Revision Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Revision Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Revision Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Revision Tab");
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public Opportunity_QuoteInfoPage navigateToUsefulLinkPage() {
		try {
			uiAction.click(orderInfoTab, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Useful Link Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Useful Link Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Useful Link Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Useful Link Tab");
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public CPQLineItemInformationPage navigateToLineItemInformationPage() {
		try {
			uiAction.click(lineItemInformationTab, clickType.JS_CLICK);
			extentLogger.addInfo("Navigate to Line Item Information Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Line Item Information Tab");
			waitForProgress();
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Line Item Information Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Line Item Information Tab");
		}
		return GetInstance1(CPQLineItemInformationPage.class);
	}
	
	
	public CPQUploadCSVProductsPage navigateToUploadCSVProductsPage() {
		try {
			uiAction.scrollPage(ScrollType.HOME);
			uiAction.click(uploadProducts, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Navigate to Upload Products Tab");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Navigate to Upload Products Tab");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Navigate to Upload Products Tab",ex.getMessage());
			Assert.fail("Failed to Navigate to Upload ProductsTab");
		}
		return GetInstance1(CPQUploadCSVProductsPage.class);
	}

}
