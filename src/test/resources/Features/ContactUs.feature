Feature: ContactUs.feature


  Scenario: Contact Us1
    Given I am on QAWorks Site
    Then I should be able to contact QA Works with the following information
    |name|J.Bloggs|
    |email|J.Bloggs@Qaworks.com|
    |message|Please contact me I want to find out more|

  @one
  Scenario: some scenario- Exception failing scenario always
    Given I am on some Page
