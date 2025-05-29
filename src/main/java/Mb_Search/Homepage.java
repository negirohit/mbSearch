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

public class Homepage extends TestBase {
	
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
	
	@FindBy(xpath="//div[@id='tabRENT']")
	public static WebElement  search_rent;
	
	@FindBy(xpath="//div[@class='tab-animate__text amnime1']")
	public static WebElement  magicHomes;
	
	@FindBy(xpath="//div[@id='tabPG']")
	public static WebElement  Pg;
	
	@FindBy(xpath="//div[@id='tabPLOT']")
	public static WebElement  plot;
	
	@FindBy(xpath="//div[@id='tabCOMM']")
	public static WebElement  commercial;
	
	

	//@FindBy(xpath="//div[normalize-space()='hyderabad']")	
	/*
	 * @FindBy(xpath="//div[@id='serachSuggest']//div[2]") public static WebElement
	 * Auto_suggest;
	 */
	
	//@FindAll({@FindBy(xpath="//body/section[@id='searchFormHolderSection']/section[1]/div[1]/div[1]/div[3]/div[4]")})
	@FindBy(xpath="//div[@class='mb-search__btn']")
	public static WebElement  Search_button;
	
	//city from the header 
	@FindBy(xpath="//a[@class='mb-header__main__link js-menu-link'][normalize-space()='Mumbai']")
	public static WebElement  defaultciity;
	
	@FindBy(xpath="//div[@class='mb-home__section__title--text1 strip-red']")
	public static WebElement  first_widget;
	
	@FindBy(xpath="//div[contains(text(),' results |')]")
	public static WebElement search_count;
	
	@FindBy(xpath="//span[@id='postedByOwnersCount']")
	public static WebElement  owner_prop_widget;
	
	@FindBy(xpath="//span[@id='newProjectsCount']")
	public static WebElement  newProject_widget;
	
	@FindBy(xpath="//span[@id='readyToMoveFlatsCount']")
	public static WebElement  readyToMoveFlats_widget;
	
	@FindBy(xpath="//span[@id='budgetHomesCount']")
	public static WebElement  budgetHomes_widget;
	
	@FindBy(xpath="//div[normalize-space()='Popular Owner Properties']")
	public static WebElement  Popular_Owner_Prop;

	@FindBy(xpath="//div[@aria-label='1 / 8']//div[@class='mb-home__owner-prop__card--price']")
	public static WebElement  popularownerpropertieswidget1;
	
	@FindBy(xpath="//div[@aria-label='2 / 8']//div[@class='mb-home__owner-prop__card--price']")
	public static WebElement  popularownerpropertieswidget2;
	
	@FindBy(xpath="//div[@aria-label='3 / 8']//div[@class='mb-home__owner-prop__card--price']")
	public static WebElement  popularownerpropertieswidget3;
	
	@FindBy(xpath="//div[@aria-label='4 / 8']//div[@class='mb-home__owner-prop__card--price']")
	public static WebElement  popularownerpropertieswidget4;
	
	@FindBy(xpath="(//div[@class='mb-home__agent--name'])[1]")
	//@FindBy(xpath="//div[@aria-label='1 / 8']//span[@class='mb-home__agent--actbtn btn-red medium'][normalize-space()='View Properties']")	
	public static WebElement prfeeredagentswidget;
	
	@FindBy(xpath="//div[@aria-label='1 / 8']//div[@class='mb-home__agent--actcard']")
	public static WebElement prfeeredagent1;
	
	@FindBy(xpath="//a[normalize-space()='View All New projects']")
	public static WebElement new_homes;	
	By element1 =By.xpath("//a[normalize-space()='View All New projects']");
	
	@FindBy(xpath="//div[normalize-space()='Best Home Loan Deals']")
	public static WebElement property_service_home_Loan;	
	By element2 =By.xpath("//div[normalize-space()='Best Home Loan Deals']");
	
	@FindBy(xpath="//div[normalize-space()='Home Interiors']")
	public static WebElement property_service_home_Interior;
	By element3 = By.xpath("//div[normalize-space()='Home Interiors']");
	
	
	//@FindAll({@FindBy(xpath="//div[@class='mb-home__new-proj-gallery__card--content']")})
	//public static List <WebElement>  projectgallery;
	//By element4 = By.xpath("//div[@class='mb-home__new-proj-gallery__card--content']");
	
	@FindBy(xpath="//div[normalize-space()='Rustomjee']")
	public static WebElement projectgallery;
	By element4 = By.xpath("//div[normalize-space()='Rustomjee']");
	
	
	@FindBy(xpath="//div[@aria-label='5 / 9']//div[@class='mb-home__new-proj-gallery__card--content']")
	public static WebElement Project_Gallery2;
	By element5 = By.xpath("//div[@aria-label='5 / 9']//div[@class='mb-home__new-proj-gallery__card--content']");
	
/*	@FindAll({@FindBy(xpath="//div[@aria-label='2 / 10']//div[@class='mb-home__owner-exclusive-prop__card--graphic']")})
	public static List <WebElement>  Exl_owner_prop;
	By element6 = By.xpath("//*[@class='mb-home__owner-exclusive-prop__card--graphic']");*/
	
