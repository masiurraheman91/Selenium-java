Feature: Tutorial Ninja Full Flow

Background:
Given User opens website

@Smoke
Scenario: TutorialNinja all steps
When User registers account
And User logout after registration
And User login
And User search product
And User add product to cart
And User remove product from cart
Then User logout