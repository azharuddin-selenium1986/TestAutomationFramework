package actions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import baseinterfaces.IAction;


public class UiAction implements IAction {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	Actions actions;

	public UiAction(WebDriver driver) {
		this.driver = driver;
		jsExecutor = ((JavascriptExecutor) driver);
		actions = new Actions(driver);
	}


	public void enterTextUsingJavaScript(WebElement element, String text) {
		jsExecutor.executeScript("arguments[0].value='" + text + "';", element);
	}

	public void click(WebElement element, String Choice) {

		switch (Choice) {
		case "Normal Click":
			element.click();
			break;
		case "JSClick":
			jsExecutor.executeScript("arguments[0].click();", element);
			break;
		case "ActionClick":
			actions.moveToElement(element).click().build().perform();
			break;

		default:
			element.click();
		}

	}
	
	
	
	

	public void refreshPage() {
		driver.navigate().refresh();
		
	}
	
	public  void typeText(WebElement element,String text) {
		// TODO Auto-generated method stub
		element.clear();
		element.sendKeys(text);
	}
	
	

	@Override
	public void click(WebElement element, clickType clickType) {
		// TODO Auto-generated method stub
		switch (clickType) {
		case NORMAL_CLICK:
			element.click();
			break;
		case JS_CLICK:
			jsExecutor.executeScript("arguments[0].click();", element);
			break;
		case ACTION_CLICK:
			actions.moveToElement(element).click().build().perform();
			break;

		default:
			element.click();
		}
	}


	@Override
	public void click(List<WebElement> element, clickType clickType, String options) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void doubleClick(WebElement element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void doubleClick(List<WebElement> elements, String options) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void rightClick(WebElement element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void rightClick(List<WebElement> elements, String options) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseHover(WebElement element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseHover(List<WebElement> elements, String options) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void enterText(WebElement element, String type, String text) {
		// TODO Auto-generated method stub
		
	}
	
	public void enterText(WebElement element,String text) {
		// TODO Auto-generated method stub
		element.sendKeys(text);
	}


	@Override
	public void selectDropDownValue(WebElement element, String value) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectDropDownValue(WebElement element, int index) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectDropDownValue(String visibleText, WebElement element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void SelectFromListByVisibleText(List<WebElement> elements, clickType clickType, String text) {
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().equals(text)) {
				elements.get(i).click();
				break;
			}

		}
		
	}
	
	public void SelectFromListByVisibleText(List<WebElement> elements,String text) {
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().equals(text)) {
				elements.get(i).click();
				break;
			}

		}
		
	}


	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getTextFromAlert() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getTextFromElement(WebElement element, Options options, String value) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getElementValueUsingJSByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getElementValueUsingJSByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isTextPresent(List<WebElement> elements, String text) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isTextPresent(List<WebElement> elements, String attribute, String text) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String addScreenshot() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String addScreenshot(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void scrollPage(ScrollType type) {
		switch (type) {
		case HOME:
			WebElement element = driver.findElement(By.cssSelector("body"));
			element.sendKeys(Keys.HOME);
			break;
		default:
			break;
		}
		
	}
}
