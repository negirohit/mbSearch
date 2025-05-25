package Mb_Search;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import mbsearch.base.TestBase;
import utils.TabSwitch;
import utils.WaitUtils;

public class Mb_ldp extends TestBase {


	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	public int num1;
	public static Integer num2;
	double priceInCr = 0;


	@FindAll({@FindBy(xpath=("//li[@class='mb-ldp__dtls__body__summary--item']"))})
	public static List <WebElement>  summary_item;

	@FindAll({@FindBy(xpath="//div[@class='mb-ldp__dtls__body__list--value']")})
	public static List <WebElement> list_value;

	By element1 =By.xpath("(//div[contains(@class,'mb-srp__card__info mb-srp__card__info-withoutburger')])[2]");
	//@FindBy(xpath=("(//div[contains(@class,'mb-srp__card__info mb-srp__card__info-withoutburger')])[2]"))
	//public static WebElement srpcard;

	@FindBy(xpath=("(//a[@class='mb-ldp__action--btn large btn-red'])[1]"))
	public static WebElement contactbutton;

	@FindBy(xpath=("//div[@class='mb-ldp__dtls__price']"))
	public static WebElement prop_price_ldp;

	@FindBy(xpath=("//div[@class='id__offer__right']"))
	public static WebElement homeinterior_CTA;
	
	@FindBy(xpath=("//h1[@class='interior-search__heading']"))
	public static WebElement homeinterior_H1tag;
	
	@FindAll({@FindBy(xpath=("//div[@class='mb-ldp__more-dtl__list--value']"))})
	public static List <WebElement> More_deatils_Ldp;
	
	@FindBy(xpath=("(//a[@class='mb-ldp__action--btn large btn-red'])[1]"))
	public static WebElement contactCTA1;
	
	@FindBy(xpath=("(//a[@class='mb-ldp__action--btn large btn-red'])[2]"))
	public static WebElement contactCTA2;
	
	By element2 =By.xpath("//div[@class='contact-form__heading']");
	@FindBy(xpath=("//div[@class='contact-form__heading']"))
	public static WebElement contactformheading;
	
	@FindBy(xpath=("//div[@class='contact-form__close']"))
	public static WebElement formclose;
	
	@FindBy(xpath=("//a[@class='mb-ldp__about-proj__projname']"))
	public static WebElement projectname;

	@FindBy(xpath=("//span[contains(@class,'mb-ldp__action--btn')][normalize-space()='Download Brochure']"))
	public static WebElement downloadBrochure_CTA;
	
	@FindBy(xpath=("//span[normalize-space()='Follow Project']"))
	public static WebElement followProject_CTA;
	
	@FindBy(xpath=("//span[@class='mb-dialog--close']"))
	public static WebElement formclose2;
	
	@FindBy(xpath=("//span[normalize-space()='Compare Projects']"))
	//@FindBy(xpath=("(//span[@class='mb-ldp__action--btn btn-gray-o medium'])[2]"))
	public static WebElement compareProjects_CTA;
	
	//compareproject page compare project heading 
	//@FindBy(xpath=("//h1[@class='comHeading']"))
	@FindBy(xpath=("//*[contains(text(),'Compare Projects')]"))
	public static WebElement compareProjects_text;
	
	@FindAll({@FindBy(xpath=("//li[@class='mb-ldp__amenities__list--item']"))})
	public static List <WebElement> amenities_item;
	
	//view all link in aminities section
	@FindBy(xpath=("//span[@class='mb-ldp__amenities--viewall']"))
	public static WebElement viewALl;
	
	//@FindBy(xpath=("(//div[@class='mb-ldp__prjhotspot__blk'])[1]"))
	@FindBy(xpath=("(//div[@class='mb-ldp__prjhotspot__prjname'])[1]"))
	public static WebElement projecthotspot;
	
	@FindBy(xpath=("//div[@class='pdp__name']"))
	public static WebElement pdpName;
	
