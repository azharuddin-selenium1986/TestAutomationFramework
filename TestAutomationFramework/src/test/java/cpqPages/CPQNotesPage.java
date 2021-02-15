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

public class CPQNotesPage extends BasePage {

	public CPQNotesPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}

	
	//Locators 
		 @FindBy(xpath="//input[@type='checkbox'][@value='true'][contains(@class,'oj-check')]")
		 private WebElement checkbox;
		 
		 
		 @FindBy(css="div[aria-labelledby='newNote_quote-label'][role='switch checkbox']")
		 private WebElement checkboxSlider;
		
		 @FindBy(id="notesBody_quote")
		 private WebElement notesBodyTextArea;
		 
		 @FindBy(css="div[id='oj-select-choice-noteType_quote']")
		 private WebElement noteTypeDropdown;
		 
		 @FindBy(css="ul[id='oj-listbox-results-noteType_quote']>li>div")
		private List<WebElement> listOfNoteTypes;
		 
		@FindBy(css="button[name='save_note']")
		private WebElement saveNoteButton;
		
		@FindBy(css="table[aria-label='Notes List Array']>tbody>tr")
		List<WebElement> listOfNotesRows;
		
		
		//Actions 
		private void clickOnCheckbox(){
			try{
				uiAction.click(checkbox, "ActionClick");
				extentLogger.addInfo("Click on Checkox to add notes.");
				LOGGER.logInfo(this.getClass().getSimpleName(),"Click on Checkox to add notes.");
			}catch(Exception ex){
				extentLogger.addFail(ex.getMessage());
				LOGGER.logError(this.getClass().getSimpleName(),
						"Checkbox is not interactable to click or not visible to click",ex.getMessage());
				Assert.fail("Checkbox is not interactable to click or not visible to click");
			}
		}
		
		private void clickOnCheckboxSlider(){
			try{
				uiAction.click(checkboxSlider,clickType.NORMAL_CLICK);
				extentLogger.addInfo("Click on Checkox slider to add notes.");
				LOGGER.logInfo(this.getClass().getSimpleName(),"Click on Checkox Slider to add notes.");
			}catch(Exception ex){
				extentLogger.addFail(ex.getMessage());
				LOGGER.logError(this.getClass().getSimpleName(),
						"Checkbox Slider is not interactable to click or not visible to click",ex.getMessage());
				Assert.fail("Checkbox Slider is not interactable to click or not visible to click");
			}
		}
		
		private void waitForNotesBodyToBeDisplayed(){
			try{
				isElementVisible(notesBodyTextArea);
				isElementInteractable(notesBodyTextArea);
			}catch(Exception ex){
				extentLogger.addFail(ex.getMessage());
				LOGGER.logError(this.getClass().getSimpleName(),"Notes Body Text Area is not interactable to enter notes.",ex.getMessage());
				Assert.fail("Notes Body Text Area is not interactable to enter notes.");
			}
		}
		
		private void enterNotes(String notes){
			try{
				uiAction.typeText(notesBodyTextArea,notes);
				extentLogger.addInfo("Enter Notes as "+notes);
				LOGGER.logInfo(this.getClass().getSimpleName(), "Enter Notes as "+notes);
			}catch(Exception ex){
				extentLogger.addFail(ex.getMessage());
				LOGGER.logError(this.getClass().getSimpleName(),"Notes Body Text Area is not interactable to enter notes.",ex.getMessage());
				Assert.fail("Notes Body Text Area is not interactable to enter notes.");
			}
		}
		
		private void clickOnNoteTypeDropdown(){
			try{
				uiAction.click(noteTypeDropdown,clickType.NORMAL_CLICK);
				extentLogger.addInfo("Click on Note Type Dropdown.");
				LOGGER.logInfo(this.getClass().getSimpleName(), "Click on Note Type Dropdown.");
			}catch(Exception ex){
				extentLogger.addFail(ex.getMessage());
				LOGGER.logError(this.getClass().getSimpleName(),"Note Type Dropdown is not interactable to click or not visible to click",ex.getMessage());
				Assert.fail("Note Type Dropdown is not interactable to click or not visible to click");
			}
		}
		
		private void selectNoteType(String noteType){
			try{
				uiAction.SelectFromListByVisibleText(listOfNoteTypes, noteType);
				extentLogger.addInfo("Selected Note Type as "+noteType);
				LOGGER.logInfo(this.getClass().getSimpleName(), "Selected Note Type as "+noteType);
			}catch(Exception ex){
				extentLogger.addFail(ex.getMessage());
				LOGGER.logError(this.getClass().getSimpleName(),
						"Note Type  is not available to select or not visible to select.",ex.getMessage());
				Assert.fail("Note Type  is not available to select or not visible to select.");
			}
		}
		
		private void clickOnSaveNoteButton(){
			try{
				uiAction.click(saveNoteButton,clickType.NORMAL_CLICK);
				extentLogger.addInfo("Click on Save Note Button.");
				LOGGER.logInfo(this.getClass().getSimpleName(),"Click on Save Note Button.");
			}catch(Exception ex){
				extentLogger.addFail(ex.getMessage());
				LOGGER.logError(this.getClass().getSimpleName(),
						"Save Note Button is not interactable to click or not visible to click",ex.getMessage());
				Assert.fail("Save Note Button is not interactable to click or not visible to click");
			}
		}
		
		
		//Business Rules
		
		public void addNotes(String notesType,String notes) throws InterruptedException{
			String[]noteType = notesType.split(",");
			String[] note = notes.split(",");
			Thread.sleep(15000);
			for(int i=0;i<noteType.length;i++){
				//this.clickOnCheckbox();
				this.clickOnCheckboxSlider();
				this.waitForNotesBodyToBeDisplayed();
				this.clickOnNoteTypeDropdown();
				this.selectNoteType(noteType[i]);
				this.enterNotes(note[i]);
				this.clickOnSaveNoteButton();
				Thread.sleep(15000);
				isAllElementVisible(listOfNotesRows);
			}
			
			test.log(LogStatus.INFO, test.addScreenCapture(addScreenshot()));
		}

		public boolean isPageLoaded() {
			// TODO Auto-generated method stub
			return isPageLoaded(checkboxSlider);
		}
}
