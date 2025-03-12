Feature: The Internet
  This feature covers (some) Example pages on 'the-internet.herokuapp.com'

  @TEST_TI_0001
  Scenario: Homepage has a list of links to Expected examples
    Given the page under test is 'https://the-internet.herokuapp.com'
    And an example Home Page step
#    When the 'A/B Testing' example is opened
#    And check the AB test control page is displayed
#    * Go back to home page
#    When the 'Add/Remove Elements' example is opened
#    Then Add Element and check element is added
#    Then Delete Element and check element is deleted
#    * Go back to home page
#    When the 'Broken Images' example is opened
#    And verify if images have broken links
#    * Go back to home page
#    When the 'Challenging DOM' example is opened
#    Then test
#    * Go back to home page
    When the 'Checkboxes' example is opened
    Then Check checkbox1 and verify
    And Uncheck checkbox2 and verify

  @TEST_TI_0001
  Scenario: Basic Auth allows validated access
    Given the page under test is 'https://the-internet.herokuapp.com'
    When the 'Basic Auth' example is opened
    And valid credentials are supplied
    Then Congratulations should be displayed
#
#  @TEST_TI_0001
#  Scenario: Sortable Data Tables - Example 1 displays the expected 4 results
#    Given the page under test is 'Sortable Data Tables'
#    And add other steps