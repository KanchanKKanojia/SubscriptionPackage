package com.stctv.utils;

/**
 * @author : Kanchan.Kanojia
 */
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static final String REPORTS_DIRECTORY = "target/ExtentReport";
    private static final String REPORT_FILE = REPORTS_DIRECTORY + "/index.html";

    // Initialize the ExtentReports instance and configure it
    public static synchronized void initializeReport() {
        // Delete old reports if necessary
        deleteOldReports();

        // Initialize the ExtentSparkReporter with the path to the report file
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_FILE);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set system info for the report
        extent.setSystemInfo("Host Name", "STC TV Subscription Tests");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Kanchan Kanojia");
    }

    // Create a new test entry in the report
    public static synchronized ExtentTest createTest(String testName) {
        if (extent == null) {
            initializeReport();
        }
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest); // Set the ThreadLocal variable
        return extentTest;
    }

    // Get the current thread's ExtentTest instance
    public static ExtentTest getTest() {
        return test.get();
    }

    // Flush the reports and write them to the file
    public static synchronized void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }

    // Delete old report files
    private static void deleteOldReports() {
        File directory = new File(REPORTS_DIRECTORY);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".html")) {
                        file.delete();
                    }
                }
            }
        }
    }
}
