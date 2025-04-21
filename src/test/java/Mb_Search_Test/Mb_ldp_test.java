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
		homepage = new Homepage();
		mbsrp = new  Mb_srp();
		mbldp = new  Mb_ldp();
		driver.get(prop.getProperty("urlsrp")); 
		
		//homepage.search();		
	}
	
	//,retryAnalyzer = RetryAnalyzer.class
	@Test(priority=1)
	public void srp_cardwidget() throws Exception
	{
		
		driver.get(prop.getProperty("urlsrp"));
		mbldp.clickonlocalitymenu();
		driver.findElement(By.xpath("//*[2]/div[1]/div[2]/div[1]/label[1]")).click();
		driver.findElement(By.xpath("//div[@class='filter__component topLocality activeFilter']//div[@class='filter__component__cta-done'][normalize-space()='Done']")).click();		
		driver.findElement(By.xpath("//div[contains(@class,'title-ellipsis')][normalize-space()='Budget']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'filter__component topBudget activeFilter')]//div[contains(@class,'filter-budget__fieldset__min-max min')]//select[contains(@class,'filter-budget__select')]")).click();
		
		// Locate dropdown - 
        WebElement dropdown = driver.findElement(By.xpath("//div[contains(@class,'filter__component topBudget activeFilter')]//div[contains(@class,'filter-budget__fieldset__min-max min')]//select[contains(@class,'filter-budget__select')]"));

        Select select = new Select(dropdown);

        // Min Dropdown
        select.selectByVisibleText("₹ 80 Lac");
        //Max dropdown
        WebElement dropdown1 = driver.findElement(By.xpath("//div[contains(@class,'filter__component topBudget activeFilter')]//div[contains(@class,'filter-budget__fieldset__min-max max')]//select[contains(@class,'filter-budget__select')]"));
        
        Select select1= new Select(dropdown1);
        select1.selectByVisibleText("₹ 2.3 Cr");
       // Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,'filter__component topBudget activeFilter')]//div[contains(@class,'filter__component__cta-done')][normalize-space()='Done']")).click();
    	
     // clicking on the "Owner" in posted by filter 
        driver.findElement(By.xpath("//div[@class='title-ellipsis'][normalize-space()='Posted By']")).click();
    	driver.findElement(By.xpath("//label[@for='inputListings_inputListings_I']")).click();    	
    	driver.findElement(By.xpath("//div[@class='filter__component topPostedBy activeFilter']//div[@class='filter__component__cta-done'][normalize-space()='Done']")).click();
		Thread.sleep(3000);
		 String strowner =driver.findElement(By.xpath("//div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[2]/span[1]")).getText(); 
		  Assert.assertEquals(strowner,"Contact Owner");
		 
		  
		  // click on the "Agent" in posted by filter 
		  driver.findElement(By.xpath("//div[@class='title-ellipsis'][normalize-space()='Owners']")).click();
		  driver.findElement(By.xpath("//label[@for='inputListings_inputListings_I']")).click(); 
		  driver.findElement(By.xpath("//label[normalize-space()='Brokers']")).click();
		  driver.findElement(By.xpath("//div[@class='filter__component topPostedBy activeFilter']//div[@class='filter__component__cta-done'][normalize-space()='Done']")).click();
		  Thread.sleep(4000);
		  String str_agent =driver.findElement(By.xpath("//div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[2]/span[1]")).getText(); 
		  Assert.assertEquals(str_agent,"Contact Agent");

		// clicking on the "Builder" in posted by filter 
		  driver.findElement(By.xpath("//div[contains(text(),'Brokers')]")).click();
		  driver.findElement(By.xpath("//label[normalize-space()='Brokers']")).click();
		  driver.findElement(By.xpath("//label[@for='inputListings_inputListings_B']")).click();
		  driver.findElement(By.xpath("//div[@class='filter__component topPostedBy activeFilter']//div[@class='filter__component__cta-done'][normalize-space()='Done']")).click();
		  Thread.sleep(3000);
		  String str_builder =driver.findElement(By.xpath("//div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[2]/span[1]")).getText(); 
		  Assert.assertEquals(str_builder,"Contact Builder");
			  
    	
	}
	

	
	
	@AfterMethod
	public void closedriver() 
	{			
			driver.quit();
	}

}
