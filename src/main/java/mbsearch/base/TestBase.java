package mbsearch.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Properties CONFIG;
	public static String homeloan;
	public SoftAssert softAssert = new SoftAssert();
	protected static final Logger logger = LogManager.getLogger(TestBase.class);
	public TestBase() {
		
		try {
		prop =new Properties();
        FileInputStream cn=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/Config.properties");
        prop.load(cn);
		}
		catch(FileNotFoundException e)
		{
		e.printStackTrace();	
		}
		catch(IOException e)
		{
		e.printStackTrace();
		}
	}
	
	public static void initilization()
	{
	
	// chromedriver manager Setup	
		WebDriverManager.chromedriver().setup();

		// Initialize WebDriver
		 driver = new ChromeDriver();
		 logger.info("Browser launched");
	     

		// Open a website
	//	driver.get("https://www.magicbricks.com");
		driver.manage().window().maximize();
		logger.info("Window maximized");

		try
		{
			// Switch to the alert
			Alert alert = driver.switchTo().alert();
			alert.dismiss(); // Clicks 'Cancel' or closes the alert

			System.out.println("Notification popup closed");
		} 
		catch (Exception e)
		
		{
			System.out.println("No notification popup found");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		logger.info("Magicbricks website has been opened");
		driver.get(prop.getProperty("url"));
		
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	
	
	
	