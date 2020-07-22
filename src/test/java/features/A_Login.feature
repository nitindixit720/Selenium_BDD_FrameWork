Feature: Login Gmail
  This feature deals with login functionality of Gmail

  @sanity @regression
  Scenario: Gmail Login with the valid username and password
    Given A user is on the Gmail login page
    When  I enter the username "<Enter your user name>"
    And   I click on the next button
    And   I enter the password "<Enter your password>"
    And   I click on the final next button
    Then  I should see the welcome label on the page

