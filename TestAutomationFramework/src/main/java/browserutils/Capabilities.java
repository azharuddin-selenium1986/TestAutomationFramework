package browserutils;
import org.openqa.selenium.remote.DesiredCapabilities;

import configFactory.CONFIG;
import configFactory.ProjectConfig;
import configFactory.ProjectConfigType;
import configFactory.ProjectFactory;


public class Capabilities {
	private static DesiredCapabilities capabilities;
	private static ProjectConfig config = ProjectFactory.getConfig(ProjectConfigType.INITCONFIG);
	private String platform;
	private String browserName;
	private String version;
	private String name;
	private String os;
	private String osVersion;
	
	public String getOSVersion() {
		this.osVersion = config.getProperty("osVersion", CONFIG.CLOUDBROWSERS);
		return osVersion;
	}


	public String getOS() {
		this.os = config.getProperty("os", CONFIG.CLOUDBROWSERS);
		return os;
	}

	public String getPlatform() {
		this.platform = config.getProperty("platform", CONFIG.CLOUDBROWSERS);
		return platform;
	}

	public String getBrowserName() {
		this.browserName = config.getProperty("browserName", CONFIG.CLOUDBROWSERS);
		return browserName;
	}
	
	public String getBrowserVersion() {
		this.version = config.getProperty("version", CONFIG.CLOUDBROWSERS);
		return version;
	}


	public String getName() {
		this.name =config.getProperty("name", CONFIG.CLOUDBROWSERS);
		return name;
	}
	
	public synchronized DesiredCapabilities getCapabilities() {
		capabilities=new DesiredCapabilities();
		capabilities.setCapability("os",getOS());
		capabilities.setCapability("osVersion",getOSVersion());
		capabilities.setCapability("browserName", getBrowserName());
		capabilities.setCapability("version", getBrowserVersion());
		capabilities.setCapability("name", getName());
		return capabilities;
		
		
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "OS X");
		browserstackOptions.put("osVersion", "Big Sur");
		browserstackOptions.put("local", "false");
		capabilities.setCapability("bstack:options", browserstackOptions);
		return capabilities;*/
	}
	
	public synchronized DesiredCapabilities getSauceLabCapabilities() {
		capabilities=new DesiredCapabilities();
		capabilities.setCapability("platform","Windows 10");
		//capabilities.setCapability("osVersion",getOSVersion());
		capabilities.setCapability("browserName", getBrowserName());
		capabilities.setCapability("version", getBrowserVersion());
		capabilities.setCapability("name", getName());
		return capabilities;
		
		
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "OS X");
		browserstackOptions.put("osVersion", "Big Sur");
		browserstackOptions.put("local", "false");
		capabilities.setCapability("bstack:options", browserstackOptions);
		return capabilities;*/
	}

	

}
