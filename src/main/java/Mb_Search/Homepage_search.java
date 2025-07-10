package Mb_Search;

import java.time.Duration;
import java.util.Iterator;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import mbsearch.base.TestBase;
import utils.JavaScriptExecutorUtils;
import utils.TabSwitch;
import utils.WaitUtils;

public class Homepage_search extends TestBase {
	
	public static int num1;
	public static String str;
	private static final FluentWait<WebDriver> wait = null;
	public static String city;
	
	//HomePage locators
	
//	@FindBy(xpath="//*[@class='mb-search__tag-close']")
	@FindBy(xpath="//div[@class='mb-search__tag-close']")
	public static WebElement cancel_searchkeyword;
	
	@FindBy(xpath="//*[@id='creditScore']")
	public static WebElement entercreditscore;
	
	@FindBy(xpath="//input[@id='keyword']")
	public static WebElement  search_bar;
		
	public static WebElement  commercial;
	
	@FindBy(xpath="//div[@class='mb-search__btn']")
	public static WebElement  Search_button;
	
	//city from the header 
	@FindBy(xpath="//a[@class='mb-header__main__link js-menu-link'][normalize-space()='Mumbai']")
	public static WebElement  defaultciity;
	
	@FindBy(xpath="//div[@class='mb-home__section__title--text1 strip-red']")
	public static WebElement  first_widget;
	
	@FindBy(xpath="//div[contains(text(),' results |')]")
	public static WebElement search_count;
		
	@FindBy(xpath="//div[normalize-space()='Popular Owner Properties']")
	public static WebElement  Popular_Owner_Prop;

	@FindBy(xpath="//a[normalize-space()='View All New projects']")
	public static WebElement new_homes;	
	By element1 =By.xpath("//a[normalize-space()='View All New projects']");
	
	//this wiget is for navigate back to homepage from the srp page "because you have search hudrabad"
	@FindBy(xpath="//h2[@class='mb-home__section__title--text1 strip-orange']")
	public static WebElement homapage_back;
		
	
	
	public Homepage_search()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void defaultsearch_buy() throws Exception
	{
		Thread.sleep(2000);
		Search_button.click();		
		logger.info("Buy Search result page has opened");
		
	}	
	
	public void homepage_back() throws Exception
	{
		
	     String str = homapage_back.getText();	   
	     logger.info("the homepage text is " + str);
	     if(str.contains("Because you searched"))
	     {
	    	 Assert.assertTrue(true);
	     }
	}
	

		
	public void search() throws Exception
	{
		System.out.println("in search");
		cancel_searchkeyword.click();
		Thread.sleep(2000);
		search_bar.click();
		Thread.sleep(2000);
	//	Search_bar.sendKeys("hyderabad");
		search_bar.sendKeys(prop.getProperty("city"));
		WebElement Auto_suggest = driver.findElement(By.xpath("//div[@id='serachSuggest']//div[2]"));
		By element =By.xpath("//div[@id='serachSuggest']//div[2]");
		WaitUtils.explicit_wait(driver, element);
		PageFactory.initElements(driver, this);
		Auto_suggest.click();
		Thread.sleep(2000);
		System.out.println("element clicked");
		Search_button.click();		
		logger.info("search from homepage has done thourgh the keyword");
		
	}
	
	
	public static String defaultcity() 
	{
		city = defaultciity.getText();
		return city;
	}
	
	public boolean firstWidget()
	{
		String message=first_widget.getText();
		boolean bln = false;
		String str=first_widget.getText();
		
		if(str.contains("We've got properties"))
		{
		System.out.println(str);
		bln = true;
		}		
		return bln;
		
		
	}
	
	public void srp_searchresultvalidation() throws Exception
	{
		
	   String input= search_count.getText();
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
        String value = prop.getProperty("searchcount");
        int searchcount = Integer.parseInt(value);
        if(num1<searchcount)
        {
        	
        	System.out.println("search results are less");
        //	Assert.assertTrue(false);
        	softAssert.assertTrue(false); 
        	
        }
        logger.info("Search counch has been validated  ");
	}
	
		
	public Boolean refr()
	{ 
		boolean bln = false;
		String str=driver.findElement(By.xpath("//*[contains(text(),'Your reference no. is')]")).getText();
		if(str.contains("Your reference no. is"))
		{
		System.out.println(str);
		bln = true;
		}		
		return bln;
	}
 }
