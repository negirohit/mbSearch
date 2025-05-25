package Mb_Search_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Mb_Search.Homepage;
import Mb_Search.Mb_ldp;
import Mb_Search.Mb_srp;
import listeners.RetryAnalyzer;
import mbsearch.base.TestBase;

public class Mb_ldp_test extends TestBase {
	
	Homepage homepage;
	Mb_srp mbsrp;
	Mb_ldp mbldp;
	
	
	public Mb_ldp_test()
	{
		super();
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
	@Test(priority=1)
	public void srp_cardwidget() throws Exception
	{
		
	
		//mbsrp.srp_card();
		
		mbldp.summaryitem_check();		
		mbldp.list_valuecheck();
		mbldp.more_details_module();
		mbldp.aboutProject();		
		mbldp.amenities();		
		mbldp.hotspot_widget();
		mbldp.otherProperties();
	}
		
	//@Test(priority=2)
	public void Homeinteriorwidget_widget() throws Exception
	{
		//mbldp.interior_CTA();
		
	}
	
	
	
	
	
	//@AfterMethod
	public void closedriver() 
	{			
			driver.quit();
	}

}
