
	
	package Mb_Search_Test;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

	import Mb_Search.Homepage;
import Mb_Search.Homepage_search;
import listeners.RetryAnalyzer;
	import listeners.TestListener;
	import mbsearch.base.TestBase;
	import utils.JavaScriptExecutorUtils;
	import utils.TabSwitch;

	@Listeners(TestListener.class)

	public class Homepage_searchTest extends TestBase implements TestListener.WebDriverProvider {
		
		
		Homepage_search homepagesearch;
		protected static final Logger logger = LogManager.getLogger(Homepage_searchTest.class);

		public Homepage_searchTest()
		{
			super();
		}
		
		@BeforeClass
	     public void initilizebrowser() throws Exception {
			
		//	initilization();
			
		}
		
		@Override
		public WebDriver getDriver() {
		    return this.driver; // Method to to Implement Listener:
		}
		
		@BeforeMethod
		public void setup() throws Exception
		{
			initilization();
			homepagesearch= new Homepage_search();
			
		}
		
		
		@Test(priority=0,description = "search through the keyword for buy")
		public void search_homepage() throws Exception
		{		
			homepagesearch.search();
			homepagesearch.srp_searchresultvalidation();
			logger.info("search from the homepage through the keyword");					
		}
		
		
		
		//Search option in the menu
	//	@Test(priority=1,description = "search through the keyword for buy")
		public void defaultsearch_buy() throws Exception
		{
			homepagesearch.defaultsearch_buy();
			homepagesearch.srp_searchresultvalidation();
	        driver.navigate().back();
	        homepagesearch.homepage_back();
	        logger.info("search from the Homepage for Buy Module");		
		}
		
				
		//@AfterMethod
		public void closedriver() 
		{			
				driver.quit();
		}

	}



