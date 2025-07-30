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
import listeners.RetryAnalyzer;
import listeners.TestListener;
import mbsearch.base.TestBase;
import utils.JavaScriptExecutorUtils;
import utils.TabSwitch;

@Listeners(TestListener.class)

public class HomepageTest extends TestBase implements TestListener.WebDriverProvider {
	
	
	Homepage homepage;
	protected static final Logger logger = LogManager.getLogger(HomepageTest.class);

	public HomepageTest()
	{
		super();
	}
	
	@BeforeClass
     public void initilizebrowser() throws Exception {
		
	//	initilization();
		
	}
	
	@Override
	public WebDriver getDriver() {
	    return this.driver; // Method to Implement Listener:
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initilization();
		homepage= new Homepage();
		
	}
	
	
	@Test(priority=0,description = "search through the keyword for buy")
	public void search_homepage() throws Exception
	{		
			 homepage.search();
			 homepage.srp_searchresultvalidation();
			 logger.info("search from the homepage through the keyword");					
	}
	
	//Search option in the menu
	@Test(priority=1,description = "search through the keyword for buy")
	public void defaultsearch_buy() throws Exception
	{
		homepage.defaultsearch_buy();
        homepage.srp_searchresultvalidation();
        driver.navigate().back();
        homepage.homepage_back();
        logger.info("search from the Homepage for Buy Module");		
	}
	
	@Test(priority=1, description = "search through the keyword for Rent")
	public void defaultsearch_rent() throws Exception
	{
		
		homepage.defaultsearch_Rent();
		homepage.srp_searchresultvalidation();
		logger.info("search from the Homepage for Rent Module");			
			
	}
	
	@Test(priority=2,description = "search through the keyword for MagichomeSRP")
	public void defaultmagichome() throws Exception
	{
		
	
		homepage.defaultmagic_homes();
		
		logger.info("search from the Homepage for MagicHomeSRP");	
	}
	
	@Test(priority=3, description = "search through the keyword for PG")
	public void defaultpg() throws Exception
	{
	homepage.defaultpg();
	logger.info("search from the Homepage for PG");	
	}
	
	@Test(priority=4,description = "search through the keyword for Plot")
	public void defaultplot() throws Exception
	{
	homepage.defaultplot();
	homepage.srp_searchresultvalidation();
	logger.info("search from the Homepage for Plot");	
	}
	
	@Test(priority=5, description = "search through the keyword for commercial")
	public void defaultcommercial() throws Exception
	{
	homepage.defaultcommercial();
	homepage.srp_searchresultvalidation();
	logger.info("search from the Homepage for commercial");	
	}
	//this is closed will here
	

	
	@Test(priority=6)
		public void search_homepage1() throws Exception
		{
			
				Boolean bln =homepage.firstWidget();
			    Assert.assertEquals(true, bln);
				
		}
	
	@Test(priority=7, description = "owner property widget")
	public void ownerpropertywidget() throws Exception
	{
		logger.info("owner property widget");
		homepage.ownerpropertyclick();
		TabSwitch.tabswitch();	
		logger.info("click on the owner  Widget in homepage");	
	}
	
	@Test(priority=8)
	public void newProjectwidget() throws Exception
	{
		homepage.newProjectclick();
		TabSwitch.tabswitch();
		logger.info("click on the New Project Widget in homepage");	
	}
	
	@Test(priority=9)
	public void readyToMoveFlatswidget() throws Exception
	{
		homepage.readyToMoveFlatsclick();
		TabSwitch.tabswitch();
		logger.info("click on the Ready to move Widget in homepage");	
	}
	
	@Test(priority=10)
	public void budgetHomewidget() throws Exception
	{
		homepage.budgetHomeclick();
		TabSwitch.tabswitch();
		logger.info("click on the Budget Home Widget in homepage");	
	}
	
	@Test(priority=11)
	public void popularownerwidget1() throws Exception
	{		
		homepage.popularownerproperty1();
		TabSwitch.tabswitch();
		logger.info("click on the Popular Owner Widget in homepage");	
	}
	
	
	@Test(priority=12)
	public void popularownerwidget2() throws Exception
	{
		homepage.popularownerproperty2();
		TabSwitch.tabswitch();
	}
	
	@Test(priority=13)
	public void popularownerwidget3() throws Exception
	{
		homepage.popularownerproperty3();
		TabSwitch.tabswitch();
	}
	
	@Test(priority=14)
	public void popularownerwidget4() throws Exception
	{
		homepage.popularownerproperty4();
		TabSwitch.tabswitch();
	}
	
	
	
	//@Test(priority=10)
	public void prfeeredagentwidget() throws Exception
	{
		homepage.prfeeredagent();
	
	}
	
	
	
	@Test(priority=15)
	public void magichometwidget() throws Exception
	{
		homepage.magichomes_widget();
		TabSwitch.tabswitch();
		logger.info("click on the MagicHome Widget in homepage");	
	}
	
	@Test(priority=16)
	public void propertyservice_homeLoanWidget() throws Exception
	{
		homepage.propertyservice_homeLoan();
		TabSwitch.tabswitch();
		logger.info("click on the Homeloan  Widget in homepage");	
	}
	
	@Test(priority=17)
	public void propertyservice_homeInterior() throws Exception
	{
		homepage.propertyservice_Interior();
		TabSwitch.tabswitch();
		logger.info("click on the Property Service  Widget in homepage");	
	}
	
	
	
//	@Test(priority=14)
	public void Project_GalleryWidget() throws Exception
	{
		homepage.project_gallery_Widget();
		TabSwitch.tabswitch();
		logger.info("click on the Project gallery  Widget in homepage");	
	}
	
/*	@Test(priority=15)
	public void Project_GalleryWidget2() throws Exception
	{
		homepage.project_gallery_Widgetsecond();
		TabSwitch.tabswitch();
	}*/
	
	//@Test(priority=14)
	public void Excl_ownerWidget() throws Exception
	{
		homepage.clickAllOwnerExclusivePropertyCards();
		logger.info("click on the owner Exclusive  Widget in homepage");	
		//TabSwitch.tabswitch();
	}
	
	
	
	@Test(priority=16)
	public void RateTrends() throws Exception
	{
		homepage.RateTrendsWidget();
		logger.info("click on the Rate And Trends  Widget in homepage");	
		
	}

	@Test(priority=17)
	public void EMICalculator() throws InterruptedException
	{
	
		homepage.EMICalculatorWidget();
		logger.info("click on the Emi Calculater  Widget in homepage");	
	
	}
	
	@Test(priority=18)
	public void InvestmentHotspot() throws InterruptedException
	{
	
		homepage.InvestmentHotspotWidget();
		logger.info("click on the Investment Hotspot  Widget in homepage");	
		
	
	}
	
	@Test(priority=19)
	public void ResearchInsights() throws InterruptedException
	{
	
		homepage.ResearchInsightsWidget();
		logger.info("click on the Research Insight Widget in homepage");	
		
	
	}
	

	@Test(priority=14)
	public void clickAllFreshPropertyCardsWidget() throws Exception
	{
		homepage.clickAllFreshPropertyCards();
		logger.info("click on the Fresh Property Widget in homepage");	
	}
	
	
	
	
	@AfterMethod
	public void closedriver() 
	{			
			driver.quit();
	}

}
