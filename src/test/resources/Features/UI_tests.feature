#This feature file consists of all the Tests on Lego.com - assignment
#tag name is used to uniquely identify a test case feature/scenario
# To run a case please update the tag name in Test Runner configuration file (path:<current project directory>/src/test/java/StepDefinitions/TestRunner.java)

@AssignmentScenarios
Feature: Tests on Lego.com - assignment

  @AssignmentScenario1
  Scenario: 1. Lego site- Filter products and add product to cart
    Given I navigate to Lego site
    When add filters for the products displayed
    Then verify the number of results
    Then check article name and price
    Then add the product to cart verify details and proceed to checkout
   
   
   
   