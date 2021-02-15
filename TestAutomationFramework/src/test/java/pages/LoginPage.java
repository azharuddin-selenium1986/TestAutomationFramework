package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import core.BasePage;
import logger.LOGGER;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="q")
	private WebElement textbox;
	public void enterText(String text) {
		try {
			uiAction.typeText(textbox, text);
			extentLogger.addInfo("Enter Text as "+text);
			LOGGER.logInfo("LoginPage","Enter Text as "+text);
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError("LoginPage",ex.getMessage());
		}
		
	}
	
	

}
