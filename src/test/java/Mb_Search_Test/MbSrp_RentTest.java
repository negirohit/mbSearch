	
	package Mb_Search_Test;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import Mb_Search.Homepage;
    import Mb_Search.MbSrp_Rent;
	import Mb_Search.magichome_srp;
	import mbsearch.base.TestBase;
	import listeners.RetryAnalyzer;
	import listeners.TestListener;


	public class MbSrp_RentTest extends TestBase implements TestListener.WebDriverProvider 
	{

		Homepage homepage;
		MbSrp_Rent mbsrpRent;
		magichome_srp magicSrp;


		public MbSrp_RentTest()
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
			mbsrpRent = new  MbSrp_Rent();
			driver.get(prop.getProperty("urlrent")); 
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
			
				mbsrpRent.srp_searchresult();
		}


			@Test(priority=3)
		public void srp_Pagefilter() throws Exception
		{
				mbsrpRent.postedbyowner();
		}

			@Test(priority=4)
		public void scrolldownthepage() throws Exception
		{

				mbsrpRent.contact_CTA();

		}

		@Test(priority=1)
		public void srp_allfilters() throws Exception
		{
			mbsrpRent.srp_filters();
			mbsrpRent.test_lowtohigh();
			int num1 = mbsrpRent.test_sortby();
			System.out.println("the Number is num1 "+ num1);
			Thread.sleep(4000);
			if (num1 < 100)
			{
				Assert.assertTrue(true);
			}

			else
			{
				System.out.println("in Else low to high");
				Assert.assertTrue(false);
			}


			mbsrpRent.test_hightolow();
			int num2 = mbsrpRent.test_sortby();
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

			mbsrpRent.test_sortmostrecent();
			Thread.sleep(4000);
			mbsrpRent.updatephototext();
		}


		@Test(priority=2)
		public void searchnewkeyword() throws Exception
		{
			driver.get(prop.getProperty("url2")); 
			mbsrpRent.search_new_keyword();
		

		}


			@Test(priority=2)
		public void sortby_lowtohigh() throws Exception
		{
				mbsrpRent.test_lowtohigh();
			int num1 = mbsrpRent.test_sortby();
			if (num1 >80 && num1<82)
			{
				Assert.assertTrue(false);
			}


			mbsrpRent.test_hightolow();
			int num2 = mbsrpRent.test_sortby();
			if (num2 < 2)
			{
				Assert.assertTrue(false);
			}

			mbsrpRent.test_sortmostrecent();
			mbsrpRent.updatephototext();

		}

		@Test(priority=3)
		public void sortby_hightolow() throws Exception
		{
			mbsrpRent.test_hightolow();
			int num1 = mbsrpRent.test_sortby();
			if (num1 < 2)
			{
				Assert.assertTrue(false);
			}

			mbsrpRent.test_sortmostrecent();
			mbsrpRent.updatephototext();


		}


		//@Test(priority=4)
		public void Sortbyrecent() throws Exception
		{
			mbsrpRent.test_sortmostrecent();
			mbsrpRent.updatephototext();

		}

		@AfterMethod
		public void closedriver() 
		{			
			driver.quit();
		}
	}



