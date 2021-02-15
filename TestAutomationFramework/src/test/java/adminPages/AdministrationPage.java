package adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdministrationPage {
	
	WebDriver driver;

	public AdministrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li/a[contains(text(),'Internal Users')]")
	private WebElement internalUserLink;
	
	@FindBy(xpath="//li/a[contains(text(),'Data Tables')]")
	private WebElement dataTableLink;
	
	public AdministrationPage waitForForAdminPage() {
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(internalUserLink));
		return this;
	}
	
	public UserAdministationListPage clickOnInternalUserLink() {
		internalUserLink.click();
		return new UserAdministationListPage(driver);
	}
	
	public DataTablePage clickOnDataTableLink() {
		dataTableLink.click();
		return new DataTablePage(driver);
	}
	
}
