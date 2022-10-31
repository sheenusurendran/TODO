Feature: As a ToDo MVC user, I want to validate the functionality of Clear Completed

  Scenario Outline: Verify that user is able to clear items one by one with Clear Completed button
    Given user is on Todoslist screen
    When user enters an "<Todoitem1>" and "<Todoitem2>"in What needs to be done? and pressed Enter key
    When user clicks on "<Todoitem1>"
    Then user should be displayed with the Cross button to delete
    Then user should be displayed with Clear Completed
    Then user should be displayed with "<Itemleft>" with item left
    When user clicks on Clear Completed button
    Then user should not be displayed with "<Todoitem1>"
    Then user should be displayed with "<Todoitem2>"

 Examples:
  |Todoitem1    |Itemleft|Todoitem2|
  |Download IDE |1       |SetupMaven|


Scenario Outline: Verify that user is able to clear all items together
    Given user is on Todoslist screen
    When user enters an "<Todoitem1>","<Todoitem2>" and "<Todoitem3>" in What needs to be done? and pressed Enter key
    When user clicks on Select All option
    Then user should be displayed with the Cross button to delete on the right
    Then user should be displayed with Clear Completed
    When user clicks on Clear Completed button
    Then user should not be displayed with "<Todoitem1>", "<Todoitem2>" and "<Todoitem3>"

 Examples:
  |Todoitem1    |Todoitem2 |Todoitem3|
  |Download IDE  |SetupMaven |Add Dependency|

  Scenario Outline: Verify that user is able to clear single TodoItem with Cross Button

      Given user is on Todoslist screen
      When user enters an "<Todoitem1>","<Todoitem2>" and "<Todoitem3>" in What needs to be done? and pressed Enter key
      When user clicks on Select All option
      Then user should be displayed with the Cross button to delete on the right
      When user clicks on Cross button against the first item
      Then user should not be displayed with "<Todoitem1>"
      Then user should be displayed with "<Todoitem2>" and "<Todoitem3>"

   Examples:
    |Todoitem1    |Itemleft|Todoitem2 |Todoitem3|
    |Download IDE |2       |SetupMaven |Add Dependency|