	@FindBy(xpath="//div[@aria-label='2 / 10']//div[@class='mb-home__owner-exclusive-prop__card--graphic']")
	public static WebElement Exl_owner_prop;
	By element6 = By.xpath("//div[@aria-label='2 / 10']//div[@class='mb-home__owner-exclusive-prop__card--graphic']");
	
	@FindBy(xpath="//div[normalize-space()='Rates & Trends']")
	public static WebElement RateTrends;
	//By element5 = By.xpath("//div[@aria-label='5 / 9']//div[@class='mb-home__new-proj-gallery__card--content']");
	
	@FindBy(xpath="//div[normalize-space()='EMI Calculator']")
	public static WebElement EMICalculator;

	@FindBy(xpath="//div[normalize-space()='Investment Hotspot']")
	public static WebElement InvestmentHotspot;
	
	@FindBy(xpath="//div[normalize-space()='Research Insights']")
	public static WebElement ResearchInsights;

	
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void defaultsearch_buy() throws Exception
	{
		Thread.sleep(2000);
		Search_button.click();		
		logger.info("Buy Search result page has opened");
		
	}	
	
	public void defaultsearch_Rent() throws Exception
	{
		search_rent.click();
		Thread.sleep(2000);		
		Search_button.click();		
	
		logger.info("Rent Search result page has opened");
	}
	
	public void defaultmagic_homes() throws Exception
	{
		Thread.sleep(2000);
	    magicHomes.click();
	   // Thread.sleep(2000);
	   // Search_button.click();	
	    logger.info("MagichomeSRP has opened");
	
	}
	
	public void defaultpg() throws Exception
	{
	
		Thread.sleep(2000);
		Pg.click();
	    Thread.sleep(2000);
	    Search_button.click();	
	    logger.info("PG SRP has opened");
	
	}
	
	public void defaultplot() throws Exception
	{
	
		Thread.sleep(2000);
		plot.click();
	    Thread.sleep(2000);
	    Search_button.click();	
	    logger.info("Plot SRP has opened");
	}
	
	public void defaultcommercial() throws Exception
	{
	
		Thread.sleep(2000);
		commercial.click();
	    Thread.sleep(2000);
	    Search_button.click();
	    logger.info("Commercial Page has opened");
	
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
		Auto_suggest.click();
		Thread.sleep(2000);
		System.out.println("element clicked");
		Search_button.click();		
		logger.info("search from homepage has done thourgh the keyword");
		
	}
	
	/*
	 * public void search() throws Exception { System.out.println("in search");
	 * cancel_searchkeyword.click(); Thread.sleep(2000); search_bar.click();
	 * Thread.sleep(2000); // Search_bar.sendKeys("hyderabad");
	 * search_bar.sendKeys(prop.getProperty("city")); //
	 * WaitUtils.explicit_wait(driver, autosuggestelement); Auto_suggest.click();
	 * Thread.sleep(2000); System.out.println("element clicked");
	 * Search_button.click();
	 * 
	 * }
	 */
	
	public static String defaultcity() 
	{
		city = defaultciity.getText();
		return city;
	}
	
	public static boolean firstWidget()
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
	
	
	public void ownerpropertyclick()
	{
		owner_prop_widget.click();
		logger.info("Click on ownerproperty ");
	}
	
	public void newProjectclick()
	{
		newProject_widget.click();
		logger.info("Click on newproject Widget "); 
	}
	
	public void readyToMoveFlatsclick()
	{
		readyToMoveFlats_widget.click();
		logger.info("Clicked on rerady to move to move property  ");
	}
	
	public void budgetHomeclick()
	{
		budgetHomes_widget.click();
		logger.info("Clicked on budget Home property ");
			    
	}
	
	public void popularownerproperty1() throws InterruptedException
	{
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Homepage.Popular_Owner_Prop);

