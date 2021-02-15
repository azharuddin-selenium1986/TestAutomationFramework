package adminPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	@FindBy(css="button[id='cpq-usermenu']")
	private WebElement usermenuButton;
	
	@FindBy(css="ul[id='cpqUserMenu']>li>a")
	private List<WebElement> listOfMenus;
	
	

	 WebDriver driver; 
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public LandingPage clickOnUserMenuButton() {
		usermenuButton.click();
		return this;
	}



	public LandingPage waitForUsermenus() {
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOfAllElements(listOfMenus));
		return this;
		
	}
	
	public void clickOnMenu(String menuName) {
		for(int i=0;i<listOfMenus.size();i++) {
			if(listOfMenus.get(i).getText().equals(menuName)) {
				listOfMenus.get(i).click();
				break;
			}
		}
	}

}
