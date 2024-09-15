package com.stctv.api;

/**
 * @author : Kanchan.Kanojia
 */
import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {

    // Method to send a POST request and log with Extent Reports
    public static Response sendPostRequest(String endpoint, String requestBody, ExtentTest extentTest) {
        extentTest.info("Sending POST request to: " + endpoint);
        extentTest.info("Request payload: " + requestBody);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(endpoint);

        extentTest.info("Received response with status code: " + response.getStatusCode());

        // Log response body for debugging
        extentTest.info("Response body: " + response.getBody().asString());

        return response;
    }

    // Method to extract and validate response data with Extent Reports
    public static void validateResponse(Response response, String expectedName, String expectedYear, String expectedPrice, ExtentTest extentTest) {
        String responseBody = response.getBody().asString();
        if (response.getStatusCode() == 200) {
            boolean valid = responseBody.contains(expectedName) &&
                    responseBody.contains(expectedYear) &&
                    responseBody.contains(expectedPrice);

            if (valid) {
                extentTest.pass("Response validation successful. Expected data " + expectedName + " , " + expectedYear + " , " + expectedPrice + "found.");
            } else {
                extentTest.fail("Response validation failed. Expected data not " + expectedName + " , " + expectedYear + " , " + expectedPrice + "found.");
            }
        } else {
            extentTest.fail("Unexpected status code: " + response.getStatusCode());
        }
    }

    // Method to validate presence of specific fields with Extent Reports
    public static void validateFieldPresence(String fieldName, String fieldValue, ExtentTest extentTest) {
        if (fieldValue != null) {
            extentTest.pass(fieldName + " is present as: " + fieldValue);
        } else {
            extentTest.fail(fieldName + " should not be null");
        }
    }
}
