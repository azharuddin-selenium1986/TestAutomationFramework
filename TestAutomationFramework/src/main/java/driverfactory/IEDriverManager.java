package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IEDriverManager extends LocalDriverManager  {
   WebDriver driver;
	@SuppressWarnings("deprecation")
	@Override
	public WebDriver createDriver() {
		//System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/Executables/IEDriverServer.exe");
		WebDriverManager.iedriver().arch32().setup();
		/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		capabilities.setCapability("ignoreZoomSetting", true);
		capabilities.setCapability("nativeEvents", false); */ 
		driver=new InternetExplorerDriver();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	

}
