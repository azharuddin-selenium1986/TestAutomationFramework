package baseinterfaces;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Common Actions(Web/Mobile)
 * @author SESA443020
 *
 */
public interface IAction{
	 enum ScrollType 
	 { 
	     HOME, PAGE_UP, PAGE_DOWN,END,ENTER; 
	 } 
	 enum clickType{
		 NORMAL_CLICK,JS_CLICK,ACTION_CLICK,KEY_ENTER
	 }
	 enum Options{
		 GET_TEXT,GET_ATTRIBUTE
	 }
    /**Actions on Web Elements*/
	void click(WebElement element,clickType clickType);
	void click(List<WebElement> element,clickType clickType,String options);
	void doubleClick(WebElement element);
	void doubleClick(List<WebElement>elements,String options);
	void rightClick(WebElement element);
	void rightClick(List<WebElement> elements,String options);
	void mouseHover(WebElement element);
	void mouseHover(List<WebElement> elements,String options);
	void enterText(WebElement element,String type,String text);
	void selectDropDownValue(WebElement element,String value);
	void selectDropDownValue(WebElement element,int index);
	void selectDropDownValue(String visibleText,WebElement element);
	/*Select Multiple values from multi select Dropdown- needs to be implemented*/
	void SelectFromListByVisibleText(List<WebElement> elements,clickType clickType,String text);
	void acceptAlert();
	void dismissAlert();
	String getTextFromAlert();
	String getTextFromElement(WebElement element,Options options,String value);
	String getElementValueUsingJSByID(String id);
	String getElementValueUsingJSByName(String name);
	boolean isTextPresent(List<WebElement> elements,String text);
	boolean isTextPresent(List<WebElement> elements,String attribute,String text);
	String addScreenshot();
	String addScreenshot(WebDriver driver);
	void scrollPage(ScrollType type);
}
