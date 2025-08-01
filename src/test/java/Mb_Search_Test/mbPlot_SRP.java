	
	package Mb_Search_Test;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

	import Mb_Search.Homepage;
	import Mb_Search.Mb_srp;
import Mb_Search.PlotSRP;
import Mb_Search.Magichome_srp;
	import mbsearch.base.TestBase;
	import listeners.RetryAnalyzer;
	import listeners.TestListener;

	
	@Listeners(TestListener.class)
	public class MbPlot_SRP extends TestBase implements TestListener.WebDriverProvider 
	{

		Homepage homepage;
		//Mb_srp mbsrp;
		Magichome_srp magicSrp;
		PlotSRP plotsrp;


		public MbPlot_SRP()
		{
			super();
		}

		@Override
		public WebDriver getDriver() {
			return this.driver; // Method to to Implement Listener:
		}

		//	@BeforeClass
		public void initilizebrowser() throws Exception
		{
			initilization();
		}

		@BeforeMethod
		public void setup() throws Exception {

			initilization();
			homepage = new Homepage();
			//mbsrp = new  Mb_srp();
			plotsrp= new  PlotSRP();
			driver.get(prop.getProperty("urlplot")); 
			//homepage.search();

		}

		//	@Test(priority=1)
		public void search_homepage() throws Exception
		{

			homepage.search();

		}

			@Test(priority=2)
		public void srp_Page() throws Exception
		{ 
			
				plotsrp.srp_searchresult();
		}


		@Test(priority=3)
		public void srp_Pagefilter() throws Exception
		{
				plotsrp.postedbyowner();
		}

		@Test(priority=4)
		public void scrolldownthepage() throws Exception
		{

				plotsrp.contact_CTA();

		}

		@Test(priority=1)
		public void srp_allfilters() throws Exception
		{
			plotsrp.srp_filters();
			plotsrp.test_lowtohigh();
			int num1 = plotsrp.test_sortby();
			/*
			System.out.println("the Number is num1 "+ num1);
			Thread.sleep(4000);
			if (num1 < 85)
			{
				Assert.assertTrue(true);
			}

			else
			{
				System.out.println("in Else low to high");
				Assert.assertTrue(false);
			}


			plotsrp.test_hightolow();
			int num2 = plotsrp.test_sortby();
			System.out.println("the Number is num2"+ num2);
			Thread.sleep(4000);
			if (num2 >1.5 && num2< 2.3)
			{

				Assert.assertTrue(true);
			}

			else
			{
				System.out.println("in Else high to low ");
				Assert.assertTrue(false);
			}
			
			*/
			plotsrp.test_hightolow();
			plotsrp.test_sortmostrecent();
			Thread.sleep(4000);
			//plotsrp.updatephototext();
		}


		@Test(priority=2)
		public void searchnewkeyword() throws Exception
		{
			driver.get(prop.getProperty("ploturl1")); 
			plotsrp.search_new_keyword();
		
		}


			@Test(priority=2)
		public void sortby_lowtohigh() throws Exception
		{
				plotsrp.test_lowtohigh();
				/*
				 * int num1 = plotsrp.test_sortby(); if (num1 >80 && num1<82) {
				 * Assert.assertTrue(false); }
				 * 
				 * 
				 * plotsrp.test_hightolow(); int num2 = plotsrp.test_sortby(); if (num2 < 2) {
				 * Assert.assertTrue(false); }
				 
			plotsrp.test_sortmostrecent();
			plotsrp.updatephototext();
			*/

		}

		@Test(priority=3)
		public void sortby_hightolow() throws Exception
		{
			plotsrp.test_hightolow();
			/*
			 * int num1 = plotsrp.test_sortby(); if (num1 < 2) { Assert.assertTrue(false); }
			
			  plotsrp.test_sortmostrecent(); 
			  //plotsrp.updatephototext();
			  
			   */
			 


		}


		//@Test(priority=4)
		public void Sortbyrecent() throws Exception
		{
			plotsrp.test_sortmostrecent();
			plotsrp.updatephototext();

		}

	//	@AfterMethod
		public void closedriver() 
		{			
			driver.quit();
		}
	}