	//	JavaScriptExecutorUtils.scrollToElement(driver, Homepage.Popular_Owner_Prop);
		popularownerpropertieswidget1.click();	
		logger.info("Clicked on popular property  ");
	}
	
	public void popularownerproperty2()
	{
		popularownerpropertieswidget2.click();
		logger.info("Clicked on 2nd popular property  ");
	}
	
	public void popularownerproperty3()
	{
		popularownerpropertieswidget3.click();
		logger.info("Clicked on 3rd popular property  ");	    
	}
	
	public void popularownerproperty4()
	{
		popularownerpropertieswidget4.click();
		logger.info("Clicked on 4th popular property  ");
			    
	}
	
	public void prfeeredagent() throws InterruptedException
	{
		
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Actions actions = new Actions(driver);

	        // hovered the preferrred agent 
	     //   WebElement hoverElement = driver.findElement(By.id("hoverMenu"));

	        // Perform hover action
	        actions.moveToElement(prfeeredagentswidget).perform();

	        // Wait for the element to appear after hovering
	        WebElement clickableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='1 / 8']//span[@class='mb-home__agent--actbtn btn-red medium'][normalize-space()='View Properties']")));

	        // Click the newly appeared element
	        clickableElement.click();
	        
	       
		//prfeeredagentswidget.click();



	}
	
	public void magichomes_widget() throws InterruptedException
	{
		Thread.sleep(2000);
		WaitUtils.explicit_wait(driver, element1);
		new_homes.click();
		logger.info("Clicked on Magichome Widget  ");
	}
	
	public void propertyservice_homeLoan() throws InterruptedException
	{
		Thread.sleep(2000);
		WaitUtils.explicit_wait(driver, element2);
        property_service_home_Loan.click();
        logger.info("Clicked on Homeloan widget  ");
	}
	
	public void propertyservice_Interior() throws InterruptedException
	{
		Thread.sleep(2000);
		WaitUtils.explicit_wait(driver, element3);
        property_service_home_Interior.click();
        logger.info("Clicked on Property service widget  ");
	}
	
	public void project_gallery_Widget() throws InterruptedException
	{
		Thread.sleep(2000);
		WaitUtils.explicit_wait(driver, element4);
		//projectgallery.get(0).click();
		projectgallery.click();
		logger.info("Clicked on Photogallery widget  ");

	}
	
	/*public void project_gallery_Widgetsecond() throws InterruptedException
	{
		Thread.sleep(2000);
		//	WaitUtils.explicit_wait(driver, element4);
		int prjno=projectgallery.size();
		System.out.println(prjno);
			projectgallery.get(3).click();
	
	}*/
	
	public void clickAllOwnerExclusivePropertyCards() throws InterruptedException {
		for (int i = 1; i <= 4; i++)
		{ // Assuming there are 4 images
			String dynamicXpath = "//div[@aria-label='" + i + " / 10']//div[@class='mb-home__owner-exclusive-prop__card--graphic']";
			WebElement element = driver.findElement(By.xpath(dynamicXpath));
			element.click();
			boolean bln = true;
			String str=driver.getTitle();
			if(str.isEmpty())
			{
				System.out.println(str);
				bln = false;
			}		
			Assert.assertEquals(bln, true);
			Thread.sleep(2000);	        
			driver.get( prop.getProperty("url"));
			try {
				Thread.sleep(1000); // Adding a small wait to prevent issues
			    } catch (InterruptedException e) {
				e.printStackTrace();
			}
		} logger.info("Clicked on Owner Exclusive property  ");
	}
	
	public void clickAllFreshPropertyCards() throws InterruptedException {
		for (int i = 1; i <= 4; i++) { 
			String dynamicXpath = "//div[@aria-label='1 / 8']//div[@class='mb-home__fresh-prop__card card-shadow']//img[@class='swiper-lazy swiper-lazy-loaded']";
			WebElement element = driver.findElement(By.xpath(dynamicXpath));
			element.click();
			boolean bln = true;
			String str=driver.getTitle();
			if(str.isEmpty())
			{
				System.out.println(str);
				bln = false;
			}		
			Assert.assertEquals(bln, true);
			Thread.sleep(2000);	        
			driver.get( prop.getProperty("url"));
			try {
				Thread.sleep(1000); 
			    } catch (InterruptedException e) {
				e.printStackTrace();
			}
		} logger.info("Clicked on Fresh Property Cards  ");
	}
	
	public void Exclusive_ownerWidget() throws InterruptedException
	{
		Thread.sleep(2000);
	//	WaitUtils.explicit_wait(driver, element4);
	//	int prjno=Exl_owner_prop.size();
	//	System.out.println("Total no of exclusive properties " + prjno);
		Exl_owner_prop.click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		 logger.info("Clicked on Exclusive Property Cards  ");
		
		/*
		 * for (WebElement element : Exl_owner_prop) {
		 * 
		 * System.out.println("Total no of exclusive properties " + element);
		 * //Thread.sleep(2000); // WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(10)); //
		 * wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		 * TabSwitch.tabswitch(); }
		 */
	}
	
	
	public void RateTrendsWidget() throws InterruptedException
	{
	
		RateTrends.click();
		 logger.info("Clicked on Rate and Trends Widget  ");
	}
	
	
	public void EMICalculatorWidget() throws InterruptedException
	{
	
		EMICalculator.click();
		 logger.info("Clicked on Emicalculater widget  ");
	
	}
	
	public void InvestmentHotspotWidget() throws InterruptedException
	{
	
		InvestmentHotspot.click();
		 logger.info("Clicked on Investment Hotspot  ");
	
	}
	
	public void ResearchInsightsWidget() throws InterruptedException
	{
	
		ResearchInsights.click();
		logger.info("Clicked on Research Insight widget  ");
	
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