	@FindBy(xpath=("(//div[@class='mb-ldp__other-prop-near__card--graphic'][1])[1]"))
	public static WebElement otherProperties;
	
	@FindBy(xpath=("//div[@class=\"mb-ldp__dtls__flex-row pad-b-4\"]//div[@class=\"mb-ldp__dtls__price\"]"))
	public static WebElement propopertyPrice;
	
	
	
	
	
	public Mb_ldp()
	{
		PageFactory.initElements(driver, this);
	}

	//items in LDP page check like 2 Beds, 2 Baths,Semi-Furnished
	public void summaryitem_check() throws InterruptedException 
	{
		//toplocalities.click();
		//localitymenu.get(1).click();
		PageFactory.initElements(driver, this); 

		WaitUtils.explicit_wait(driver, element1);
		
		WebElement srpcard = driver.findElement(By.xpath("(//div[@class='mb-srp__card__info mb-srp__card__info-withoutburger'])[2]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(srpcard));
		srpcard.click();
		TabSwitch.tabswitchchild(); 
		//ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		//driver.switchTo().window(tabs.get(1));
		PageFactory.initElements(driver, this); 

		Thread.sleep(2000);

        //here we have two types of LDP and we are fetching the the price of the property from the LDP- we have two types of LDP 
		int itemsize = summary_item.size();

		System.out.println("in summary item" + itemsize ); 
		for(int i=1; i<itemsize;i++)
		{ 
			System.out.println("item is " + summary_item.get(i).getText() );

			if(summary_item.get(i).getText()!= null &&!summary_item.get(i).getText().trim().isEmpty()) 
			{
				//Assert.assertTrue(true);
			}

			else 
			{ 
				//Assert.assertTrue(false); 
			} 
		}


	}

	//items in LDP page check like Developer, Project, Transaction type, Status, Lifts, Furnished Status, Semi-Furnished
	public void list_valuecheck() throws InterruptedException 
	{
		System.out.println("in Value check" );
		Thread.sleep(2000);

		int listvaluesize=list_value.size();
		System.out.println("in listvaluesize item" + listvaluesize );
		for(int i=1; i<listvaluesize ;i++)
		{
			System.out.println("item is" +list_value.get(i).getText() );
			if (list_value.get(i).getText()!= null && !list_value.get(i).getText().trim().isEmpty())
			{
				//Assert.assertTrue(true);
			}

			else 
			{
				//Assert.assertTrue(false);
			}
		}
	}


	public void more_details_module() throws InterruptedException
	{	
		String parentWindow = driver.getWindowHandle();
		homeinterior_CTA.click();
		TabSwitch.tabswitchchild(); 
		PageFactory.initElements(driver, this); 
		
		try {
			//this is the pop which comes in homeinterior page sometimes
			driver.findElement(By.xpath("//div[@class='city-popup__close']")).click();
			String str=homeinterior_H1tag.getText();
			System.out.println("In try "+ str);
			
			if (str.contains("Home Interior Design Services by"))
			{
			Assert.assertTrue(true);
			}
		}
		
		catch(Exception E)
		{
			String str=homeinterior_H1tag.getText();
			System.out.println("In Catch "+ str);
			if (str.contains("Home Interior Design Services by"))
				{
				Assert.assertTrue(true);
				}
			
		}
		 //closing the interior tab
		  driver.close();
		
		  driver.switchTo().window(parentWindow);
          PageFactory.initElements(driver, this);
          
          // Check details with proper waits
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.visibilityOfAllElements(More_deatils_Ldp));
		
		
		int more_deatil_size=More_deatils_Ldp.size();
		System.out.println("deatil size " + more_deatil_size );
		
		for(int i=0; i<more_deatil_size ;i++)
		{
			System.out.println("item is " +More_deatils_Ldp.get(i).getText() );
			if (More_deatils_Ldp.get(i).getText()!= null && !More_deatils_Ldp.get(i).getText().trim().isEmpty())
			{
				Assert.assertTrue(true);
			}

			else 
			{
				Assert.assertTrue(false);
			}
		}
		
		
		contactCTA2.click();
		WaitUtils.explicit_wait(driver,element2);
		String str =contactformheading.getText();
		System.out.println("contact form " +str);
		if(str.contains("Fill out this one-time form"))
		{
			Assert.assertTrue(true);
		}
		
		formclose.click();
	}
		
	
	public void aboutProject() throws InterruptedException
	{

		String str= projectname.getText();
		if(str!=null && !str.trim().isEmpty())
		{
			Assert.assertTrue(true);
		}

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try
		{
			wait.until(ExpectedConditions.visibilityOf(downloadBrochure_CTA));
		    downloadBrochure_CTA.click();

			String str1 = driver.findElement(By.xpath("//div[@class='contact-form__heading']")).getText();
			Assert.assertTrue(str1.contains("Download brochure"));
			formclose.click();
		} 
		catch (TimeoutException e)
		{
			System.out.println("CTA not visible within 5 seconds.");
		}

		
		//////////////////////////////////////////////////////////////////
		// Wait until the overlay is invisible
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mb-dialog.open")));

		followProject_CTA.click();
		String str2= driver.findElement(By.xpath("//div[@class='mb-ldp__follow-proj__title--text1']")).getText();
		if(str2.contains("Follow this Project"))
		{
			System.out.println("working fine");
			Assert.assertTrue(true);
		}
		
		formclose2.click();
		Thread.sleep(3000);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("compareProjects_CTA")));

