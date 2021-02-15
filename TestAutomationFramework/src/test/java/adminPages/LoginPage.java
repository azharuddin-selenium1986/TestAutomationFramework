package adminPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver ;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement usernameTextbox;
	@FindBy(id = "psword")
	private WebElement passwordTextbox;
	
	@FindBy(id="log_in")
	private WebElement loginButton;
	
	@FindBy(css="div[id='cpq-header-tb']>a[title='Home']")
	private WebElement landingPageHomeButton;
	
	
	public LoginPage enterUsername(String username) {
	  new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(passwordTextbox));	
	   usernameTextbox.clear();
	   usernameTextbox.sendKeys(username);
	   return this;
	}
	
	public LoginPage enterPassword(String password) {
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
		   return this;
		}
		

	public LoginPage clickLoginButton() {
		   if(loginButton.isEnabled()&&loginButton.isDisplayed()) {
			   loginButton.click();
		   }
		   return this;
		}
		
	public LandingPage waitForLandingPage() {
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(landingPageHomeButton));
		return new LandingPage(driver);
	}
	

}
