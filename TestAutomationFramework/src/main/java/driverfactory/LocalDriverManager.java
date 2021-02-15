package driverfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class LocalDriverManager {

	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	protected abstract WebDriver createDriver(); 
    public static WebDriver getDriver() {
        return webDriver.get();
    }
 
    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
	
}
