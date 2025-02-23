Feature: login
  the system should facilitate the login for the user and prompt user is no successful login is made

  Scenario: logging in the user into the system
    Given User lands on the sign in page
    When the user keys in the username field his/her email id
    And the user keys in the password field his/her password
    Then the system should evaluate the user credentials
    And when the user credentials found valid
    Then the user should be taken to the home page.