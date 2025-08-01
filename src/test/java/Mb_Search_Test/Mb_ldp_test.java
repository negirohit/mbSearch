package Mb_Search_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Mb_Search.Homepage;
import Mb_Search.Mb_ldp;
import Mb_Search.Mb_srp;
import listeners.RetryAnalyzer;
import listeners.TestListener;
import mbsearch.base.TestBase;

@Listeners(TestListener.class)
public class Mb_Ldp_Test extends TestBase implements TestListener.WebDriverProvider {
	
	Homepage homepage;
	Mb_srp mbsrp;
	Mb_ldp mbldp;
	
	
	public Mb_Ldp_Test()
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
		driver.get(prop.getProperty("urlsrp1")); 
		
		//homepage.search();		
	}
	
	//,retryAnalyzer = RetryAnalyzer.class
	//@Test(priority=1)
	public void ldp_srp_cardwidget() throws Exception
	{		
	
		//mbsrp.srp_card();
		//PageFactory.initElements(driver, this); 
		
		mbldp.summaryitem_check();		
		
	}
	
	@Test(priority=2)
	public void ldp_countvaluecheck() throws Exception
	{	
		
		mbldp.list_valuecheck();
		
	}
		
	//@Test(priority=3)
	public void ldp_Moredetails_module() throws Exception
	{
		mbldp.more_details_module();
		
		
	}
	
//	@Test(priority=4)
	public void ldp_AboutProject() throws Exception
	{
		mbldp.aboutProject();		
		
	}
	
	//@Test(priority=4)
	public void ldp_Amenities() throws Exception
	{
		mbldp.amenities();		
		
	}
	
	//@Test(priority=4)
	public void ldp_hotspotwidget()throws Exception
	{
		mbldp.hotspot_widget();
		
	}
	
	//@Test(priority=4)
	public void ldp_otherproperties() throws Exception
	{
		mbldp.otherProperties();
	}
	
	
	@AfterMethod
	public void closedriver() 
	{			
			driver.quit();
	}

}
