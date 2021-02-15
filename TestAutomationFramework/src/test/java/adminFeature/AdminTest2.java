/*package adminFeature;

import org.testng.annotations.Test;

import adminPages.AdministrationPage;
import adminPages.DataTablePage;
import adminPages.LoginPage;

public class AdminTest2 extends BaseTest {

	LoginPage login;
    AdministrationPage adminPage;
	@Test(priority = 1)
	public void loginToApplication() throws InterruptedException {
		
		login = new LoginPage(driverManager.getWebDriver());
		login.enterUsername("SESA345000").enterPassword("SCH123").clickLoginButton().waitForLandingPage()
				.clickOnUserMenuButton().waitForUsermenus().clickOnMenu("Admin");

		adminPage= new AdministrationPage(driver);
		adminPage.waitForForAdminPage().clickOnDataTableLink().waitForDataTablePage().getListOfDatatables();
		new DataTablePage(driver).getListOfTables();
		
		Thread.sleep(30000);
	   

	}
	
	

}
*/