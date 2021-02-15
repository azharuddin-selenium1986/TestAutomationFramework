package driverfactory;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import browserutils.Capabilities;
import configFactory.CONFIG;
import configFactory.ProjectConfig;
import configFactory.ProjectConfigType;
import configFactory.ProjectFactory;

import java.net.*;

public class LambdaTestDriverManager extends LocalDriverManager{

	 WebDriver driver;
	 private static ProjectConfig config = ProjectFactory.getConfig(ProjectConfigType.INITCONFIG);
		String URL ="https://" + config.getProperty("USERNAME", CONFIG.LAMBDATEST) + ":" + config.getProperty("AUTOMATE_KEY", CONFIG.LAMBDATEST) +config.getProperty("URL", CONFIG.LAMBDATEST);

	@Override
	protected WebDriver createDriver() {
		// TODO Auto-generated method stub
		try {
			driver= new RemoteWebDriver(new URL(URL),new Capabilities().getCapabilities());
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

}
