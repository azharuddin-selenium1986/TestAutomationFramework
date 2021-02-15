package cpqPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import core.BasePage;
import logger.LOGGER;

public class CPQLandingPage extends BasePage {

	public CPQLandingPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}
	
	// Page Locators
	@FindBy(css = "a[title='Product List'")
	private WebElement homeIcon;

	@FindBy(xpath = "//*[contains(@href,'commerce_manager') and contains(@title,'France')]")
	WebElement franceCommerceProcessManagerIcon;

	@FindBy(xpath = "//nav[@role='navigation']/div[@id='cpq-header-tb']/a[contains(@href,'report_manager') and contains(@title,'France')]")
	WebElement franceCommerceReportingManagerIcon;

	@FindBy(xpath = "//div[@id='cpq-header-tb']/a[@title='Schneider Country Commerce Process - Manager']/span[1]")
	WebElement schneiderCountryCommerceProcessManagerIcon;
	
	//Actions
	
			public CPQDashboardPage clickOnFranceCommerceProcess(){
				try{
					Assert.assertTrue(waitForElementToBeDisplayed(franceCommerceProcessManagerIcon));
					Assert.assertTrue(waitForElementToBeClickable(franceCommerceProcessManagerIcon));
					uiAction.click(franceCommerceProcessManagerIcon,"JSClick");
					extentLogger.addInfo("Click on France Commerce Process Manager Icon.");
					LOGGER.logInfo(this.getClass().getSimpleName(), "Click on France Commerce Process Manager Icon.");
				}catch(Exception ex){
					extentLogger.addFail(ex.getMessage());
					Assert.fail("France Commerce Process Manager Icon is not interactbale to click");
				}
				return GetInstance1(CPQDashboardPage.class);
			}
			
			public CPQDashboardPage clickOnSchneiderCountryCommerceProcess(){
				try{
					Assert.assertTrue(waitForElementToBeDisplayed(schneiderCountryCommerceProcessManagerIcon));
					Assert.assertTrue(waitForElementToBeClickable(schneiderCountryCommerceProcessManagerIcon));
					uiAction.click(schneiderCountryCommerceProcessManagerIcon,"JSClick");
					extentLogger.addInfo("Click on Schneider Country Commerce Process Manager Icon.");
					LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Schneider Country Commerce Process Manager Icon.");
					
				}catch(Exception ex){
					extentLogger.addFail(ex.getMessage());
					Assert.fail("Schneider Country Commerce Process Manager Icon is not interactbale to click");
				}
				return GetInstance1(CPQDashboardPage.class);
			}

}
