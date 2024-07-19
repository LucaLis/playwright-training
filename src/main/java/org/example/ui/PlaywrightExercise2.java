package org.example.ui;

import com.microsoft.playwright.*;

import java.util.List;

public class PlaywrightExercise2 {

    // Using code snippets from previous exercise:
    // 1. write a code that will add 100 todos with names: TODO#1 TODO#2... TODO#100
    // 2. change the delay value in setSlowMo to 1ms or remove it completely
    // 3. mark all TODOs with odd numbers as done
    // 4. switch the view on webpage from "All" to "Active" only (it should hide the done TODOs)
    // 5. Log to console number of TODOs displayed by "Active" view

    public static void main(String[] args) {
        // Initialize Playwright
        try (Playwright playwright = Playwright.create()) {
            // start Chromium browser using Playwright - playwright.chromium().launch(...)
            //      turn off headless mode to make it visible - setHeadless(false)
            //      add slow motion which will add 1000ms delay between actions - setSlowMo(1000)
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1));

            // open new tab
            Page page = browser.newPage();

            // navigate to our test page
            page.navigate("https://antondedyaev.github.io/todo_list/");

            // click at the todo input
            page.getByPlaceholder("What needs to be done?").click();

            // 1. write a code that will add 100 todos with names: TODO#1 TODO#2... TODO#100

            for (int i = 1; i <= 100; i++) {
                // click at the todo input
                page.getByPlaceholder("What needs to be done?").click();  //  //*[@data-testid="main-input"]
                // enter name of 'todo' item
                page.getByPlaceholder("What needs to be done?").fill("TODO# " + i);
                // hit enter to save new todo item
                page.keyboard().press("Enter");

            }

            // enter name of 'todo' item
            // page.getByPlaceholder("What needs to be done?").fill("Learn how to automate tests");

            // hit enter to save new todo item
            // page.keyboard().press("Enter");

            // keep browser open at the end of script for 5 seconds
            page.waitForTimeout(10000);


            Locator locator = page.locator("//label[@for]");
            List<Locator> todos = locator.all();
            for (int i = 0; i < todos.size(); i++) {
                if ((i + 1) % 2 != 0) {
                    todos.get(i).click();
                }
            }

            // keep browser open at the end of script for 5 seconds
            page.waitForTimeout(10000);
        }
    }


}
