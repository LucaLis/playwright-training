package org.example.ui;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WebPageAutomationExample {

    public static void main(String[] args) {
        // Initialize Playwright
        try (Playwright playwright = Playwright.create()) {
            // start Chromium browser using Playwright - playwright.chromium().launch(...)
            //      turn off headless mode to make it visible - setHeadless(false)
            //      add slow motion which will add 1000ms delay between actions - setSlowMo(1000)
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

            // open new tab
            Page page = browser.newPage();

            // navigate to our test page
            page.navigate("https://antondedyaev.github.io/todo_list/");

            // click at the todo input
            page.getByPlaceholder("What needs to be done?").click();

            // enter name of 'todo' item
            page.getByPlaceholder("What needs to be done?").fill("Learn how to automate tests");

            // hit enter to save new todo item
            page.keyboard().press("Enter");

            // keep browser open at the end of script for 5 seconds
            page.waitForTimeout(5000);
        }
    }


}
