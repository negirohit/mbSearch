package Mb_Search_Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mb_Search.Homepage;
import Mb_Search.Mb_srp;
import mbsearch.base.TestBase;
import listeners.RetryAnalyzer;
import listeners.TestListener;

public class Mb_srp_Test extends TestBase implements TestListener.WebDriverProvider 
{

	Homepage homepage;
	Mb_srp mbsrp;


	public Mb_srp_Test()
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
		mbsrp = new  Mb_srp();
		driver.get(prop.getProperty("url2")); 
		//homepage.search();

	}

	//	@Test(priority=1)
	public void search_homepage() throws Exception
	{

		homepage.search();

	}

	//	@Test(priority=2)
	public void srp_Page() throws Exception
	{ 
		mbsrp.srp_searchresult();
	}


	//	@Test(priority=3)
	public void srp_Pagefilter() throws Exception
	{
		mbsrp.postedbyowner();
	}

	//	@Test(priority=4)
	public void scrolldownthepage() throws Exception
	{

		mbsrp.contact_CTA();

	}

//	@Test(priority=1)
	public void srp_allfilters() throws Exception
	{
		mbsrp.srp_filters();
		mbsrp.test_lowtohigh();
		int num1 = mbsrp.test_sortby();
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


		mbsrp.test_hightolow();
		int num2 = mbsrp.test_sortby();
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

		mbsrp.test_sortmostrecent();
		Thread.sleep(4000);
		mbsrp.updatephototext();
	}


	@Test(priority=2)
	public void searchnewkeyword() throws Exception
	{
		driver.get(prop.getProperty("url2")); 
		mbsrp.search_new_keyword();
	

	}


	//	@Test(priority=2)
	public void sortby_lowtohigh() throws Exception
	{
		mbsrp.test_lowtohigh();
		int num1 = mbsrp.test_sortby();
		if (num1 >80 && num1<82)
		{
			Assert.assertTrue(false);
		}


		mbsrp.test_hightolow();
		int num2 = mbsrp.test_sortby();
		if (num2 < 2)
		{
			Assert.assertTrue(false);
		}

		mbsrp.test_sortmostrecent();
		mbsrp.updatephototext();

	}

	//@Test(priority=3)
	public void sortby_hightolow() throws Exception
	{
		mbsrp.test_hightolow();
		int num1 = mbsrp.test_sortby();
		if (num1 < 2)
		{
			Assert.assertTrue(false);
		}

		mbsrp.test_sortmostrecent();
		mbsrp.updatephototext();


	}


	//@Test(priority=4)
	public void Sortbyrecent() throws Exception
	{
		mbsrp.test_sortmostrecent();
		mbsrp.updatephototext();

	}

	//@AfterMethod
	public void closedriver() 
	{			
		driver.quit();
	}
}
