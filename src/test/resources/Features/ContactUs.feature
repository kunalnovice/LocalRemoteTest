Feature: ContactUs.feature

  @one
  Scenario: Contact Us1
    Given I am on QAWorks Site
    Then I should be able to contact QA Works with the following information
    |name|J.Bloggs|
    |email|J.Bloggs@Qaworks.com|
    |message|Please contact me I want to find out more|


  @one
  Scenario: Picking Test Data from Proper File
    Given I am on QAWorks Site
    Then I should be able to contact QA Works with the following information
      |name|J.Bloggs|
      |email|J.Bloggs@Qaworks.com|
      |message|Please contact me I want to find out more|


  Scenario: Error Message id displayed
    Given I am on ContactUs Page
    When I submit empty ContactUs Page
    Then Error Message is displayed on COntactUs Page

  @one
  Scenario: some scenario- Exception failing scenario always
    Given I am on some Page
