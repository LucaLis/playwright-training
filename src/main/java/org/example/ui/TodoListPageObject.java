package org.example.ui;

import com.microsoft.playwright.*;

import java.util.List;

public class TodoListPageObject {

    private Page page;
    private Playwright playwright;

    public void navigateToTodoList() {

        playwright = Playwright.create();

        // start Chromium browser using Playwright - playwright.chromium().launch(...)
        //      turn off headless mode to make it visible - setHeadless(false)
        //      add slow motion which will add 1000ms delay between actions - setSlowMo(1000)
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

        // open new tab
        page = browser.newPage();

        // navigate to our test page
        page.navigate("https://antondedyaev.github.io/todo_list/");

    }


    public void addTodoItem(String todoName) {
        // click at the todo input
        page.getByPlaceholder("What needs to be done?").click();
        // enter name of 'todo' item
        page.getByPlaceholder("What needs to be done?").fill(todoName);
        // hit enter to save new todo item
        page.keyboard().press("Enter");
    }

    public void closePage() {
        playwright.close();
    }

    // 13.08. hometask - Mark even TODOs as Done
    public void markEvenTodosDone() {
        Locator locator = page.locator("//label[@for]");
        List<Locator> todos = locator.all();
        for (int i = 0; i < todos.size(); i++) {
            if ((i + 1) % 2 != 0) {
                todos.get(i).click();
            }
        }
    }

    // 13.08. hometask - Remove all Completed todos
    public void removeAllDoneTodos() {
        page.locator("//button[@data-testid=\"clear-all\"]").click();
    }
}
