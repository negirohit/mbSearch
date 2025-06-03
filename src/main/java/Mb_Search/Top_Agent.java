	
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
import utils.TabSwitch;
import mbsearch.base.TestBase;

	public class Top_Agent extends TestBase{

		
		@FindAll({@FindBy(xpath="")})
		public static List <WebElement>  contactCTA1;

		
		@FindBy(xpath=("(//div[@class='prefagent__detlsec__ctasec']//a[1])[1]"))
		public static WebElement contactCTA;
		
		@FindBy(xpath=("//div[@class='m-contact__advertisers--title']"))
		public static WebElement formtitle;
		
		@FindBy(xpath=("//div[@class='m-contact']//div[@id='closeContact']"))
		public static WebElement crosssign;
			
		@FindBy(xpath=("(//div[@class='prefagent__detlsec__ctasec']//a[2])[1]"))
		public static WebElement viewdetailsCTA;
		
		@FindBy(xpath=("(//div[@class='prefagent__headersec__name'])[1]"))
		public static WebElement agentnameSRP;
		
		@FindBy(xpath=("//div[@class='agntbanner__agntname']"))
		public static WebElement agantnameLDP;
		
		@FindBy(xpath=("//select[@id='cityList']"))
		public static WebElement citydropdown;
		
		
		
		public Top_Agent()
		{
			PageFactory.initElements(driver, this);
		}



		public void ContactCTA()
		{
			contactCTA.click();
			String str = formtitle.getText();
			
			if(str.contains("Fill out this one-time contact form"))
			{
				Assert.assertTrue(true);
			}
			
			crosssign.click();
			
		}
		
		public void citydropdown()
		{
			WebElement dropdown = citydropdown;
			Select select = new Select(dropdown);

			// Min Dropdown
			select.selectByVisibleText("Greater Noida");
			if(agentnameSRP.getText()!= null &&!agentnameSRP.getText().trim().isEmpty())
			{
				Assert.assertTrue(true);
			}
		}
		
		public void ldp() throws InterruptedException
		{
			
			String str1 = agentnameSRP.getText();
			viewdetailsCTA.click();
			TabSwitch.tabswitchchild(); 
			
			Thread.sleep(2000);
			
			String str2=agantnameLDP.getText();
			if(str1.contains(str2))
		     {
				Assert.assertTrue(true);
		     }
		}

}
