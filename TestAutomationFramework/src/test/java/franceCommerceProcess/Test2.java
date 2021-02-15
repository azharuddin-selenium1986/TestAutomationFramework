package franceCommerceProcess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.TestBase;
import pages.LoginPage;

public class Test2 extends TestBase{

	@Test(priority=1)
	public void test() throws InterruptedException{
       page.GetInstance1(LoginPage.class).navigateToApplication("https://google.com");
 
	}
	

	
	@Test(priority=2)
	public void test11() throws InterruptedException{
		
		 page.GetInstance1(LoginPage.class).enterText("Azhar");
        
	}
	
	@Test(priority=3)
	public void test1() throws InterruptedException{
		Thread.sleep(2000);
		page.GetInstance1(LoginPage.class).enterText("Saba");
       Assert.assertEquals("Azhar", "Saba");
	}
}
