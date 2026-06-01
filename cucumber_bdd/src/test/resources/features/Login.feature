#Feature: verify Login functionality
#Scenario: verify user is able to login with valid credentials
#Given login page should be open in default browser
#When click on username field and add valid user username
#And then click on password button and enter valid password
#And now click on submit button
#Then login successfully and redirect to home page

Feature: Login functionality

  Scenario Outline: Login Data Driven
    Given User launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters email as "<email>" and password as "<password>"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on the Log out link
    Then Page Title should be "Your store. Login"
    And Close browser

    Examples:
      | email              | password  |
      | admin@gmail.com    | admin     |
      | admin123@gmail.com | admin123  |