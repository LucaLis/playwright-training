package org.example.ui;


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

        todoListPageObject.markEvenTodosDone();

        todoListPageObject.removeAllDoneTodos();

        todoListPageObject.closePage();


    }
}
