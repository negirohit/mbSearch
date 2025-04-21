package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mbsearch.base.TestBase;

public class JavaScriptExecutorUtils {
	
	static JavascriptExecutor js;
	
	public static void scrollbottom(WebDriver driver) throws InterruptedException 
	  {
		
		 js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// Wait for 1 second (optional)
		Thread.sleep(1000);

	  }

	
	  public static void scrollToBottom(WebDriver driver) 
	  {
	        js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	  }
	  
	  public static void scrollToElement(WebDriver driver, WebElement element) 
	  {
		  
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	  
	  }
}
