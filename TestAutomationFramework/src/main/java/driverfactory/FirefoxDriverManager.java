package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends LocalDriverManager  {
   WebDriver driver;
	@Override
	public WebDriver createDriver() {
		WebDriverManager.firefoxdriver().arch64().setup();
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Executables/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile ffprofile=new FirefoxProfile();
        ffprofile.setPreference("browser.autofocus", true);
        capabilities.setCapability(FirefoxDriver.PROFILE, ffprofile);
        capabilities.setCapability("marionette", true);
        return driver = new FirefoxDriver(options);
	}
	
	

}
