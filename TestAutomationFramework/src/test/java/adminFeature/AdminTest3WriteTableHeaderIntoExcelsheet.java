/*package adminFeature;

import java.io.IOException;

import org.testng.annotations.Test;

import adminPages.AdministrationPage;
import adminPages.DataTablePage;
import adminPages.LoginPage;

public class AdminTest3WriteTableHeaderIntoExcelsheet extends BaseTest {

	LoginPage login;
    AdministrationPage adminPage;
	@Test(priority = 1)
	public void loginToApplication() throws InterruptedException, IOException {
		
		login = new LoginPage(driverManager.getWebDriver());
		login.enterUsername("SESA345000").enterPassword("SCH123").clickLoginButton().waitForLandingPage()
				.clickOnUserMenuButton().waitForUsermenus().clickOnMenu("Admin");

		adminPage= new AdministrationPage(driver);
		//adminPage.waitForForAdminPage().clickOnDataTableLink().waitForDataTablePage().getListOfTablesWithFolder();
		adminPage.waitForForAdminPage().clickOnDataTableLink().waitForDataTablePage().downloadAllDataTables();
		
		Thread.sleep(30000);
	   

	}
	
	

}
*/