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
    import Mb_Search.MbSrp_Rent;
    import Mb_Search.Top_Agent;
    import Mb_Search.magichome_srp;
	import mbsearch.base.TestBase;
	import listeners.RetryAnalyzer;
	import listeners.TestListener;


	
	@Listeners(TestListener.class)
	public class TopAgent_Test extends TestBase implements TestListener.WebDriverProvider 
	{
		Top_Agent topagentpage;
		


		public TopAgent_Test()
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
			topagentpage=new Top_Agent();
			driver.get(prop.getProperty("topagenturl")); 
			

		}

		


		@Test(priority=0)
		public void agentcontactCTA() throws Exception
		{
			topagentpage.ContactCTA();

		}
		
		@Test(priority=1)
		public void dropdownvalidation() throws Exception
		{
			topagentpage.citydropdown();
		}
		
		@Test(priority=2)
		public void agentnamevalidation() throws Exception
		{
			topagentpage.ldp();

		}

		@AfterMethod
		public void closedriver() 
		{			
			driver.quit();
		}
	}






