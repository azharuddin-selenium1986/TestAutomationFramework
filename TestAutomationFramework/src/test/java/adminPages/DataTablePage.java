package adminPages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.internal.LinkedTreeMap;

public class DataTablePage {
	
	WebDriver driver;
	public DataTablePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@role='tree']/li/div/span[2]")
	private List<WebElement> listOfHeaders;
	
	
	@FindBy(xpath="//ul[@role='tree']/li")
	private List<WebElement> listOfDataTableTree;
	
	@FindBy(xpath="//ul[@role='tree']/li/ul/li")
	private List<WebElement> listOfTables;
	
	
	public DataTablePage waitForDataTablePage() {
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOfAllElements(listOfDataTableTree));
		return this;
	}
	
	
	public void getListOfDatatables() {
		for(int i=0;i<listOfDataTableTree.size();i++) {
			if(listOfDataTableTree.get(i).getText().equals("Test")) {
				listOfDataTableTree.get(i).findElement(By.xpath("ins")).click();
				break;
			}
		}
	}


	public void getListOfTables() {
		Actions act = new Actions(driver);
		for(int i=0;i<listOfTables.size();i++) {
			act.moveToElement(listOfTables.get(i)).contextClick().build().perform();
			driver.findElement(By.xpath("//a[contains(text(),'Export')]")).click();
			new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='oj-dialog-body']/div/div[@id='progress-content']"))));
			driver.findElement(By.xpath("//div[@class='oj-dialog-body']/div/div[@id='progress-content']/p/a")).click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.findElement(By.xpath("//div[@id='export-dialog_layer']/oj-dialog/div[1]/oj-button/button")).click();
			new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='export-dialog_layer']/oj-dialog"))));
		}
		
	}


	public void getListOfTablesWithFolder() throws IOException, InterruptedException {
	
		
		//Create blank workbook
	      XSSFWorkbook workbook = new XSSFWorkbook();
	      
	      //Create a blank sheet
	      XSSFSheet spreadsheet = workbook.createSheet( " Data Tables ");

	      //Create row object
	      XSSFRow row;

	      //This data needs to be written (Object[])
	      Map < String, Object[] > table = new LinkedTreeMap< String, Object[] >();
	      table.put(String.valueOf("-1"),new Object[] {"FolderName","TableName"});
		for(int i=0;i<listOfDataTableTree.size();i++) {
			 
			listOfDataTableTree.get(i).findElement(By.xpath("ins")).click();
			Thread.sleep(5000);
			for(int j=0;j<listOfTables.size();j++) {
				if(listOfTables.get(j).getText().equals("")==false) {
					table.put(String.valueOf(j),new Object[] {listOfHeaders.get(i).getText(),listOfTables.get(j).getText()});
				}
			}
			listOfDataTableTree.get(i).findElement(By.xpath("ins")).click();
			Thread.sleep(5000);
		}
		
		
	      //Iterate over data and write to sheet
	      Set < String > keyid = table.keySet();
	      int rowid = 0;
	      
	      for (String key : keyid) {
	         row = spreadsheet.createRow(rowid++);
	         Object [] objectArr = table.get(key);
	         int cellid = 0;
	         
	         for (Object obj : objectArr){
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      //Write the workbook in file system
	      FileOutputStream out = new FileOutputStream(
	         new File(System.getProperty("user.dir")+"/TestData/DataTable.xlsx"));
	      
	      workbook.write(out);
	      out.close();
	      System.out.println("Writesheet.xlsx written successfully");
		
		
		
	}
	
	@FindBy(xpath="//oj-menu[@id='ctx-tree-menu']/oj-option/a")
	List<WebElement> listOfcontrolMenu;
public void downloadAllDataTables() throws IOException, InterruptedException {
	Actions act = new Actions(driver);
		for(int i=0;i<listOfDataTableTree.size();i++) {
			 
			listOfDataTableTree.get(i).findElement(By.xpath("ins")).click();
			Thread.sleep(5000);
			for(int j=0;j<listOfTables.size();j++) {
				if(listOfTables.get(j).getText().equals("")==false) {
					act.moveToElement(listOfTables.get(j)).contextClick().build().perform();
					 Thread.sleep(10000);
					new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//oj-menu[@id='ctx-tree-menu']"))));
					new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//oj-menu[@id='ctx-tree-menu']"))));
					for(int k=0;k<listOfcontrolMenu.size();k++) {
					   if(listOfcontrolMenu.get(k).getText().equals("Export")) {
						   listOfcontrolMenu.get(k).click();
					   }
					}
					Thread.sleep(15000);
					driver.findElement(By.xpath("//div[@class='oj-dialog-body']/div/div[@id='progress-content']/p/a")).click();
					try {
						Thread.sleep(15000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(By.xpath("//div[@id='export-dialog_layer']/oj-dialog/div[1]/oj-button/button")).click();
					new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='export-dialog_layer']/oj-dialog"))));
				}
			}
			listOfDataTableTree.get(i).findElement(By.xpath("ins")).click();
			Thread.sleep(5000);
		}
		
		
		
	}

}