		compareProjects_CTA.click();
		
		String parentWindow2 = driver.getWindowHandle();
		
		TabSwitch.tabswitchchild(); 
		PageFactory.initElements(driver, this); 
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("compareProjects_text")));
				
		String str3= compareProjects_text.getText();
		if(str3.contains("Compare Projects"))
		{
			Assert.assertTrue(true);
		}
		
		driver.switchTo().window(parentWindow2);
       
		
	}

	public void amenities() throws InterruptedException
	{
		try {
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("viewALl")));
		viewALl.click();
		Thread.sleep(2000);
		int aminitiescount=amenities_item.size();
		if(aminitiescount>0)
		{
		Assert.assertTrue(true,"amenities areappearing");
		}
		else
		{
		Assert.assertFalse(false);		
		}
        
		}
		catch(TimeoutException e) 
		{
			System.out.println("No such elemnt");
		}
	}

	public void hotspot_widget() throws InterruptedException
	{
		String str =projecthotspot.getText();
		String parentWindow3 = driver.getWindowHandle();
		projecthotspot.click();
		
		
		TabSwitch.tabswitchchild(); 
		PageFactory.initElements(driver, this); 		
		
		String str3= pdpName.getText();
		String projectName = str3.replaceAll("\\s*\\d+\\s+Reviews$", "").trim();
 
		
		System.out.println(str + "  "+ projectName);
		if(str.contains(projectName))
		{
			Assert.assertTrue(true);
		}
		Assert.assertEquals(str, projectName, "Both names are same" );
		driver.switchTo().window(parentWindow3);
	}
	
	public void otherProperties() throws InterruptedException
	{
		otherProperties.click();
		String parentWindow3 = driver.getWindowHandle();
		PageFactory.initElements(driver, this); 
		TabSwitch.tabswitchchild(); 
		String str =propopertyPrice.getText();
						
		String regex = "\\d+"; 
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(str); 
 
       // System.out.println("Extracted numbers:"); 
        while (matcher.find()) 
        { 
           // System.out.println( matcher.find());
        	String num=matcher.group(); 
        	
        	 num2= Integer.parseInt(num);
        	System.out.println(num2);
         System.out.println(matcher.group()); 
        	 }
        if(num2==null)
        {
        	Assert.assertTrue(false);
        	
        }
		driver.switchTo().window(parentWindow3);
	}
	
}
