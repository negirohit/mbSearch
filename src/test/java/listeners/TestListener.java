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

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

 
    
    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test failed: " + result.getThrowable());

        Object testInstance = result.getInstance();
        WebDriver driver = ((WebDriverProvider) testInstance).getDriver();

        try {
            String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            test.warning("Could not attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
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
