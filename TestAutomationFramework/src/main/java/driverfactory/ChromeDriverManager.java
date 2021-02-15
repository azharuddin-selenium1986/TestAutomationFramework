package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends LocalDriverManager  {
   WebDriver driver;
	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		if(System.getProperty("os.name").contains("window")) 
		{
		WebDriverManager.chromedriver().setup();	
			
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Executables/chromedriver.exe");
		
		}else{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedrivernew.exe");
		}
		return driver= new ChromeDriver(BrowserOptions.getChromeOptions());
	}
	
	

}
