package Mb_Search;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.JavaScriptExecutorUtils;
import mbsearch.base.TestBase;

public class Mb_srp extends TestBase{

	public static int num1;
	public static String str;
	public static String owner="Contact Owner1";
	public static String agent="Contact Agent";
	public static String builder="Contact Builder";
	public boolean contains=true;

	private WebDriverWait wait;
	@FindBy(xpath="//div[contains(text(),' results |')]")
	public static WebElement srp_searchcount;

	//@FindBy(xpath="//h1[contains(text(),'2 BHK Flats in')")
	//@FindBy(xpath="//h1[contains(text(),'2 BHK Flats in Hyderabad for Sale')]")
	@FindBy(xpath="//h1[normalize-space()='2 BHK Flats in Hyderabad for Sale']")
	public static WebElement srp_search_h1;

	@FindBy(xpath="//div[contains(text(),' results |')]")
	public static WebElement search_count;

	@FindBy(xpath="//div[@class='title-ellipsis'][normalize-space()='Posted By']")
	public static WebElement postedbyfilter;

	@FindBy(xpath="//label[@for='inputListings_inputListings_I']")
	public static WebElement ownerTag;

	@FindBy(xpath="//label[normalize-space()='Brokers']")
	public static WebElement AgentTag;

	@FindBy(xpath="//label[@for='inputListings_inputListings_B']")
	public static WebElement BuilderTag;

	@FindBy(xpath="//div[@class='filter__component topPostedBy activeFilter']//div[@class='filter__component__cta-done'][normalize-space()='Done']")
	public static WebElement doneCTA;

	@FindAll({@FindBy(xpath="//*[@class='mb-srp__action--btn medium btn-red']")})
	public static List <WebElement>  contactCTA;

	@FindAll({@FindBy(xpath="//div[contains(@class,'mb-srp__card__info mb-srp__card__info-withoutburger')]")})
	public static List <WebElement>  SRPcard;

	@FindBy(xpath=("//div[contains(@class,'title-ellipsis')][normalize-space()='Top Localities']"))
	public static WebElement toplocalities;

	@FindBy(xpath=("//div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]"))
	public static WebElement property_rate; //propertyrate in srp card 

	@FindBy(xpath=("//div[4]/div[1]/div[1]/div[1]/div[1]/div[1]"))
	public static WebElement updatedtodaytext; //text in srp on image widget

	@FindBy(xpath=("//div[@class='mb-srp__tabs__sortby--title']"))
	public static WebElement sortbydropdown;

	@FindBy(xpath=("//li[normalize-space()='Price - Low to High']"))
	public static WebElement sortbylow_to_high;
	
	@FindBy(xpath=("//li[normalize-space()='Price - High to Low']"))
	public static WebElement sortbyhigh_to_low;
	
	@FindBy(xpath=("//li[@class='mb-srp__tabs__sortby__dd__list--item active']"))
	public static WebElement mostrecent;
	
	@FindBy(xpath=("//input[@placeholder='Add More']"))
	public static WebElement addmore; //searchbar in SRP Page
	
	@FindBy(xpath=("//div[@class='auto-suggest__tag-close']"))
	public static WebElement cancelkeyword;
	
	@FindBy(xpath=("//input[@placeholder='Enter City, Locality, Project']"))
	public static WebElement Enter_keyword;
	
	@FindBy(xpath=("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]"))
	public static WebElement firststsuggestion;
	
	@FindBy(xpath=("//div[@class='autosuggest-overlay show']"))
	public static WebElement clickoutside;
	
	@FindBy(xpath=("//*[4]/div[1]/div[1]/div[1]/div[3]/h1[1]"))
	public static WebElement SRPheading;
	
	
	
	
	public Mb_srp()
	{
		PageFactory.initElements(driver, this);
	}


