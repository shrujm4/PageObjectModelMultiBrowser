Feature: User should not be able to refer a product to a friend as a guest
  @Test 
  Scenario: :   User is not able to refer a product to a friend
    Given         User in on homepage as
    When 	      select a product to refer
    Then   	      User cannot refer a product as guest