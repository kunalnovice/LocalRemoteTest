Feature: Guinea Pig comment

  @one
  Scenario: Can submit comment
    Given I am on the Guinea Pig homepage
    When I submit a comment
    Then I should see that comment displayed
