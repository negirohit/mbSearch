package Mb_Search_Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Mb_Search.Homepage;
import Mb_Search.Mb_ldp;
import Mb_Search.Mb_srp;
import Mb_Search.Magichome_srp;
import listeners.TestListener;
import mbsearch.base.TestBase;

@Listeners(TestListener.class)
public class MagichomeSrp_Test extends TestBase implements TestListener.WebDriverProvider  {
	
	Homepage homepage;
	Mb_srp mbsrp;
	Mb_ldp mbldp;
	Magichome_srp magicSrp;
	
	public MagichomeSrp_Test()
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
		magicSrp=  new  Magichome_srp();
		driver.get(prop.getProperty("magicsrp_url")); 
		
		//homepage.search();		
	}
	 
	
	//@Test(priority=0)
	public void magicSr_searchcount() throws InterruptedException
	{
		magicSrp.searchcount();		
		/*
		 * magicSrp.Project_namevalidation(); magicSrp.search();
		 * magicSrp.Project_namevalidation(); magicSrp.Srpcard();
		 */
				
		
	}
	
//	@Test(priority=1)
	public void magicSrp_Project_namevalidation() throws InterruptedException
	{
		magicSrp.Project_namevalidation();
		
				
		
	}
	
	//@Test(priority=2)
	public void magicSrpsearch() throws InterruptedException
	{
		magicSrp.search();
		magicSrp.Project_namevalidation();
		
		
	}
	
	@Test(priority=3)
	public void magicSrp_Srpcard() throws InterruptedException
	{
		
		magicSrp.Srpcard();
		
	}
	
	

	@AfterMethod
	public void closedriver() 
	{			
			driver.quit();
	}

}
