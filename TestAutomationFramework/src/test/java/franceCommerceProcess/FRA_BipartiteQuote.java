package franceCommerceProcess;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import core.BasePage;
import core.TestBase;
import cpqPages.CPQAccountsPage;
import cpqPages.CPQHeadersPage;
import cpqPages.CPQLoginPage;
import cpqPages.Opportunity_QuoteInfoPage;
import cpqPages.TabNavigationPage;
import managers.ExtentTestManager;

public class FRA_BipartiteQuote extends TestBase {
	/**
	 * FRA_Bipartite Quote
	 * create Quote,add line items using quick key,verify  
	 */

	@Test(priority = 1)
	public void loginToApplicationAnndNavigateCPQDashboardPage() throws InterruptedException {
		ExtentTestManager.getTest().setDescription("France BiPartite Quote2Order within CPQ");
		page.GetInstance1(BasePage.class).navigateToApplication();
		page.GetInstance1(CPQLoginPage.class).enterCPQUsername("SELENIUM_FRA03_Sales_Rep");
	}

	@Test(priority = 2,enabled=false)
	public void enterOpportunityAndQuoteInfo() throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "#### Fill Oppotunity and Quote Info-Started ####");
			Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToOpportunityAndQuoteInfoPage()
					.isOpportunity_QuoteInfoPageLoaded());
			page.GetInstance1(Opportunity_QuoteInfoPage.class).setQuoteName("testQuote").clickOnSPADropdown()
					.selectSPAType("None").clickOnPurchasingChannelDropDown()
					.selectpurchasingChannel("Direct purchasing to Schneider").waitForProgress();
			ExtentTestManager.getTest().log(LogStatus.INFO, "#### Fill Oppotunity and Quote Info-Ended ####");
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}
	}
	//Direct purchasing to Schneider
	//Purchasing through a Distributor
	
	
	@Test(priority = 3,enabled=false)
	public void selectSoldToAccount() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Sold To Account-Started ####");
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToOpportunityAndQuoteInfoPage()
				.isOpportunity_QuoteInfoPageLoaded());
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToAccountsPage().isPageLoaded());
		page.GetInstance1(CPQAccountsPage.class).addSoldToAccount("1000056438");
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Sold To Account-Ended ####");
	}
	
	@Test(priority = 4,enabled=false)
	public void selectConatactFromRefreshContacts() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Contact from Refresh Contacts-Started ####");
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToOpportunityAndQuoteInfoPage()
				.isOpportunity_QuoteInfoPageLoaded());
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToAccountsPage().isPageLoaded());
		page.GetInstance1(CPQAccountsPage.class).addContactsFromAccountsPage("ALEXIS BAPTISTE");
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Contact from Refresh Contacts-Ended ####");
	}
	
	
	@Test(priority = 5,enabled=false)
	public void verifyAddedContact() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Verify Added Contact from Refresh Contacts-Started ####");
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToContactsPage().isPageLoaded());
		page.GetInstance1(TabNavigationPage.class).navigateToContactsPage().verifyAddedContact("ALEXIS BAPTISTE");
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Verify Added Contact from Refresh Contacts-Ended ####");
	}
	
	
	@Test(priority =6 ,enabled=false)
	public void addAttachments() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Attachment-Started ####");
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToAttachmentsPage().isPageLoaded());
		page.GetInstance1(TabNavigationPage.class).navigateToAttachmentsPage().addMultipleAttachment("Attach doc.docx");
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Attachment-Ended ####");
	}
	
	
	@Test(priority =7,enabled=false)
	public void addNotes() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Notes-Started ####");
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToNotesPage().isPageLoaded());
		page.GetInstance1(TabNavigationPage.class).navigateToNotesPage().addNotes("General,Order Management","General Notes,order notes");
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Notes-Ended ####");
	}
	
	
	@Test(priority = 8,enabled=false)
	public void uplaodProductsFromCSV() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Upload Product Using CSV -Started ####");
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).
				navigateToUploadCSVProductsPage().browseFile("standardProducts").clickOnUploadButton().isProductUploadedUsingCSV());
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Upload Product Using CSV -Ended ####");
	}
	
	
	@Test(priority = 9,enabled=false)
	public void saveAndPrice() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Save & Price-Started ####");
		page.GetInstance1(TabNavigationPage.class).navigateToLineItemInformationPage();
		page.GetInstance1(CPQHeadersPage.class).saveAndPrice();
		page.GetInstance1(TabNavigationPage.class).navigateToLineItemInformationPage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Save & Price -Ended ####");
	}
	
	@Test(priority = 10,enabled=false)
	public void addProductsfromTextFile() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### addProductsfromTextFile-Started ####");
		page.GetInstance1(TabNavigationPage.class).
		navigateToUploadCSVProductsPage().
		uploadProductUsingTextFile("Upload_txtFile_Products_Malaysia").clickOnTextProductUploadButton();
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### addProductsfromTextFile-Ended ####");
	}
	
	
	/*@Test(priority = 6)
	public void addContactsFromContactsPage() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Contact from Contacts Page-Started ####");
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToOpportunityAndQuoteInfoPage()
				.isOpportunity_QuoteInfoPageLoaded());
		Assert.assertTrue(page.GetInstance1(TabNavigationPage.class).navigateToContactsPage().isPageLoaded());
		page.GetInstance1(TabNavigationPage.class).navigateToContactsPage().addContact("Test", "1111111", "azhar.sqa@gmail.com", "SalesRep", "Bill TO", "123345677");
		ExtentTestManager.getTest().log(LogStatus.INFO, "#### Add Contact from Contacts Page-Ended ####");
	}*/
	
	
	

	
/*	
	


	
	
	
	
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
