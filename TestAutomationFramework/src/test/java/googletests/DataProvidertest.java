package googletests;
import java.util.Map;
import org.testng.annotations.Test;

import dataProvider.TestUtil;



public class DataProvidertest {
	
	
	
	@Test(dataProvider="csvDataProvider",dataProviderClass=TestUtil.class,priority=1)
	public  void login(Map<String,String> data) {
		
	}
	
	@Test(dataProvider="csvDataProvider",dataProviderClass=TestUtil.class,priority=2)
	public  void user(Map<String,String> data) {
		
	}
	
	

	@Test(dataProvider="csvDataProvider1",dataProviderClass=TestUtil.class,priority=3)
	public  void registeration(Map<String,String> data) {
		
	}
	

}
