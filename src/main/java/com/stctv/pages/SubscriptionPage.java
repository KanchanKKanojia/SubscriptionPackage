package com.stctv.pages;

/**
 * @author : Kanchan.Kanojia
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for subscription elements
    private By subscriptionType = By.xpath("//strong[contains(@id,'name')]");
    private By subscriptionPrice = By.xpath("//div[contains(@class, 'price')]/b");
    private By currency = By.xpath("//div[contains(@class, 'price')]/i");

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigate to subscription page based on country
    public void navigateToSubscriptionPage(String countryCode) {
        driver.get("https://subscribe.stctv.com/" + countryCode);
    }

    // Get subscription types displayed on the page
    public List<String> getSubscriptionTypes() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionType));
        List<WebElement> typeElements = driver.findElements(subscriptionType);
        List<String> types = new ArrayList<String>();
        for (WebElement typeElement : typeElements) {
            types.add(typeElement.getText());
        }
        return types;
    }

    // Get subscription prices displayed on the page
    public List<Double> getSubscriptionPrices() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionPrice));
        List<WebElement> priceElements = driver.findElements(subscriptionPrice);
        List<Double> prices = new ArrayList<Double>();
        for (WebElement priceElement : priceElements) {
            try {
                prices.add(Double.parseDouble(priceElement.getText().replaceAll("[^\\d.]", "")));
            } catch (NumberFormatException e) {
                System.err.println("Error parsing price: " + priceElement.getText());
            }
        }
        return prices;
    }

    // Get the currency displayed with the subscription prices
    public String getCurrency() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(currency));
        WebElement currencyElement = driver.findElement(currency);
        return currencyElement.getText().trim().replaceAll("/month", "").trim();
    }
}
