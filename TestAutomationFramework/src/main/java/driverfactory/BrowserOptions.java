package driverfactory;

import org.aspectj.weaver.loadtime.Options;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserOptions {
	static DesiredCapabilities capabilities = new DesiredCapabilities();	   
   public static ChromeOptions getChromeOptions(){
	   ChromeOptions options = new ChromeOptions();
	   //this argument should not hard coded
	    options.addArguments("test-type");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    return options.merge(capabilities);
   }
   
   
   
   public static ChromeOptions chromeWithExtension(){
	   return new ChromeOptions();
   }

  public static FirefoxOptions getFirefoxOptions(){
	  return new FirefoxOptions();
  }
  
  public static InternetExplorerOptions getIEOptions(){
	  return new InternetExplorerOptions();
  }
  
  public static SafariOptions getSafariOptions(){
	  SafariOptions options = new SafariOptions();
	  options.setCapability(SafariOptions.CAPABILITY, options);
	  
	  
	  return new SafariOptions();
  }
   
  
  public static EdgeOptions getEdgeOptions(){
	  return new EdgeOptions();
  }
   
 public static OperaOptions getOperaOptions(){
	 return new OperaOptions();
 }
	
 
	
	
	
	
	
	
	
	
	
	
	

}
