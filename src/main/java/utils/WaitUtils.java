package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void explicit_wait1
	(WebDriver driver, By element1) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated((By)element1));


    }
	
	// Add this to your WaitUtils.java class
	public static WebElement waitForClickable(WebDriver driver, WebElement element) {
	    return new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(element));
	}
	


	public static WebElement explicit_wait(WebDriver driver, By locator) {
	    return new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
