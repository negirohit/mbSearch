package listeners;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
        	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        	sparkReporter.config().setTheme(Theme.DARK);
        	sparkReporter.config().setDocumentTitle("Automation Report");
        	sparkReporter.config().setReportName("Search Module Test Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "YourName");
        }
        return extent;
    }
}




