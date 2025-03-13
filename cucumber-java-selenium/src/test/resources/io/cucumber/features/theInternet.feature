Feature: The Internet
  This feature covers (some) Example pages on 'the-internet.herokuapp.com'

  @TEST_TI_0001
  Scenario: Homepage has a list of links to Expected examples
    Given the page under test is 'https://the-internet.herokuapp.com'
    And an example Home Page step
    And compare the list of links with 'src/test/resources/data.txt' file

  @TEST_TI_0001
  Scenario: Basic Auth allows validated access
    Given the page under test is 'https://the-internet.herokuapp.com'
    When the 'Basic Auth' example is opened
    And valid credentials are supplied
    Then Congratulations should be displayed

  @TEST_TI_0001
  Scenario: Sortable Data Tables - Example 1 displays the expected 4 results
    Given the page under test is 'https://the-internet.herokuapp.com'
    When the 'Sortable Data Tables' example is opened
    And Verify the Example 1 data on UI matches with following:
      | Last Name | First Name | Email                 | Due     | Web Site                 |
      | Smith     | John       | jsmith@gmail.com      | $50.00  | http://www.jsmith.com    |
      | Bach      | Frank      | fbach@yahoo.com       | $51.00  | http://www.frank.com     |
      | Doe       | Jason      | jdoe@hotmail.com      | $100.00 | http://www.jdoe.com      |
      | Conway    | Tim        | tconway@earthlink.net | $50.00  | http://www.timconway.com |

  @TEST_TI_0001
  Scenario: Expected examples
    Given the page under test is 'https://the-internet.herokuapp.com'
    And an example Home Page step
    When the 'A/B Testing' example is opened
    And check the AB test control page is displayed
    * Go back to home page
    When the 'Add/Remove Elements' example is opened
    Then Add Element and check element is added
    Then Delete Element and check element is deleted
    * Go back to home page
    When the 'Broken Images' example is opened
    And verify if images have broken links
    * Go back to home page
    When the 'Checkboxes' example is opened
    Then 'Check' checkbox1 and verify
    And 'Uncheck' checkbox2 and verify
    * Go back to home page
    When the 'Context Menu' example is opened
    And right click in the box and close the popup