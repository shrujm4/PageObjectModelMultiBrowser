Feature: User should be able to buy a product successfully when login
@Test
  Scenario: User is able to buy product successfully when logged in
    Given         User is on home
    And           Login successfully to an account for purchase
    When 	      select a product to buy
    And           proceed to checkout
    Then   	      User is able to buy a product successfully