Feature: Guinea Pig comment

  @test
  Scenario: Can submit comment Kunal
    Given I am on the Guinea Pig homepage
    When I submit Form
    Then I should see that comment displayed

