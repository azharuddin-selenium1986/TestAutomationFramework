package cpqPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import core.BasePage;

public class FranceQuotation extends BasePage implements QuoteTemplate{

	public FranceQuotation(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	@Override
	public void setQuoteName(String quoteName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectSPAtype(String spaType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectPurchasingChannel(String purchasingChannel) {
		// TODO Auto-generated method stub
		
	}
	

}
