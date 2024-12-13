package org.example.ui;

import com.microsoft.playwright.*;


public class PlaywrightExercise1 {

    // Copy the main method from WebPageAutomationExample and add following operations
    // 1. add 3 more TODOs
    // 2. log into console number of TODOs present on screen
    // 3. mark all todos as done
    // 4. clear all completed todos

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

            // First task add 3 more TODOs
            for (int i = 0; i < 4; i++) {
                // click at the todo input
                page.getByPlaceholder("What needs to be done?").click();
                // enter name of 'todo' item
                page.getByPlaceholder("What needs to be done?").fill("Learn how to automate tests");
                // hit enter to save new todo item
                page.keyboard().press("Enter");
            }

            // keep browser open at the end of script for 5 seconds
            page.waitForTimeout(5000);

            //Second task: log into console number of TODOs present on screen
            //get all elements with locator "list item"
            // Use a locator to find an element with a specific attribute
            Locator todoItemLocator = page.locator("//label[@for]");

            // Perform actions on each element
//            for (Locator todoItem : todoItemLocator.all()) {
//                String text = todoItem.textContent();
//            }
            //todoItemLocator.all().forEach(todoItem -> System.out.println(todoItem));
            //todoItemLocator.all().forEach(System.out::println);

            System.out.println("Number of todos on the list is " + todoItemLocator.all().size());

            //Third task: mark all todos as done
            // Go to all TODOs

//          for (Locator todoItem : todoItemLocator.all()) {
//              todoItem.click();
//          }
            //todoItemLocator.all().forEach(todoItem -> todoItem.click());
            todoItemLocator.all().forEach(Locator::click);
            page.waitForTimeout(5000);


            //Fourth task: clear all completed todos
            page.locator("//button[@data-testid=\"clear-all\"]").click();
            // check how many TODOs has left
            System.out.println(todoItemLocator.all().size());
        }

    }
}
