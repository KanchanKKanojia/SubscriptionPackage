package com.stctv.stepdefinitions;

/**
 * @author : Kanchan.Kanojia
 */
import com.stctv.pages.SubscriptionPage;
import com.stctv.utils.DriverFactory;
import com.stctv.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class SubscriptionTest {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private ThreadLocal<SubscriptionPage> subscriptionPage = new ThreadLocal<>();
    private ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @BeforeClass
    public void setupClass() {
        ExtentReportManager.initializeReport();
    }

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver using DriverFactory and set up page object
        WebDriver webDriver = DriverFactory.getDriver();
        driver.set(webDriver);
        subscriptionPage.set(new SubscriptionPage(webDriver));
        softAssert.set(new SoftAssert());
    }

    @Test(priority = 1)
    public void validateDataForSA() {
        // Start logging for the current test case
        extentTest.set(ExtentReportManager.createTest("Validate Data for Saudi Arabia"));
        subscriptionPage.get().navigateToSubscriptionPage("sa-en");
        extentTest.get().info("Navigated to the Saudi Arabia Subscription Page.");

        // Expected and actual subscription types validation
        List<String> expectedTypes = Arrays.asList("LITE", "CLASSIC", "PREMIUM");
        List<String> actualTypes = subscriptionPage.get().getSubscriptionTypes();
        extentTest.get().info("Fetched subscription types.");

        // Validate the subscription types
        softAssert.get().assertEquals(actualTypes, expectedTypes, "Subscription types for Saudi Arabia do not match.");
        if(actualTypes.equals(expectedTypes))
            extentTest.get().pass("Subscription types validated successfully for Saudi Arabia.");
        else
            extentTest.get().fail("Subscription types validation failed for Saudi Arabia.");

        // Expected and actual subscription prices validation
        List<Double> expectedPrices = Arrays.asList(15.0, 25.0, 60.0);
        List<Double> actualPrices = subscriptionPage.get().getSubscriptionPrices();
        extentTest.get().info("Fetched subscription prices.");

        // Validate the subscription prices
        softAssert.get().assertEquals(actualPrices, expectedPrices, "Subscription prices for Saudi Arabia do not match.");
        if(actualPrices.equals(expectedPrices))
            extentTest.get().pass("Subscription prices validated successfully for Saudi Arabia.");
        else
            extentTest.get().fail("Subscription prices validation failed for Saudi Arabia.");

        // Expected and actual currency validation
        String expectedCurrency = "SAR";
        String actualCurrency = subscriptionPage.get().getCurrency();
        extentTest.get().info("Fetched subscription currency.");

        // Validate the currency
        softAssert.get().assertEquals(actualCurrency, expectedCurrency, "Currency for Saudi Arabia does not match.");
        if(actualCurrency.equals(expectedCurrency))
            extentTest.get().pass("Subscription currency validated successfully for Saudi Arabia.");
        else
            extentTest.get().fail("Subscription currency validation failed for Saudi Arabia.");
    }

    @Test(priority = 2)
    public void validateDataForKuwait() {
        // Start logging for the current test case
        extentTest.set(ExtentReportManager.createTest("Validate Data for Kuwait"));
        subscriptionPage.get().navigateToSubscriptionPage("kw-en");
        extentTest.get().info("Navigated to the Kuwait Subscription Page.");

        // Expected and actual subscription types validation
        List<String> expectedTypes = Arrays.asList("LITE", "CLASSIC", "PREMIUM");
        List<String> actualTypes = subscriptionPage.get().getSubscriptionTypes();
        extentTest.get().info("Fetched subscription types.");

        // Validate the subscription types
        softAssert.get().assertEquals(actualTypes, expectedTypes, "Subscription types for Kuwait do not match.");
        if(actualTypes.equals(expectedTypes))
            extentTest.get().pass("Subscription types validated successfully for Kuwait.");
        else
            extentTest.get().fail("Subscription types validation failed for Kuwait.");

        // Expected and actual subscription prices validation
        List<Double> expectedPrices = Arrays.asList(1.2, 2.5, 4.8);
        List<Double> actualPrices = subscriptionPage.get().getSubscriptionPrices();
        extentTest.get().info("Fetched subscription prices.");

        // Validate the subscription prices
        softAssert.get().assertEquals(actualPrices, expectedPrices, "Subscription prices for Kuwait do not match.");
        if(actualPrices.equals(expectedPrices))
            extentTest.get().pass("Subscription prices validated successfully for Kuwait.");
        else
            extentTest.get().fail("Subscription prices validation failed for Kuwait.");

        // Expected and actual currency validation
        String expectedCurrency = "KWD";
        String actualCurrency = subscriptionPage.get().getCurrency();
        extentTest.get().info("Fetched subscription currency.");

        // Validate the currency
        softAssert.get().assertEquals(actualCurrency, expectedCurrency, "Currency for Kuwait does not match.");
        if(actualCurrency.equals(expectedCurrency))
            extentTest.get().pass("Subscription currency validated successfully for Kuwait.");
        else
            extentTest.get().fail("Subscription currency validation failed for Kuwait.");
    }


    @Test(priority = 3)
    public void validateDataForBahrain() {
        // Start logging for the current test case
        extentTest.set(ExtentReportManager.createTest("Validate Data for Bahrain"));
        subscriptionPage.get().navigateToSubscriptionPage("bh-en");
        extentTest.get().info("Navigated to the Bahrain Subscription Page.");

        // Expected and actual subscription types validation
        List<String> expectedTypes = Arrays.asList("LITE", "CLASSIC", "PREMIUM");
        List<String> actualTypes = subscriptionPage.get().getSubscriptionTypes();
        extentTest.get().info("Fetched subscription types.");

        // Validate the subscription types
        softAssert.get().assertEquals(actualTypes, expectedTypes, "Subscription types for Bahrain do not match.");
        if(actualTypes.equals(expectedTypes))
            extentTest.get().pass("Subscription types validated successfully for Bahrain.");
        else
            extentTest.get().fail("Subscription types validation failed for Bahrain.");

        // Expected and actual subscription prices validation
        List<Double> expectedPrices = Arrays.asList(2.0, 3.0, 6.0);
        List<Double> actualPrices = subscriptionPage.get().getSubscriptionPrices();
        extentTest.get().info("Fetched subscription prices.");

        // Validate the subscription prices
        softAssert.get().assertEquals(actualPrices, expectedPrices, "Subscription prices for Bahrain do not match.");
        if(actualPrices.equals(expectedPrices))
            extentTest.get().pass("Subscription prices validated successfully for Bahrain.");
        else
            extentTest.get().fail("Subscription prices validation failed for Bahrain.");

        // Expected and actual currency validation
        String expectedCurrency = "BHD";
        String actualCurrency = subscriptionPage.get().getCurrency();
        extentTest.get().info("Fetched subscription currency.");

        // Validate the currency
        softAssert.get().assertEquals(actualCurrency, expectedCurrency, "Currency for Bahrain does not match.");
        if(actualCurrency.equals(expectedCurrency))
            extentTest.get().pass("Subscription currency validated successfully for Bahrain.");
        else
            extentTest.get().fail("Subscription currency validation failed for Bahrain.");
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver after the test execution
        DriverFactory.quitDriver();

        // Assert all validations
        softAssert.get().assertAll();
        ExtentReportManager.flushReports();
    }
}
