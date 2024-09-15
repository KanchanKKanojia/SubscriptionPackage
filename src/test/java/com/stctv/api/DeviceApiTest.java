package com.stctv.api;

/**
 * @author : Kanchan.Kanojia
 */
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeviceApiTest extends BaseApiTest {

    private static final String API_ENDPOINT = "/objects"; // Example endpoint

    @Test
    public void validateAddNewDevice() {
        // Request payload
        String requestPayload = "{\n" +
                "    \"name\": \"Apple Max Pro 1TB\",\n" +
                "    \"data\": {\n" +
                "        \"year\": 2023,\n" +
                "        \"price\": 7999.99,\n" +
                "        \"CPU model\": \"Apple ARM A7\",\n" +
                "        \"Hard disk size\": \"1 TB\"\n" +
                "    }\n" +
                "}";

        // Send POST request and validate response
        Response response = ApiUtils.sendPostRequest(API_ENDPOINT, requestPayload, getExtentTest());

        // Validate the response
        ApiUtils.validateResponse(response, "Apple Max Pro 1TB", "2023", "7999.99", getExtentTest());

        // Extract and validate 'id' and 'createdAt' fields
        String id = response.jsonPath().getString("id");
        String createdAt = response.jsonPath().getString("createdAt");

        ApiUtils.validateFieldPresence("ID", id, getExtentTest());
        ApiUtils.validateFieldPresence("CreatedAt", createdAt, getExtentTest());

        getExtentTest().info("Test execution completed");
    }
}
