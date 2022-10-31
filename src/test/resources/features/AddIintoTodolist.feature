Feature: As a ToDo MVC user, I want to validate the All , Active and Completed tab when item is added
Scenario Outline: Verify that user is able to add items in to ToDo list successfully and All tab is updated

    Given user is on Todoslist screen
    When user enters an "<Todoitem1>" and "<Todoitem2>"in What needs to be done? and pressed Enter key
    Then user should be displayed with "<Todoitem1>" and "<Todoitem2>" in the Todo list
    And user should be displayed with the item left and "<ItemCount>"
    And user should be displayed with All, Active and Completed buttons as enabled
    And user should be displayed with right Checkboxes "<ItemCount>"
    Examples:
    |Todoitem1    |Todoitem2  | ItemCount|
    |Download IDE |Setup Maven| 2       |


Scenario Outline: Verify that user is able to see all the Active items in Active section

    Given user is on Todoslist screen
    When user enters an "<Todoitem1>" and "<Todoitem2>"in What needs to be done? and pressed Enter key
    When user Clicks on Active section
    Then user should see the previously entered "<Todoitem1>" and "<Todoitem2>"
    And user should be displayed with the item left and "<ItemCount>"
    And user should be displayed with All, Active and Completed buttons as enabled
    Examples:
    |Todoitem1    |Todoitem2  | ItemCount|
    |Download IDE |Setup Maven| 2        |


  Scenario Outline: Verify that Completed tab is empty if items are not selected as Completed

        Given user is on Todoslist screen
        When user enters an "<Todoitem1>" and "<Todoitem2>"in What needs to be done? and pressed Enter key
        When user Clicks on Completed section
        Then user should see not the previously entered "<Todoitem1>" and "<Todoitem2>"
        Then user should be displayed with the item left and "<ItemCount>"
        And user should be displayed with All, Active and Completed buttons as enabled

        Examples:
        |Todoitem1    |Todoitem2  | ItemCount|
        |Download IDE |Setup Maven| 2   |