package examples;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

public class TestCase1Test extends BaseTest {

    public static final String TODO_TASK_TEXT = "TEST 1 - Learn how to automate tests";

    @Test
    public void TC01_addSingleTODOItem(){
        try (Playwright playwright = Playwright.create()) {
            // start Chromium browser using Playwright - playwright.chromium().launch(...)
            //      turn off headless mode to make it visible - setHeadless(false)
            //      add slow motion which will add 1000ms delay between actions - setSlowMo(1000)
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            // open new tab
            Page page = browser.newPage();

            // navigate to our test page
            page.navigate("https://antondedyaev.github.io/todo_list/");

            // click at the todo input
            page.getByPlaceholder("What needs to be done?").click();

            // enter name of 'todo' item
            page.getByPlaceholder("What needs to be done?").fill(TODO_TASK_TEXT);

            // hit enter to save new todo item
            page.keyboard().press("Enter");

            // Ensure that new item is added
            Locator todoListItemLocator = page.locator(".container__list .taskContainer");
            PlaywrightAssertions.assertThat(todoListItemLocator).hasCount(1);
            PlaywrightAssertions.assertThat(todoListItemLocator).containsText(TODO_TASK_TEXT);
        }
    }
}
