package franceCommerceProcess;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import core.BasePage;
import core.TestBase;
import cpqPages.CPQAccountsPage;
import cpqPages.CPQLoginPage;
import cpqPages.Opportunity_QuoteInfoPage;
import cpqPages.TabNavigationPage;
import managers.ExtentTestManager;

public class FRA_TripartiteQuote extends TestBase {

	@Test(priority = 1)
	public void loginToApplicationAnndNavigateCPQDashboardPage() throws InterruptedException {
		ExtentTestManager.getTest().setDescription("Login To CPQ Application");
		try {
			page.GetInstance1(BasePage.class).navigateToApplication();
			Assert.assertTrue(page.GetInstance1(CPQLoginPage.class).enterCPQUsername("SELENIUM_FRA03_Sales_Rep")
					.enterPassword("SCH123").clickLoginButton().clickOnFranceCommerceProcess()
					.clickCreateNewTransaction().isPageLoaded());
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}
	}

	@Test(priority = 2)
	public void enterOpportunityAndQuoteInfo() throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "#### Fill Oppotunity and Quote Info-Started ####");
			Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToOpportunityAndQuoteInfoPage()
					.isOpportunity_QuoteInfoPageLoaded());
			page.GetInstance1(Opportunity_QuoteInfoPage.class).setQuoteName("testQuote").clickOnSPADropdown()
					.selectSPAType("None").clickOnPurchasingChannelDropDown()
					.selectpurchasingChannel("Purchasing through a Distributor").waitForProgress();
			ExtentTestManager.getTest().log(LogStatus.INFO, "#### Fill Oppotunity and Quote Info-Ended ####");
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}
	}
	//Direct purchasing to Schneider
	//Purchasing through a Distributor
	
	@Test(priority = 3)
	public void selectQuoteToAccount() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Quote To Account-Started ####");
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToAccountsPage().isPageLoaded());
		page.GetInstance1(CPQAccountsPage.class).addQuoteToAccount("1000056438");
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Quote To Account-Ended ####");
		
	}
	
	@Test(priority = 4)
	public void selectSoldToAccount() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Sold To Account-Started ####");
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToOpportunityAndQuoteInfoPage()
				.isOpportunity_QuoteInfoPageLoaded());
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToAccountsPage().isPageLoaded());
		page.GetInstance1(CPQAccountsPage.class).addSoldToAccount("1000065350");
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Sold To Account-Ended ####");
	}
	
	@Test(priority = 5)
	public void selectConatactFromRefreshContacts() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Contact from Refresh Contacts-Started ####");
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToOpportunityAndQuoteInfoPage()
				.isOpportunity_QuoteInfoPageLoaded());
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToAccountsPage().isPageLoaded());
		page.GetInstance1(CPQAccountsPage.class).addContactsFromAccountsPage("STEPHANE GUILLON");
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Contact from Refresh Contacts-Ended ####");
	}
	
	
	
	

	
/*	
	@Test(priority = 3)
	public void selectSoldToAccount() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Sold To Account-Started ####");
		
		
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Sold To Account-Ended ####");
	}


	@Test(priority = 4)
	public void selectQuoteToAccount() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void selectConatactFromRefreshContacts() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void addContactFromContacts() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void addAttachments() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void addNotes() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void uplaodProductsFromCSV() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void addProductsfromTextFile() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void addProductsFromLineItemInformationTab() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void addProductsFromProductLines() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void addProductsFromAdhocItems() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void addGCRProductsFromMetaSelector() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void saveAndPrice() throws InterruptedException {
		
	}
	
	@Test(priority = 4)
	public void submitQuote() throws InterruptedException {
		
	}*/
	
	

}
