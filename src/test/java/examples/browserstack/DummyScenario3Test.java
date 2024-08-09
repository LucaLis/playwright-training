package examples.browserstack;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class DummyScenario3Test extends BaseTestViaBS {

    // TODO
    // 1. need to identify thread number
    // 2. Create PW instance once per thread and reuse it in all tests
    // 3. do a proper cleanup when instance of PW is reused

    // execute methods in alphabetical order - sorter ?
    // share the data across the methods - lifecycle - class?

    public String TODO_TASK_TEXT;

    @Test
    public void scenario_01_addSingleTODOItem() {
        // setting the value inside first test to ensure that it's visible in next test
        TODO_TASK_TEXT = "TEST 2 - Learn how to automate tests";
        // navigate to our test page
        getPage().navigate("https://antondedyaev.github.io/todo_list/");

        // click at the todo input
        getPage().getByPlaceholder("What needs to be done?").click();

        // enter name of 'todo' item
        getPage().getByPlaceholder("What needs to be done?").fill(TODO_TASK_TEXT);

        // hit enter to save new todo item
        getPage().keyboard().press("Enter");
    }

    @Test
    public void scenario_02_ensure_item_present() {
        // first of all lets check that value from test method 1 is visible in method 2
        Assertions.assertTrue(StringUtils.isNotBlank(TODO_TASK_TEXT), "Value from first test is not visible in test 2");

        // Now ensure that new item was added
        Locator todoListItemLocator = getPage().locator(".container__list .taskContainer");
        PlaywrightAssertions.assertThat(todoListItemLocator).hasCount(1);
        PlaywrightAssertions.assertThat(todoListItemLocator).containsText(TODO_TASK_TEXT);
    }
}
