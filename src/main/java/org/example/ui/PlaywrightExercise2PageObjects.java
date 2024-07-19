package org.example.ui;

import com.microsoft.playwright.*;


public class PlaywrightExercise2PageObjects {

    // Copy the main method from WebPageAutomationExample and add following operations
    // 1. add 3 more TODOs
    // 2. log into console number of TODOs present on screen
    // 3. mark all todos as done
    // 4. clear all completed todos

    public static void main(String[] args) {

        TodoListPageObject todoListPageObject = new TodoListPageObject();

        todoListPageObject.navigateToTodoList();

        todoListPageObject.addTodoItem("TODO 1");
        todoListPageObject.addTodoItem("TODO 2");
        todoListPageObject.addTodoItem("TODO 3");
        todoListPageObject.addTodoItem("TODO 4");

        todoListPageObject.closePage();


//            // First task add 3 more TODOs
//            for (int i = 0; i < 4; i++) {
//                // click at the todo input
//                page.getByPlaceholder("What needs to be done?").click();
//                // enter name of 'todo' item
//                page.getByPlaceholder("What needs to be done?").fill("Learn how to automate tests");
//                // hit enter to save new todo item
//                page.keyboard().press("Enter");
//            }
//
//            // keep browser open at the end of script for 5 seconds
//            page.waitForTimeout(5000);
//
//            //Second task: log into console number of TODOs present on screen
//            //get all elements with locator "list item"
//            // Use a locator to find an element with a specific attribute
//            Locator locator = page.locator("//label[@for]");
//            locator.all().size();
//            //  List<ElementHandle> elements = locator.elementHandles();
//            //  elements.size();
//
//            // Perform actions on each element
////            for (Locator element : locator.all()) {
////                String text = element.textContent();
////            }
//            //locator.all().forEach(element -> System.out.println(element));
//            locator.all().forEach(System.out::println);
//
//            System.out.println("Sum of elements on the list is " +locator.all().size());
//
//            //Third task: mark all todos as done
//            // Go to all TODOs
//
////            for (Locator element: locator.all()) {
////                element.click();
////            }
//            //locator.all().forEach(element -> element.click());
//            locator.all().forEach(Locator::click);
//
//
//            //Fourth task: clear all completed todos
//            page.locator("//button[@data-testid=\"clear-all\"]").click();
//            // check how many TODOs has left
//            System.out.println(locator.all().size());
//        }

    }
}