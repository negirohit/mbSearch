package Mb_Search_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mb_Search.Homepage;
import listeners.RetryAnalyzer;
import listeners.TestListener;
import mbsearch.base.TestBase;
import utils.JavaScriptExecutorUtils;
import utils.TabSwitch;

public class HomepageTest extends TestBase implements TestListener.WebDriverProvider {
	
	Homepage homepage;

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
	    return this.driver; // Method to to Implement Listener:
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initilization();
		homepage= new Homepage();
		
	}
	
	
	@Test(priority=1)
	public void search_homepage() throws Exception
	{
		
			homepage.search();
			 homepage.srp_searchresultvalidation();
						
	}
	
	/* // Search option in the menu
	@Test(priority=0)
	public void defaultsearch_buy() throws Exception
	{
		homepage.defaultsearch_buy();
        homepage.srp_searchresultvalidation();
			
	}
	
	@Test(priority=0)
	public void defaultsearch_rent() throws Exception
	{
		
		homepage.defaultsearch_Rent();
		homepage.srp_searchresultvalidation();
			
	}
	
	@Test(priority=1,retryAnalyzer = RetryAnalyzer.class)
	public void defaultmagichome() throws Exception
	{
		
	
		homepage.defaultmagic_homes();
		
		
	}
	
	@Test(priority=2)
	public void defaultpg() throws Exception
	{
	homepage.defaultpg();
	
	}
	
	@Test(priority=3)
	public void defaultplot() throws Exception
	{
	homepage.defaultplot();
	homepage.srp_searchresultvalidation();
	
	}
	
	@Test(priority=4)
	public void defaultcommercial() throws Exception
	{
	homepage.defaultcommercial();
	homepage.srp_searchresultvalidation();
	
	}
	//this is closed will here
	*/

	/*
	//@Test(priority=1)
		public void search_homepage1() throws Exception
		{
			
				Boolean bln =homepage.firstWidget();
			    Assert.assertEquals(true, bln);
				
		}
	
	@Test(priority=2)
	public void ownerpropertywidget() throws Exception
	{
		
		homepage.ownerpropertyclick();
		TabSwitch.tabswitch();		
	}
	
	@Test(priority=3)
	public void newProjectwidget() throws Exception
	{
		homepage.newProjectclick();
		TabSwitch.tabswitch();
	}
	
	@Test(priority=4)
	public void readyToMoveFlatswidget() throws Exception
	{
		homepage.readyToMoveFlatsclick();
		TabSwitch.tabswitch();
	}
	
	@Test(priority=5)
	public void budgetHomewidget() throws Exception
	{
		homepage.budgetHomeclick();
		TabSwitch.tabswitch();
	}
	
	@Test(priority=6)
	public void popularownerwidget1() throws Exception
	{		
		homepage.popularownerproperty1();
		TabSwitch.tabswitch();
	}
	
	@Test(priority=7)
	public void popularownerwidget2() throws Exception
	{
		homepage.popularownerproperty2();
		TabSwitch.tabswitch();
	}
	
	@Test(priority=8)
	public void popularownerwidget3() throws Exception
	{
		homepage.popularownerproperty3();
		TabSwitch.tabswitch();
	}
	
	@Test(priority=9)
	public void popularownerwidget4() throws Exception
	{
		homepage.popularownerproperty4();
		TabSwitch.tabswitch();
	}
	
	*/
	
	//@Test(priority=10)
	public void prfeeredagentwidget() throws Exception
	{
		homepage.prfeeredagent();
	
	}
	
	
	
	@Test(priority=11)
	public void magichometwidget() throws Exception
	{
		homepage.magichomes_widget();
		TabSwitch.tabswitch();
		System.out.println("this is working");
	}
	
	@Test(priority=12)
	public void propertyservice_homeLoanWidget() throws Exception
	{
		homepage.propertyservice_homeLoan();
		TabSwitch.tabswitch();
		System.out.println("this is working 1");
	}
	
	@Test(priority=13)
	public void propertyservice_homeInterior() throws Exception
	{
		homepage.propertyservice_Interior();
		TabSwitch.tabswitch();
		System.out.println("this is working 2");
	}
	
	
	
//	@Test(priority=14)
	public void Project_GalleryWidget() throws Exception
	{
		homepage.project_gallery_Widget();
		TabSwitch.tabswitch();
		System.out.println("this is working 3");
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
		//TabSwitch.tabswitch();
	}
	
	
	
	//@Test(priority=16)
	public void RateTrends() throws Exception
	{
		homepage.RateTrendsWidget();
		
	}

	//@Test(priority=17)
	public void EMICalculator() throws InterruptedException
	{
	
		homepage.EMICalculatorWidget();
	
	}
	
	//@Test(priority=18)
	public void InvestmentHotspot() throws InterruptedException
	{
	
		homepage.InvestmentHotspotWidget();
		
	
	}
	
//	@Test(priority=19)
	public void ResearchInsights() throws InterruptedException
	{
	
		homepage.ResearchInsightsWidget();
		
	
	}
	

//	@Test(priority=14)
	public void clickAllFreshPropertyCardsWidget() throws Exception
	{
		homepage.clickAllFreshPropertyCards();
		//TabSwitch.tabswitch();
	}
	
	
	
	
	@AfterMethod
	public void closedriver() 
	{			
			driver.quit();
	}

}
