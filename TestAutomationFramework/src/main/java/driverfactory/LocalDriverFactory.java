package driverfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LocalDriverFactory {

	public static WebDriver createWebDriverInstance(String browser) {
		WebDriver driver = null;
		switch (browser) {
		case "chrome":
			ChromeDriverManager chromeDriver = new ChromeDriverManager();
			driver = chromeDriver.createDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		case "firefox":
			FirefoxDriverManager firefoxDriverManager = new FirefoxDriverManager();
			driver = firefoxDriverManager.createDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		case "ie":
			IEDriverManager IEDriver = new IEDriverManager();
			driver = IEDriver.createDriver();
			break;
		case "edge":
			break;
		case "safari":
			SafariDriverManager safari = new SafariDriverManager();
			driver = safari.createDriver();
			break;
		case "lambdatest":
			LambdaTestDriverManager lambtatest = new LambdaTestDriverManager();
			driver = lambtatest.createDriver();
			break;
		case "browserstack":
			BrowserstackDriverManager browserstack = new BrowserstackDriverManager();
			driver = browserstack.createDriver();
			break;
		case "saucelab":
			SaucelabDriverManager saucelab = new SaucelabDriverManager();
			driver = saucelab.createDriver();
			break;
		case "aws":
			break;
		case "azure":
			break;
		case "googleCloud":
			
			break;
		case "LocalGrid":
			break;
		default:
			chromeDriver = new ChromeDriverManager();
			driver = chromeDriver.createDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		}

		return driver;
	}

	static WebDriver createRemoteWebDriverInstance(DriverType type) {
		WebDriver driver = null;
		switch (type) {
		case SAUCELABS:
			break;
		case BROWSERSTACK:
			break;
		default:

			break;
		}
		return driver;
	}

	public static AndroidDriver<MobileElement> createMobileInstance(DriverType type) {
		AndroidDriver<MobileElement> mobileDriver = null;
		switch (type) {
		case ANDROID:
			ANDROID_DRIVER androidDriver = new ANDROID_DRIVER();
			mobileDriver = androidDriver.createDriver();
		default:

			break;
		}
		return mobileDriver;
	}
}
