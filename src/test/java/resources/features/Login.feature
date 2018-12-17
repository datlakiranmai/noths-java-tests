Feature: Login
  As a customer
  I want to login to notonthehighstreet website

  Background:
    Given I enable the user account feature flag
    And I am on home page

  @1.01
  Scenario: Customer is able to successfully login to notonthehighstreet from homepage
    When I click on Signin from the header
    And I enter my login credentials
    Then I should login successfully
    And I should be taken to My details page

  @1.02
  Scenario: Customer is able to successfully login to notonthehighstreet from favourites page
    And I navigate to "/thelondongardentradingco/product/set-of-three-hanging-tealight-bubbles" product detail page
    And I add the product to my favourites
    When I click on Favourites from the header
    And I am redirected to My Favourites page
    And I click on My Faves icon
    And I click on Signin
    And I enter my login credentials
    Then I should login successfully
    And I should be taken to My details page


