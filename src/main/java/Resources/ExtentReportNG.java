package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    public  ExtentReports extentReports() {
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("Opencart");
        sparkReporter.config().setDocumentTitle("Test Results");

        ExtentReports reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        return reports;
    }
}
