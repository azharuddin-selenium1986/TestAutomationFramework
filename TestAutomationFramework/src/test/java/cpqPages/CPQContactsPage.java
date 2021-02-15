package cpqPages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import core.BasePage;
import logger.LOGGER;

public class CPQContactsPage extends BasePage {

	public CPQContactsPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="button[title='Add Row']")
	private WebElement addContactIcon;
	
	@FindBy(css="table[aria-label='Opportunity Contacts Array']>tbody>tr")
	List<WebElement> contactRows;
	
	@FindBy(xpath="//input[contains(@id,'contactName')]")
	private WebElement contactNameInputbox;
	
	@FindBy(xpath="//input[contains(@id,'accountName')]")
	private WebElement accountNameInputbox;
	
	@FindBy(xpath="//input[contains(@id,'emailAddress')]")
    private WebElement emailAddressInputbox;
	
	@FindBy(xpath="//input[contains(@id,'role_Contact')]")
    private WebElement roleInputbox;
	
	@FindBy(xpath="//input[contains(@id,'phoneNumber')]")
    private WebElement phoneNumberInputbox;
	
	@FindBy(xpath="//ul[contains(@id,'accountType')]/li/div")
	List<WebElement> listOfAccountType;
	
	int count;
	public void verifyAddedContact(String contact){
		try {
			List<WebElement> contacts=driver.findElements(By.xpath("//table/tbody/tr/td[contains(@id,'opportunityContactsDataSet')][1]"));
			if(contacts.size()==0){
				throw new Exception();
			}else{
				System.out.println(contacts.get(0).getText());
				extentLogger.addPass(contact+" contact has been added");
				LOGGER.logInfo(this.getClass().getSimpleName(), contact+" contact has been added");
				test.log(LogStatus.INFO, test.addScreenCapture(addScreenshot()));
			}
		} catch (Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), contact+" contact is not added",ex.getMessage());
			Assert.fail(contact+" contact is not added");
		}
	}
	public boolean isPageLoaded() {
		return isPageLoaded(addContactIcon);
		
	}
	
	private void clickOnAddContactPlusIcon(){
		try{
			isElementVisible(addContactIcon);
			isElementInteractable(addContactIcon);
			uiAction.click(addContactIcon,"JSClick");
			extentLogger.addInfo("Click On add Contact Icon.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click On add Contact Icon.");
			Thread.sleep(6000);
		}catch(Exception ex){
			LOGGER.logError(this.getClass().getSimpleName(),"Failed to click on '+' icon to add contact or '+' icon is interactable or visible to click",ex.getMessage());
		    Assert.fail("Failed to click on '+' icon to add contact or '+' icon is interactable or visible to click");
		}
	}
	
	private boolean isContactRowCreated(){
		boolean istrue=false;
		try{
			isAllElementVisible(contactRows);
			if(contactRows.size()>0){
				istrue=true;
			}
		}catch(Exception ex){
			istrue=false;
			LOGGER.logError(this.getClass().getSimpleName(),"Contact Row has not been added while click on '+' icon ",ex.getMessage());
		    Assert.fail("Failed to click on '+' icon to add contact or '+' icon is interactable or visible to click");
		}
		return istrue;
	}
	
	private void clickOnContactNameColumn() {
		try {
			WebElement contactNameColumn=contactRows.get(0).findElement(By.cssSelector("td:nth-child(2)"));
			uiAction.click(contactNameColumn, "JSClick");
			Thread.sleep(3000);
			extentLogger.addInfo("Click on Contact Name Column to enter contact.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Contact Name Column to enter contact.");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logInfo(this.getClass().getSimpleName(), "Failed to Click on Contact Name Column to enter contact.");
			Assert.fail( "Failed to Click on Contact Name Column to enter contact.");
		}
	
	}
	
	private void addContactName(String contactName){
		try {
			uiAction.enterTextUsingJavaScript(contactNameInputbox,contactName);
			extentLogger.addInfo("Enter Contact name as "+contactName);
			LOGGER.logInfo(this.getClass().getSimpleName(), "Enter Contact name as "+contactName);
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logInfo(this.getClass().getSimpleName(), "Failed to Enter Contact Name in Contact Name Textbox.");
			Assert.fail("Failed to Enter Contact Name in Contact Name Textbox.");
		}
		}
	
	
	private void clickOnAccountNameColumn() {		
		try {
			WebElement accountNameColumn=contactRows.get(0).findElement(By.cssSelector("td:nth-child(3)"));
			uiAction.click(accountNameColumn, "JSClick");
			Thread.sleep(3000);
			extentLogger.addInfo("Click on Account Name Column to enter Account Name.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Account Name Column to enter Account Name.");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logInfo(this.getClass().getSimpleName(), "Failed to Click on Account Name Column to enter Account Name.");
			Assert.fail( "Failed to Click on Account Name Column to enter Account Name.");
		}
	
	}

	private void addAccountName(String accountName){
		
		try {
			uiAction.enterTextUsingJavaScript(accountNameInputbox,accountName);	
			extentLogger.addInfo("Enter Account name as "+accountName);
			LOGGER.logInfo(this.getClass().getSimpleName(), "Enter Account name as "+accountName);
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Enter Account Name in Account Name Textbox.",ex.getMessage());
			Assert.fail("Failed to Enter Account Name in Account Name Textbox.");
		}
	}
	
	
	private void clickOnEmailAddressColumnName() {
		try {
			WebElement emailAddressColumn=contactRows.get(0).findElement(By.cssSelector("td:nth-child(4)"));
			uiAction.click(emailAddressColumn, "JSClick");
			Thread.sleep(3000);
			extentLogger.addInfo("Click on Email Address Column name  to enter Email Address.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Email Address Column name  to enter Email Address.");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Click on Email Address Column name to enter Email Address.",ex.getMessage());
			Assert.fail("Failed to Click on Email Address Column name to enter Email Address.");
		}
	}
	
	private void addEmailAddress(String emailAddress){
		try {
			uiAction.enterTextUsingJavaScript(emailAddressInputbox,emailAddress);		
			extentLogger.addInfo("Enter Email Address  as "+emailAddress);
			LOGGER.logInfo(this.getClass().getSimpleName(), "Enter Email Address  as "+emailAddress);
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), "Failed to Enter Email Address in Email Address Textbox.",ex.getMessage());
			Assert.fail("Failed to Enter Email Address in Email Address Textbox.");
		}
	}
	
	private void clickOnRoleColumn() {
		try {
			WebElement roleColumn=contactRows.get(0).findElement(By.cssSelector("td:nth-child(6)"));
			uiAction.click(roleColumn, "JSClick");
			Thread.sleep(3000);
			extentLogger.addInfo("Click on Role Column to enter Role.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Role Column to enter Role.");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Click on Role Column name to enter role.",ex.getMessage());
			Assert.fail("Failed to Click on Role Column name to enter role.");
		}
	}
	
	private void addRole(String role){
	   
		try {
			uiAction.enterTextUsingJavaScript(roleInputbox,role);			
			extentLogger.addInfo( "Enter Role name as "+role);
			LOGGER.logInfo(this.getClass().getSimpleName(),  "Enter Role name as "+role);
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), "Failed to Enter Role Name in role Textbox.",ex.getMessage());
			Assert.fail("Failed to Enter Role Name in role Textbox.");
		}
	}
	
	private void clickOnPhoneNumberColumn() {
		try {
			WebElement phoneNumberColumn=contactRows.get(0).findElement(By.cssSelector("td:nth-child(5)"));
			uiAction.click(phoneNumberColumn, "JSClick");
			Thread.sleep(3000);
			extentLogger.addInfo("Click on Phone Number Column to add phone number.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Phone Number Column to add phone number.");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Click on Phone Column name to enter phone Number.",ex.getMessage());
			Assert.fail("Failed to Click on Phone Column name to enter phone Number.");
		}
		
	}
	private void addPhoneNumber(String phoneNumber){
	
		try {
			uiAction.enterTextUsingJavaScript(phoneNumberInputbox,phoneNumber);			
			extentLogger.addInfo("Enter Phone number as "+phoneNumber);
			LOGGER.logInfo(this.getClass().getSimpleName(),"Enter Phone number as "+phoneNumber);
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), "Failed to Enter Phone Number in PhoneNumber Textbox.",ex.getMessage());
			Assert.fail("Failed to Enter Phone Number in PhoneNumber Textbox.");
		}
	}
	
	
	private void clickOnAccountTypeColumn() {
		try {
			WebElement accountTypeColumn=contactRows.get(0).findElement(By.cssSelector("td:nth-child(8)"));
			uiAction.click(accountTypeColumn, "JSClick");
			Thread.sleep(3000);
			extentLogger.addInfo("Click on Account Type Column to Select account type.");
			LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Account Type Column to Select account type.");
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), 
					"Failed to Click on Account Type Column name to select account type.",ex.getMessage());
			Assert.fail("Failed to Click on Account Type Column name to select account type.");
		}
	}
	private void addAccountType(String accoutType){
		try {
			uiAction.enterTextUsingJavaScript(phoneNumberInputbox,accoutType);			
			extentLogger.addInfo("Select Account type as "+accoutType);
			LOGGER.logInfo(this.getClass().getSimpleName(),"Select Account type as "+accoutType);
		}catch(Exception ex) {
			extentLogger.addFail(ex.getMessage());
			LOGGER.logError(this.getClass().getSimpleName(), "Failed to Select Account Type.",ex.getMessage());
			Assert.fail("Failed to Select Account Type.");
		}
	}
	
public void addContact(String contactName,String accountName,String emailAddress,String role,String accoutType,String phoneNumber){
	this.clickOnAddContactPlusIcon();
	Assert.assertEquals(true, isContactRowCreated());
	this.clickOnContactNameColumn();
	this.addContactName(contactName);
	this.clickOnAccountNameColumn();
	this.addAccountName(accountName);
	this.clickOnEmailAddressColumnName();
	this.addEmailAddress(emailAddress);
	this.clickOnRoleColumn();
	this.addRole(role);
	this.clickOnPhoneNumberColumn(); 
	this.addPhoneNumber(phoneNumber);
	this.clickOnAccountTypeColumn();
	this.addAccountType(accoutType);
}
	

}
