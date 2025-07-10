package Mb_Search_Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Mb_Search.Homepage;
import Mb_Search.Mb_ldp;
import Mb_Search.Mb_srp;
import Mb_Search.magichome_srp;
import listeners.TestListener;
import mbsearch.base.TestBase;

@Listeners(TestListener.class)
public class magichomeSrp_Test extends TestBase implements TestListener.WebDriverProvider  {
	
	Homepage homepage;
	Mb_srp mbsrp;
	Mb_ldp mbldp;
	magichome_srp magicSrp;
	
	public magichomeSrp_Test()
	{
		super();
	}
	
	@Override
	public WebDriver getDriver() {
	    return this.driver; // Method to to Implement Listener:
	}
	
	
	@BeforeMethod
	public void setup() throws Exception {
		
		initilization();
		//homepage = new Homepage();
		mbsrp = new  Mb_srp();
		mbldp = new  Mb_ldp();
		magicSrp=  new  magichome_srp();
		driver.get(prop.getProperty("magicsrp_url")); 
		
		//homepage.search();		
	}
	 
	
	@Test(priority=1)
	public void magicSrp() throws InterruptedException
	{
		magicSrp.searchcount();		
		magicSrp.Project_namevalidation();
		magicSrp.search();
		magicSrp.Project_namevalidation();
		magicSrp.Srpcard();
				
		
	}

	//@AfterMethod
	public void closedriver() 
	{			
			driver.quit();
	}

}
