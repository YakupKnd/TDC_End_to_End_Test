@wip
Feature: Diabetes Test

  Scenario: Diabetes End to End
    Given The user is on the "diabetes" page
    And The user goes through the whole diabetes funnel
    When The user makes a purchase from ClickBank
    And The user purchases "Healthy Kitchen" from first upsell page
    And The user purchases "Super Foods" from second upsell page
    And The user purchases "Body" from third upsell page
    Then Verify that the user has correct number of products
    And Verify that the user pays correct amount of money
    And Verify that the user can access all the products




