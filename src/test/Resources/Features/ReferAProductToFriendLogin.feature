Feature: User should be able to refer a product to a friend successfully while login
  @Test
  Scenario: :   User is able to refer a product to a friend successfully
    Given         User is on homepage
    And           Login successfully to an account
    When 	      select a product to refer to a friend
    Then   	      User is able to refer a product to a friend successfully