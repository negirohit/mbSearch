package Mb_Search;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import mbsearch.base.TestBase;
import utils.TabSwitch;

public class mbPDP extends TestBase {
	
	@FindBy(xpath=("(//div[@class='mghome__prjblk__locname'])[1]"))
	public static WebElement projectClick;
	
	@FindBy(xpath=("(//a[@class='mghome__prjblk__prjname'])[1]"))
	public static WebElement pdpName_inthumnail;
	
	@FindBy(xpath=("//div[@class='pdp__name']"))
	public static WebElement pdpName1;
	
	@FindBy(xpath=("//span[@class='pdp__cta outlined']"))
	public static WebElement download_brochureCTA;
	
	@FindBy(xpath=("(//span[@class='pdp__cta filled-red'][normalize-space()='Contact Builder'])[1]"))
	public static WebElement contact_builderCTA;
	
	@FindBy(xpath=("(//div[@class='contact-form__close'])[1]"))
	public static WebElement closeform;
	
	@FindBy(xpath=("//div[@class='pdp__pricecard--download']"))
	public static WebElement download_brochureCTA1;
	
	@FindAll({@FindBy(xpath=("//div[@class='pdp__prunitar--item']"))})
	public static List <WebElement>   Amminities_list;
	
	
	@FindBy(xpath=("(//span[@class='pdp__cta filled-red callCta'])[1]"))
	public static WebElement propContact_CTA;
	
	
	
	public mbPDP()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void detailPage() throws InterruptedException
	{  
		PageFactory.initElements(driver, this); 
		//projectClick.click();

		//String parentWindow = driver.getWindowHandle();
		
		//click on the the project thumbnail
		Thread.sleep(2000);
		String projectname = pdpName_inthumnail.getText();
		projectClick.click();
					
		TabSwitch.tabswitchchild(); 
		Thread.sleep(3000);
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
		
		download_brochureCTA.click();
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * 
		 * wait.until(ExpectedConditions.visibilityOf(download_brochureCTA));
		 * download_brochureCTA.click();
		 */

			String str1 = driver.findElement(By.xpath("//div[normalize-space()='Download brochure']")).getText();
			System.out.println(str1);
			Assert.assertTrue(str1.contains("Download brochure"));
			
			closeform.click();
		 			
			contact_builderCTA.click();
			
			contactform_Assertion();
			Thread.sleep(2000);
			closeform.click();
			
			download_brochureCTA1.click();
			String str3 = driver.findElement(By.xpath("//div[normalize-space()='Download brochure']")).getText();
			System.out.println(str3);
			Assert.assertTrue(str3.contains("Download brochure"));
			closeform.click();
	
	}

	
	public void specification() throws InterruptedException
	{
		System.out.println("in Value check" );
		Thread.sleep(2000);

		int listvaluesize=Amminities_list.size();
		System.out.println("in listvaluesize item" + listvaluesize );
		for(int i=1; i<listvaluesize ;i++)
		{
			System.out.println("item is" +Amminities_list.get(i).getText() );
			if (Amminities_list.get(i).getText()!= null && !Amminities_list.get(i).getText().trim().isEmpty())
			{
				Assert.assertTrue(true);
			}

			else 
			{
				Assert.assertTrue(false);
			}
	       }
	
	
	}
		public void Contact_CTA()
		{				
			propContact_CTA.click();
			contactform_Assertion();	
			String str2 = driver.findElement(By.xpath("//div[normalize-space()='Fill out this one-time form']")).getText();
			System.out.println(str2);
			Assert.assertTrue(str2.contains("Fill out this one-time form"));
			closeform.click();
			
		}
		
		public void ComprehensiveInforwidget()
		{	
			String str = driver.findElement(By.xpath("//div[@class='pdp__mostcomp__headtitle']")).getText();
			System.out.println(str);
			softAssert.assertEquals(str, "Most Comprehensive & Credible Information");
		}
			
		
		// method is used to validate the contact form and used in detailPage() and Contact_CTA method
		public void contactform_Assertion()
		{
			
			
			//Boolean xyz=driver.findElement(By.xpath("//div[@class='swiper-slide swiper-slide-active']//div[@class='pdp__marketExpt__card']")).isDisplayed();
			
			 // if(xyz==true) { softAssert.assertTrue(true); }
			
			
		}
		

		
		public void RatingWidget()
		{
		
			String rating = driver.findElement(By.xpath("//h2[@class='pdp__projreview__heading']")).getText();
			System.out.println(rating);
			Boolean xyz=driver.findElement(By.xpath("//h2[@class='pdp__projreview__heading']")).isDisplayed();
			if(xyz==true)
			{
				softAssert.assertTrue(true);
			}
			
		}
		
		public void buyerReviews()
		{
		
			String rating = driver.findElement(By.xpath("//div[normalize-space()='Buyer Reviews']")).getText();
			System.out.println(rating);
			Boolean xyz=driver.findElement(By.xpath("//div[normalize-space()='Buyer Reviews']")).isDisplayed();
			if(xyz==true)
			{
				softAssert.assertTrue(true);
			}
			
		}
		
		public void Map()
		{
		
			WebElement image = driver.findElement(By.xpath("//img[@title='map image']"));
			Assert.assertTrue(image.isDisplayed(), "Image is not visible on the page");
		
			Boolean xyz=driver.findElement(By.xpath("//*[@id='nearbylandmarksWeb']/h2")).isDisplayed();
			if(xyz==true)
			{
				softAssert.assertTrue(true);
			}
			
		}
		
}
	
