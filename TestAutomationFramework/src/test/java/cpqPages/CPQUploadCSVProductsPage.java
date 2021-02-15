package cpqPages;
import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import core.BasePage;
import driverfactory.LocalDriverManager;
import logger.LOGGER;
import managers.ExtentTestManager;
import utility.ReadTextFile;

public class CPQUploadCSVProductsPage extends BasePage {

	public CPQUploadCSVProductsPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "partUploadCSV_quote")
	WebElement browseCsv_ele;
	@FindBy(name = "upload_csv")
	WebElement uploadCsv_ele;
	@FindBy(css="button[name='csv_upload_ungrouped']")
	WebElement uploadCSV_mly;
	@FindBy(css="button[name='upload_products']")
	WebElement uploadProductsButton;
	@FindBy(id="partsUpload_quote")
	WebElement uplaodProductsTextarea;
	@FindBy(xpath="//button[@name='import_produits' or @name='upload_products']")
	WebElement uploadTextproductButton;

	
	public CPQUploadCSVProductsPage browseFile(String filename) {
		isPageLoaded(browseCsv_ele);
		File filePath = null;
		try {
			filePath = new File(System.getProperty("user.dir") + "\\Uploads\\" + filename + ".csv");
			System.out.println(filePath.getAbsolutePath()+" File Name is ");
			uiAction.typeText(browseCsv_ele, filePath.getAbsolutePath());
			extentLogger.addInfo("Browse File "+filePath.getAbsolutePath()+"Upload");
			LOGGER.logInfo(this.getClass().getSimpleName(),"Browse File "+filePath.getAbsolutePath()+"Upload");
			waitForFileBrowse();
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),"Failed to Browse csv File "+filePath.getAbsolutePath(),ex.getMessage());
		}
		return GetInstance1(CPQUploadCSVProductsPage.class);
		
	}
	
	public void waitForFileBrowse() throws InterruptedException {
		int value =LocalDriverManager.getDriver().findElements(By.cssSelector("a[id='partUploadCSV_quote-link']")).size();
		System.out.println(value+" Value");
		while(value==1) {
			Thread.sleep(5000);
			System.out.println("While Loop");
			wait.until(ExpectedConditions.attributeContains(LocalDriverManager.getDriver().
					findElements(By.cssSelector("a[id='partUploadCSV_quote-link']")).get(0), "href","https://uatschneider.bigmachines.com"));
			value=2;
		}
		
	}
	
	public CPQUploadCSVProductsPage clickOnUploadButton() {
		try {
			uiAction.click(uploadCsv_ele, "Normal Click");
			extentLogger.addInfo("Click on Uplaod CSV Button.");
			LOGGER.logInfo(this.getClass().getSimpleName(),"Click on Uplaod CSV Button.");
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),"Error occured uploading CSV file of products",ex.getMessage());
			Assert.fail("Error occured uploading CSV file of products");
		}
		return GetInstance1(CPQUploadCSVProductsPage.class);
	}
	
	public boolean isProductUploadedUsingCSV() {
		boolean flag =true;
		try {
			while(driver.findElement(By.cssSelector("div[id='headerCSVFilePartsUpload_quote']>table>tbody>tr>td>ul")).getText().contains("CSV Products Uploaded Successfully.")==false){
				//uiAction.click(uploadCsv_ele, "JSClick");
				WebElement element=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[id='headerCSVFilePartsUpload_quote']>table>tbody>tr>td>ul"))));
				if(element.getText().contains("CSV Products Uploaded Successfully.")){
					flag=true;
					break;
				}
			}
			extentLogger.addInfo(LocalDriverManager.getDriver().findElement(By.cssSelector("div[id='headerCSVFilePartsUpload_quote']>table>tbody>tr>td>ul")).getText());
			ExtentTestManager.getTest().log(LogStatus.PASS, test.addScreenCapture(addScreenshot()));
		}catch(Exception ex) {
			flag=false;
		}
		return flag;
	}
	
	
	public CPQUploadCSVProductsPage uploadProductUsingTextFile(String filename) {

		try{
			String filepath = System.getProperty("user.dir") + "\\Uploads\\" + filename + ".txt";
			List<String> results = ReadTextFile.readLines(filepath);
			for(String res:results){
				driver.findElement(By.xpath("//textarea[@id='partsUpload_quote']")).sendKeys(res);
				extentLogger.addInfo("Entered Product and Quantity in text area as "+ res);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//textarea[@id='partsUpload_quote']")).sendKeys(Keys.ENTER);
			}
		}catch(Exception ex){
			extentLogger.addFail(ex.getMessage());
		}
		
		return GetInstance1(CPQUploadCSVProductsPage.class);
	}
	
	public CPQUploadCSVProductsPage clickOnTextProductUploadButton() {
		try {
			uiAction.click(uploadCsv_ele, "Normal Click");
			extentLogger.addInfo("Click on Uplaod Button to upload products using text file.");
			LOGGER.logInfo(this.getClass().getSimpleName(),"Click on Uplaod Button to upload products using text file.");
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),"Error occured uploading Text file of products",ex.getMessage());
			Assert.fail("Error occured uploading Text file of products");
		}
		return GetInstance1(CPQUploadCSVProductsPage.class);
	}
}
