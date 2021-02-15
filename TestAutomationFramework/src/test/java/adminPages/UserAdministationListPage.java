package adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAdministationListPage {
	WebDriver driver;
	public UserAdministationListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="export")
	private WebElement exportButton;
	
	@FindBy(id="import")
	private WebElement importButton;

	public UserAdministationListPage waitForUserAdminstartionList() {
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(exportButton));
		return this;
	}
	
	public void clickOnExportButton() {
		exportButton.click();
	}
	
	public void clickOnImportButton() {
		importButton.click();
	}
}
