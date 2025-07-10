package listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;
    
    public static int passedCount = 0;
    public static int failedCount = 0;
    public static int skippedCount = 0;

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "YourName");
    }

    @Override
    public void onTestStart(ITestResult result) {
    	System.out.println("Test Listener Attached!");

    	String testName = result.getMethod().getMethodName();
        String testDescription = result.getMethod().getDescription();

        test = extent.createTest(testName, testDescription);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	
    	 passedCount++;
        test.pass("Test passed");
    }

 
    
    @Override
    public void onTestFailure(ITestResult result) {
    	  failedCount++;
    	  
        test.fail("Test failed: " + result.getThrowable());

        Object testInstance = result.getInstance();
        WebDriver driver = ((WebDriverProvider) testInstance).getDriver();

        try {
            String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            test.warning("Could not attach screenshot: " + e.getMessage());
        }
        
        skippedCount++;
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

        // Send email
        try {
            utils.EmailSend.sendEmailWithReport("rohit.negi@magicbricks.com");
        } catch (Exception e) {
            System.err.println("Failed to send report email: " + e.getMessage());
        }
        
        System.out.println("✅ Total: " + (passedCount + failedCount + skippedCount));
        System.out.println("✅ Passed: " + passedCount);
        System.out.println("❌ Failed: " + failedCount);
        System.out.println("⚠️ Skipped: " + skippedCount);
    }

   /* public String captureScreenshot(WebDriver driver, String methodName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String destPath = "test-output/screenshots/" + methodName + "_" + timestamp + ".png";
        FileUtils.copyFile(srcFile, new File(destPath));
        return destPath;
        }
        */
        

        public String captureScreenshot(WebDriver driver, String methodName) throws IOException
        {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String fileName = methodName + "_" + timestamp + ".png";
            String fullPath = "test-output/screenshots/" + fileName;

            // Save screenshot to full path
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(fullPath));

            // Return relative path to report
            return "screenshots/" + fileName;
        }

        
    

    // Your test classes must implement this to expose WebDriver
    public interface WebDriverProvider {
        WebDriver getDriver();
    }
}
