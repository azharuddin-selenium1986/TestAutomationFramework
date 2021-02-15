package cpqPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import baseinterfaces.IAction.clickType;
import core.BasePage;
import logger.LOGGER;
import utility.EncryptUtils;

public class CPQLoginPage extends BasePage {

	public CPQLoginPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="username")
	private WebElement cpqUsernameTextbox;
	
	@FindBy(id="username1")
	private WebElement cpqUsernameTextbox1;
	
	@FindBy(id="psword")
	private WebElement cpqPasswordTextbox;
	@FindBy(id="log_in")
	private WebElement cpaLoginButton;
	
	public CPQLoginPage enterCPQUsername(String username) {
		
		waitForElementToBeDisplayed(cpqUsernameTextbox);
		uiAction.typeText(cpqUsernameTextbox1, username);
	/*	
		try {
			waitForElementToBeDisplayed(cpqUsernameTextbox);
			uiAction.typeText(cpqUsernameTextbox1, username);
			extentLogger.addInfo("Enter Username as "+EncryptUtils.encodeString(username));
			LOGGER.logInfo(this.getClass().getSimpleName(), "Enter Username as "+EncryptUtils.encodeString(username));
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			Assert.fail("Username Text box is not interactable | Failed to Enter Username");
		}*/
		return GetInstance1(CPQLoginPage.class);
	}
	
	public CPQLoginPage enterPassword(String password) {
		try {
			uiAction.typeText(cpqPasswordTextbox, password);
			extentLogger.addInfo("Enter Password as "+EncryptUtils.encodeString(password));
			LOGGER.logInfo(this.getClass().getSimpleName(), "Enter Password as "+EncryptUtils.encodeString(password));
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			extentLogger.addFail("Password Text box is not interactable | Failed to Enter Password");
			Assert.fail("Password Text box is not interactable | Failed to Enter Password");
		}
		return GetInstance1(CPQLoginPage.class);
	}
	
	public CPQLandingPage clickLoginButton() {
		try {
			uiAction.click(cpaLoginButton,clickType.NORMAL_CLICK);
			extentLogger.addInfo("Click on Login Button.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Login Button.");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			extentLogger.addFail("login Button is not interactable | Failed to Click on Login Button");
			Assert.fail("Login Button is not interactable | Failed to click Login Button.");
		}
		return GetInstance1(CPQLandingPage.class);
	}

}
 
