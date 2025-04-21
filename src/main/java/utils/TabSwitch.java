package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import mbsearch.base.TestBase;

//public class TabSwitch extends TestBase{
	
	
	public class TabSwitch extends TestBase{

	    public static void tabswitch() throws InterruptedException
	    {
	        String mainWindowHandle = driver.getWindowHandle();
	        System.out.println(mainWindowHandle);
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();

	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                Thread.sleep(2000);
	            }
	        }

	        System.out.println("Title of the new window: " + driver.getTitle());
	        driver.switchTo().window(mainWindowHandle);
	    }
	}
	
