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
import Mb_Search.mbPDP;
import listeners.RetryAnalyzer;
import listeners.TestListener;
import mbsearch.base.TestBase;


@Listeners(TestListener.class)
	public class mbPDP_Test extends TestBase implements TestListener.WebDriverProvider  {
				
			Homepage homepage;
			//Mb_srp mbsrp;
			//Mb_ldp mbldp;
			magichome_srp magicSrp;
			mbPDP  mbpdp;
			
			
			
			public mbPDP_Test()
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
				homepage = new Homepage();
				//mbsrp = new  Mb_srp();
				//mbldp = new  Mb_ldp();
				magicSrp=  new  magichome_srp();
				mbpdp=new mbPDP();
				driver.get(prop.getProperty("magicsrp_url")); 
				
				
				//homepage.search();		
			}
			
			//,retryAnalyzer = RetryAnalyzer.class
			@Test(priority=1)
			public void SRP_Click() throws Exception
			{
				mbpdp.detailPage();
				mbpdp.specification();
				mbpdp.Contact_CTA();
				mbpdp.ComprehensiveInforwidget();
				mbpdp.contactform_Assertion();
				mbpdp.RatingWidget();
				mbpdp.buyerReviews();
				mbpdp.Map();
			}
			
		//	@Test(priority=2)
			public void magicPDP_vaidation() throws InterruptedException
			{
						
				
			}
			
			@AfterMethod
			public void closedriver() 
			{			
					driver.quit();
			}
			
}
