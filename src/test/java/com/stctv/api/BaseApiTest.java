package com.stctv.api;

/**
 * @author : Kanchan.Kanojia
 */
import com.stctv.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        // Initialize Extent Report for the test
        extentTest.set(ExtentReportManager.createTest(getClass().getSimpleName()));

        // Set up RestAssured base URI (to be defined in subclasses or tests)
        setupRestAssured("https://api.restful-api.dev");
    }

    @AfterMethod
    public void tearDown() {
        // Flush Extent Reports
        ExtentReportManager.flushReports();
    }

    // Method to set up RestAssured base URI
    protected void setupRestAssured(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    // Get the current thread's ExtentTest instance
    protected ExtentTest getExtentTest() {
        return extentTest.get();
    }
}
