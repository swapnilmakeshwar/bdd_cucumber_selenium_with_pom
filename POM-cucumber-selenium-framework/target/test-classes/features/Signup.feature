Feature: User Signup and Login

  Scenario: Successful Signup and Login
    Given I navigate to the Magento signup page
    When I enter valid details and submit the form
    Then I should see a success message
    When I log in with the created account
    Then I should see my account dashboard