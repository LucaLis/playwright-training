package org.example.api;

import com.microsoft.playwright.*;

public class ApiCallExample {

    public static void main(String[] args) {
        // initialize Playwright
        try (Playwright playwright = Playwright.create()) {
            // Initialize context for API calls
            APIRequestContext requestContext = playwright.request().newContext();
            // Perform call GET reqeust on https://dummy.restapiexample.com/api/v1/employees and save response
            APIResponse response = requestContext.get("https://dummy.restapiexample.com/api/v1/employees");

            // Log response code and body in console
            System.out.println("API Response code: "+response.status());
            System.out.println("API Response body: "+response.text());
        }

    }

}
