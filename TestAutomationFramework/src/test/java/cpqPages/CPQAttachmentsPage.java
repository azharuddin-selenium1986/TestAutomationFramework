package cpqPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import baseinterfaces.IAction.clickType;
import core.BasePage;
import logger.LOGGER;

public class CPQAttachmentsPage extends BasePage {

	public CPQAttachmentsPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="upload_user_file")
	private WebElement browseInput;
	
	@FindBy(css="button[id='upload-btn']")
	private WebElement uploadButton;
	
	@FindBy(xpath="//table[@id='documentTable-all']/tbody/tr/td/a")
	List<WebElement> listOfUploadedFiles;
	
	@FindBy(xpath="//span[@class='schform_error']")
	List<WebElement> attachmentErrorList;
	
	
private void addFileUsingBrowseButton(String filename){
		
		try{
			uiAction.enterText(browseInput,filename);
			extentLogger.addInfo("Browse File "+filename +" To Upload");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Browse File "+filename +" To Upload");
		}catch(Exception ex){
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), "Browse button is not interactable to browse file.",ex.getMessage());
			Assert.fail("Browse button is not interactable to browse file.");
		}
	}
	
	public void addMultipleFilesusingBrowseButton(String fileNames){
		String files[]= fileNames.split(",");
		for(int i=0;i<files.length;i++){
			String filepath = System.getProperty("user.dir") +"\\" +"Uploads\\" + files[i];
			this.addFileUsingBrowseButton(filepath);
			this.clickOnUploadButton();
			
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForElementToBeDisplayed(attachmentErrorList.get(0));
			if(attachmentErrorList.size()>0){
				test.log(LogStatus.WARNING, attachmentErrorList.get(0).getText());
				test.log(LogStatus.WARNING, test.addScreenCapture(addScreenshot()));
			}
		}
		
	}
	
	
	private void clickOnUploadButton(){
		
		try{
			uiAction.click(uploadButton,clickType.NORMAL_CLICK);
			extentLogger.addInfo("Click on Upload Button.");
		}catch(Exception ex){
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),"Upload Button is not intercatable to click or not visible to click.",ex.getMessage());
			Assert.fail("Upload Button is not intercatable to click or not visible to click.");
		}
	}
	
	private void verifyFileHasbeenAdded(String fileName){
		try{
			int fileindex=0;
			for(int i=0;i<listOfUploadedFiles.size();i++){
				 if(listOfUploadedFiles.get(i).getText().equals(fileName)){
					 fileindex=i;
					 break;
				 }
				}
				Assert.assertEquals(fileName,listOfUploadedFiles.get(fileindex).getText());
				extentLogger.addInfo("Uploaded File "+fileName+" is present in view Attachment Section.");
				test.log(LogStatus.PASS, test.addScreenCapture(addScreenshot()));
		}catch(Exception ex){
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"Uploaded File "+fileName+" is not present in view Attachment Section.",ex.getMessage());
			Assert.fail("Uploaded File "+fileName+" is not present in view Attachment Section.");
		}
		
	}
	
	private void verifyMultipleFilesHasbeenAdded(String filenames){
		try{
			
			String files[] = filenames.split(",");
			for(int i=0;i<listOfUploadedFiles.size();i++){
				if(listOfUploadedFiles.get(i).getText().equals(files[i])){
				 extentLogger.addPass("File "+files[i]+" has been added successfully.");
				 LOGGER.logInfo(this.getClass().getSimpleName(),"File "+files[i]+" has been added successfully.");
				}
				}
			test.log(LogStatus.INFO, test.addScreenCapture(addScreenshot()));
		}catch(Exception ex){
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(),
					"Uploaded File is not present in view Attachment Section.",ex.getMessage());
			Assert.fail("Uploaded File is not present in view Attachment Section.");
		}
	}
	
	
	
	
	
	//Business Rules
	public void addSingleAttachment(String fileName) {
		String filepath = System.getProperty("user.dir") + "/Uploads/" + fileName;
		this.addFileUsingBrowseButton(filepath);
		this.clickOnUploadButton();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.verifyFileHasbeenAdded(fileName);
	}
	
	public void addMultipleAttachment(String fileNames) {
	    this.addMultipleFilesusingBrowseButton(fileNames);
		this.verifyMultipleFilesHasbeenAdded(fileNames);
	}

	public boolean isPageLoaded() {
		return isPageLoaded(browseInput);
	}

}
