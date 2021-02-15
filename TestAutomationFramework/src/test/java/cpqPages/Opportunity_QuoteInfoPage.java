package cpqPages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import baseinterfaces.IAction.clickType;
import core.BasePage;
import logger.LOGGER;

public class Opportunity_QuoteInfoPage extends BasePage{
	
	public Opportunity_QuoteInfoPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	@FindBy(id="quoteDescription_quote")
	private WebElement quoteNameTextbox;
	
	@FindBy(xpath="//div[contains(@id,'ojChoiceId_spaType_quote')]")
	private WebElement spaTypeDropdown;
	
	@FindBy(xpath="//ul[@class='oj-listbox-results']/li")
	private List<WebElement> listOfResults;
	
	@FindBy(css="div[id='ojChoiceId_purchasingChannel_quote']")
	private WebElement purchasingChannelDropDown;
	
	
	public boolean isOpportunity_QuoteInfoPageLoaded() {
		return isElementInteractable(quoteNameTextbox);
	}
	
	public Opportunity_QuoteInfoPage setQuoteName(String quoteName) {
		try {
			uiAction.typeText(quoteNameTextbox, quoteName);
			extentLogger.addInfo("Enter QuoteName as "+quoteName);
			LOGGER.logInfo(this.getClass().getSimpleName(), "Enter QuoteName as "+quoteName);
			waitForProgress();
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"Failed to Enter QuoteName or QuoteName Textbox is not interactable",ex.getMessage());
			Assert.fail("Failed to Enter QuoteName or QuoteName Textbox is not interactable");
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	public Opportunity_QuoteInfoPage clickOnSPADropdown() {
		try {
			uiAction.click(spaTypeDropdown,clickType.NORMAL_CLICK);
			extentLogger.addInfo("Click On SPA Dropdown.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click On SPA Dropdown.");
			waitForProgress();
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"Failed to Click on SPA Dropdown or SPA Dropdown is not interactable",ex.getMessage());
			Assert.fail("Failed to Click on SPA Dropdown or SPA Dropdown is not interactable");
		}
		
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public Opportunity_QuoteInfoPage selectSPAType(String spaType) {	
		
		
		try{
			if(listOfResults.size()>1){
				for(int i=0;i<listOfResults.size();i++){
					if(listOfResults.get(i).getText().equals(spaType)){
						uiAction.click(listOfResults.get(i), "Normal Click");
						extentLogger.addInfo("SPA Type Selected as "+spaType);
						LOGGER.logInfo(this.getClass().getSimpleName(), "SPA Type Selected as "+spaType);
						break;
					}
				}
			}else{
				throw new NoSuchElementException("List of SPA Type is not present.");
			}
		}catch(Exception ex){
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),"List of SPA Type is not present or failed to select SPA Type "+spaType,ex.getMessage());
			Assert.fail("List of SPA Type is not present or failed to select SPA Type "+spaType);
		}
	
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public Opportunity_QuoteInfoPage clickOnPurchasingChannelDropDown() {
		try {
			waitForProgress();
			uiAction.click(purchasingChannelDropDown, clickType.NORMAL_CLICK);
			extentLogger.addInfo("Click On Purchasing Channel Dropdown.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click On purchasing Channel Dropdown.");
			waitForProgress();
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"Failed to Click on Purchasing Channel Dropdown or Purchasing Channel Dropdown is not interactable",ex.getMessage());
			Assert.fail("Failed to Click on Purchasing Channel Dropdown or Purchasing Channel Dropdown is not interactable");
		}
		
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
	public Opportunity_QuoteInfoPage selectpurchasingChannel(String purchasingChannel) {
		try{
			if(listOfResults.size()>1){
				for(int i=0;i<listOfResults.size();i++){
					if(listOfResults.get(i).getText().equals(purchasingChannel)){
						uiAction.click(listOfResults.get(i), "Normal Click");
						extentLogger.addInfo("Purchasing Channel Selected as "+purchasingChannel);
						LOGGER.logInfo(this.getClass().getSimpleName(), "Purchasing Channel Selected as "+purchasingChannel);
						break;
					}
				}
			}else{
				throw new NoSuchElementException("List of Purchasing Channel  is not present.");
			}
		}catch(Exception ex){
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"List of Purchasing Channel Type is not present or failed to select Purchasing Channel Type "+purchasingChannel,
					ex.getMessage());
			Assert.fail("List of Purchasing Channel Type is not present or failed to select Purchasing Channel Type "+purchasingChannel);
		}
		return GetInstance1(Opportunity_QuoteInfoPage.class);
	}
	
}
