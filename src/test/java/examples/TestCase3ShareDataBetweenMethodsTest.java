package examples;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestCase3ShareDataBetweenMethodsTest {

    // execute methods in alphabetical order - sorter ?
    // share the data across the methods - lifecycle - class?

    public String TODO_TASK_TEXT;
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeAll
    public void setup(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @AfterAll
    public void teardown(){
        browser.close();
    }

    @Test
    public void scenario_01_addSingleTODOItem(){
        // setting the value inside first test to ensure that it's visible in next test
        TODO_TASK_TEXT = "TEST 2 - Learn how to automate tests";
            // navigate to our test page
            page.navigate("https://antondedyaev.github.io/todo_list/");

            // click at the todo input
            page.getByPlaceholder("What needs to be done?").click();

            // enter name of 'todo' item
            page.getByPlaceholder("What needs to be done?").fill(TODO_TASK_TEXT);

            // hit enter to save new todo item
            page.keyboard().press("Enter");
    }

    @Test
    public void scenario_02_ensure_item_present(){
        // first of all lets check that value from test method 1 is visible in method 2
        Assertions.assertTrue(StringUtils.isNotBlank(TODO_TASK_TEXT),"Value from first test is not visible in test 2");

        // Now ensure that new item was added
        Locator todoListItemLocator = page.locator(".container__list .taskContainer");
        PlaywrightAssertions.assertThat(todoListItemLocator).hasCount(1);
        PlaywrightAssertions.assertThat(todoListItemLocator).containsText(TODO_TASK_TEXT);
    }
}
