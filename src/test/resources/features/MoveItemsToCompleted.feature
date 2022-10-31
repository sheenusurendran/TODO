Feature: As a ToDo MVC user, I want to validate the functionality of adding items to Completed tab
  Scenario Outline: Verify that user is able to move items to Completed tab
    Given user is on Todoslist screen
    When user enters an "<Todoitem1>" and "<Todoitem2>"in What needs to be done? and pressed Enter key
    Then user should be displayed with All, Active and Completed buttons as enabled
    When user clicks on "<Todoitem1>"
    Then user should be displayed with "<Itemleft>" with item left
    When user clicks on Completed button
    Then user should be displayed with "<Todoitem1>"
    When user clicks on Active button
    Then user should be displayed with "<Todoitem2>"
    When user clicks on All button
    Then user should see the previously entered "<Todoitem1>" and "<Todoitem2>"

 Examples:
  |Todoitem1    |Itemleft|Todoitem2|
  |Download IDE |1       |SetupMaven|
