package Mb_Search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import mbsearch.base.TestBase;
import utils.TabSwitch;

public class magichome_srp extends TestBase {
	
	int projectcount;
	
	@FindBy(xpath=("//div[@class='projdis__newprjs__title__txt']"))
	public static WebElement resultcount;	
	
	@FindBy(xpath=("(//span[@class='projdis__prjcard__cta projdis__prjcard__cta--solid '])[1]"))
	public static WebElement contactCTA;	
	
	@FindBy(xpath=("//div[@class='contact-form__close']"))
	public static WebElement formclose;
	
	
	@FindBy(xpath=("//input[@placeholder='Search Project']"))
	public static WebElement searchproject;
	
	@FindBy(xpath=("//div[@class='auto-suggest__drop-down__item']"))
	public static WebElement autosuggest;
	
	@FindBy(xpath=("(//div[@class='mghome__prjblk__locname'])[1]"))
	public static WebElement projectClick;
	
	@FindBy(xpath=("(//a[@class='mghome__prjblk__prjname'])[1]"))
	public static WebElement pdpName_inthumnail;
	
	@FindBy(xpath=("//div[@class='pdp__name']"))
	public static WebElement pdpName1;
	
	@FindBy(xpath=("(//div[contains(text(),'Bhk wise configuration')])[2]"))
	public static WebElement srpWidgetcard1;
	
	@FindBy(xpath=("(//div[contains(text(),'All Latest Reports from RERA')])[1]"))
	public static WebElement srpWidgetcard2;
	
	//@FindBy(xpath=("(//div[@class='mghome__linkblks__card__txt'])[2]"))
	@FindBy(xpath=("(//div[contains(text(),'View Now')])[2]"))
	public static WebElement srpWidgetcard3;
	
	@FindBy(xpath=("//div[@class='rera__lockstate__loginbtn']"))
	public static WebElement unlocknow;
	
	@FindBy(xpath=("//div[@class='contact-form__heading']"))
	public static WebElement Contacformtxt;
	
	
	public magichome_srp()
	{
		PageFactory.initElements(driver, this);
		
	}

	
	public void searchcount() throws InterruptedException 
	{
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);
		
		String Str=resultcount.getText();
		String regex = "\\d+"; 
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(Str); 

		// System.out.println("Extracted numbers:"); 
		while (matcher.find()) 
		{ 
			// System.out.println( matcher.find());
			String num=matcher.group(); 

			projectcount= Integer.parseInt(num);
			System.out.println(projectcount);
			// System.out.println(matcher.group()); 
		}
		if(projectcount<100)
		{
			System.out.println("search results are less");
			Assert.assertTrue(false);

		}
		
		contactCTA.click();
		formclose.click();
		
		driver.findElement(By.xpath("//div[contains(@class,\"mghome__filters\")]//div[contains(@class,\"\")][normalize-space()=\"Budget\"]")).click();
		driver.findElement(By.xpath("//div[@class='filter-budget__fieldset__min-max min']//select[@class='filter-budget__select']")).click();
		
		WebElement dropdown = driver.findElement(By.xpath("//div[@class='filter-budget__fieldset__min-max min']//select[@class='filter-budget__select']"));
		
		Select select = new Select(dropdown);

		// Min Dropdown
		select.selectByVisibleText("₹ 3 Cr");
		//Max dropdown
		driver.findElement(By.xpath("//div[contains(@class,\"filter-budget__fieldset__min-max max\")]//select[contains(@class,\"filter-budget__select\")]")).click();

		WebElement dropdown1 = driver.findElement(By.xpath("//div[contains(@class,\"filter-budget__fieldset__min-max max\")]//select[contains(@class,\"filter-budget__select\")]"));

		Select select1= new Select(dropdown1);
		select1.selectByVisibleText("₹ 4 Cr");

		driver.findElement(By.xpath("//div[@class='filterspop__cta']")).click();		
		driver.findElement(By.xpath("//div[@class='mghome__filters__block bhk  ']")).click();
		driver.findElement(By.xpath("//label[normalize-space()='3 BHK']")).click();
		driver.findElement(By.xpath("//div[@class='filterspop__cta']")).click();
		
	}

		public void search() throws InterruptedException 
		{
			driver.navigate().refresh();
			PageFactory.initElements(driver, this);
			Thread.sleep(3000);
			searchproject.click();	
			searchproject.sendKeys(prop.getProperty("project"));	
			autosuggest.click();
			Thread.sleep(3000);
			//projectClick.click();
		}
		
		public void Project_namevalidation() throws InterruptedException
		{
			//projectClick.click();
		
			String parentWindow = driver.getWindowHandle();
			
			//click on the the project thumbnail
			String projectname = pdpName_inthumnail.getText();
			projectClick.click();
						
			TabSwitch.tabswitchchild(); 
			PageFactory.initElements(driver, this); 		
			
			String str= pdpName1.getText();
			String projectName1  = str.replaceAll("\\s*\\d+\\s+Reviews?\\s*(\\d+(\\.\\d+)?)?$", "").trim();
	 			
			System.out.println("project name in SRP is " + projectname );
			System.out.println("project name in PDP is " + projectName1 );
			
			
			if(projectName1.contains(projectname))
			{
				Assert.assertTrue(true);
			}
			//this has to be checked currently this output is coming oth names are different expected [Ivory County 1 Review] but found [Ivory County]
			Assert.assertEquals(projectname, projectName1, "Both names are different" );
			driver.switchTo().window(parentWindow);
		}
		
		public void Srpcard() throws InterruptedException
		{
			String parentWindow = driver.getWindowHandle();
			Thread.sleep(2000);
			WebElement element1 = srpWidgetcard1;
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(500); // optional small wait
			element1.click();
		//	srpWidgetcard1.click();
			TabSwitch.tabswitchchild(); 
						
			unlocknow.click();
			
			rerapage();
			//closing the interior tab
			//driver.close();
			/*
			 * driver.switchTo().window(parentWindow); PageFactory.initElements(driver,
			 * this); Thread.sleep(3000);
			 * 
			 * srpWidgetcard2.click(); TabSwitch.tabswitchchild(); //closing the interior
			 * tab
			 * 
			 * Thread.sleep(3000); unlocknow.click(); rerapage(); driver.close();
			 */
			
			
			driver.switchTo().window(parentWindow);
			
			Thread.sleep(3000);
			
			PageFactory.initElements(driver, this);
			WebElement element = srpWidgetcard3;
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); // optional small wait
			element.click();

			//srpWidgetcard3.click();
			Thread.sleep(3000);
			String str= pdpName1.getText();
			if (str!= null && !str.trim().isEmpty())
			{
				Assert.assertTrue(true);
			}
			
			driver.switchTo().window(parentWindow);
			
		}
		
		public void rerapage()
		{

			String str= Contacformtxt.getText();
			String str1="Fill this one-time contact form";
		
			
			if(str1.contains(str))
			{
				Assert.assertTrue(true);
			}
			
			formclose.click();
		}
		
}
