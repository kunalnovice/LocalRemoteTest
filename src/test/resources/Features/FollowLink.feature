Feature: Guinea Pig link

  @test1
  Scenario: Can follow link to another page
    Given I am on the Guinea Pig homepage
    When I click on the link
    Then I should be on another page

  @one
  Scenario: Can submit comment_new scenario
    Given I am on the Guinea Pig homepage
    When I submit Form
    Then I should see that comment displayed