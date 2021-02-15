/*package adminFeature;

import org.testng.annotations.Test;
import adminPages.AdministrationPage;
import adminPages.LandingPage;
import adminPages.LoginPage;

public class AdminTest1 extends BaseTest {

	LoginPage login;
    AdministrationPage adminPage;
	@Test(priority = 1)
	public void loginToApplication() throws InterruptedException {
		
		login = new LoginPage(driverManager.getWebDriver());
		login.enterUsername("SESA345000").enterPassword("SCH123").clickLoginButton().waitForLandingPage()
				.clickOnUserMenuButton().waitForUsermenus().clickOnMenu("Admin");
		adminPage= new AdministrationPage(driver);
		adminPage.waitForForAdminPage().clickOnInternalUserLink().waitForUserAdminstartionList().clickOnExportButton();
		Thread.sleep(30000);
		
		adminPage= new AdministrationPage(driver);
		adminPage.waitForForAdminPage().clickOnInternalUserLink().waitForUserAdminstartionList().clickOnImportButton();
		Thread.sleep(30000);
		
		
		new LandingPage(driver).clickOnUserMenuButton().clickOnMenu("Sign Out");
		Thread.sleep(10000);

	}

}
*/