#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Testing Contact us page functionality.

  @tag1
  Scenario: Contact link avaibility verification.
    Given User Launch Chrome Browser
    When user visits url ="https://prodigylabs.net/"
    Then Contact link should be available on the page
    And  User click on Contact link
    Then Page should display contact email ="info@prodigylabs.net" and address ="80 Richmond St. West, Suite 1401 Toronto, ON"
    And User fill out Firstname ="Milind" and Last Name ="Shah"
    When  User enters invalid email ="abc"
    Then Error message ="Email must be formatted correctly." is displayed
    And User enters correct email ="mkumar.shah9@gmail.com"
    And User select Industry as Banking from the dropdown
    And User Enter City as ="Toronto"
    Then User Submit the from
    