	public void srp_searchresult() throws Exception
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(srp_search_h1));

		String input= search_count.getText();
		String regex =  "\\d+(?=\\.)"; 
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(input); 

		// System.out.println("Extracted numbers:"); 
		while (matcher.find()) 
		{ 
			// System.out.println( matcher.find());
			String num=matcher.group(); 

			num1= Integer.parseInt(num);
			System.out.println(num1);
			// System.out.println(matcher.group()); 
		}
		if(num1<20000)
		{
			System.out.println("search results are less");
			Assert.assertTrue(false);

		}

		str=srp_search_h1.getText();
		//driver.findElement(By.xpath("//h1[contains(text(),'2 BHK Flats in Bangalore for Sale')]")).getText();
		System.out.println(str);
		Assert.assertEquals(str, "2 BHK Flats in " + prop.getProperty("city") + " for Sale","Assert pass");

	}


	public void postedbyowner()throws Exception
	{
		postedbyfilter.click();
		Thread.sleep(2000);
		ownerTag.click();
		doneCTA.click();
		Thread.sleep(3000);
		contact_CTA();
	}




	public void contact_CTA()throws Exception
	{
		JavaScriptExecutorUtils.scrollbottom(driver);

		try {
			Thread.sleep(2000);  // Wait for 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int total_CTA =contactCTA.size();

		for(int i=0;i<total_CTA; i++)
		{
			if (!contactCTA.get(i).getText().equals(owner)) {

				Assert.assertTrue(true);
				System.out.println(contactCTA.get(i) +" "+ contactCTA.get(i).getText());  // Print the text of the WebElement
			}

		}

	}

	public void srp_filters() throws Exception
	{

		//driver.get(prop.getProperty("url2"));
		toplocalities.click();
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
		Thread.sleep(4000);
		String str_builder =driver.findElement(By.xpath("//div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[7]/div[1]/div[2]/div[2]/span[1]")).getText(); 
		if (str_builder.contains("Contact Builder"))
		{
			Assert.assertTrue(true);
		}
		
		else if(str_builder.contains("Request Callback"))
		{
			Assert.assertTrue(true);
		}
		
		else 
		{
			Assert.assertTrue(false);
		}

	}

	public void srp_card()throws Exception
	{
		JavaScriptExecutorUtils.scrollbottom(driver);
		int t = SRPcard.size();
		Thread.sleep(3000);
		// Re-fetch updated elements
		List<WebElement> updatedCards = driver.findElements(
		    By.xpath("//div[contains(@class,'mb-srp__card__info mb-srp__card__info-withoutburger')]"));

		// Now you can use updatedCards.size(), etc.
		System.out.println("Total cards after scroll: " + updatedCards.size());
		
		updatedCards.get(1).click();
		Thread.sleep(2000);
		updatedCards.get(2).click();
		Thread.sleep(2000);
		updatedCards.get(21).click();
		Thread.sleep(2000);
		updatedCards.get(31).click();
		Thread.sleep(2000);
		updatedCards.get(40).click();
		
		/*
		 * System.out.println(t); SRPcard.get(1).click(); Thread.sleep(2000);
		 * SRPcard.get(2).click(); Thread.sleep(2000); SRPcard.get(21).click();
		 * Thread.sleep(2000); SRPcard.get(30).click(); Thread.sleep(2000);
		 * 
		 * SRPcard.get(40).click();
		 */

	}

	public void test_lowtohigh()
	{
		sortbydropdown.click();
		sortbylow_to_high.click();
		
		
	}
	
	public void test_hightolow()
	{
		sortbydropdown.click();
		sortbyhigh_to_low.click();
	}
	
	public void test_sortmostrecent()
	{

		sortbydropdown.click();
		updatephototext();

	}

	public int test_sortby()
	{
		String input= property_rate.getText();
		String regex = "\\d+"; 
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(input); 

		// System.out.println("Extracted numbers:"); 
		while (matcher.find()) 
		{ 
			// System.out.println( matcher.find());
			String num=matcher.group(); 

			num1= Integer.parseInt(num);
			System.out.println(num1);
			// System.out.println(matcher.group()); 
		}
		return num1;

	}

	public void updatephototext() 
	{

		String str= updatedtodaytext.getText();
		if(!str.contains("Updated today"))
		{
			Assert.assertTrue(false);
		}

	}
	
	public void search_new_keyword() throws InterruptedException 
	{
		
	addmore.click();
	cancelkeyword.click();
	Thread.sleep(2000);
	Enter_keyword.click();
	Thread.sleep(2000);
	Enter_keyword.click();
	Enter_keyword.sendKeys("greater noida");
	Thread.sleep(2000);
	firststsuggestion.click();
	Thread.sleep(2000);
	clickoutside.click();
	
	String heading= SRPheading.getText();
	System.out.println("this is the heading text add in git  " + heading);
	
	if(heading.contains("2 BHK Flats in"))
	{
		Assert.assertTrue(true);
	}
	
	else 
	{
		System.out.println("error occured , No such heading");
		Assert.assertTrue(false);
	}
	
	}
}




















