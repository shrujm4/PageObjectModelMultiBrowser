Feature: User should be able to buy a product successfully as a guest
@Test
  Scenario: :   User is able to buy product successfully as a guest
    Given         User on home_page
    When 	      select a product to buy as guest
    And           proceed to checkout as guest
    Then   	      User is able to buy a product successfully Guest