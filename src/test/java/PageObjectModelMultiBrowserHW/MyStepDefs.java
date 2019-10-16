package PageObjectModelMultiBrowserHW;

import cucumber.api.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {

  LoadProp prop = new LoadProp();
  HomePage homePage = new HomePage();
  RegistrationPage registrationPage = new RegistrationPage();
  LogInPage logInPage = new LogInPage();
  ReferAProductToFriend referAProductToFriend = new ReferAProductToFriend();
  ShoppingCart shoppingCart = new ShoppingCart();

//Register a User on nop commerce website
  @Given("User is on register page")
  public void user_is_on_register_page() {

    homePage.clickOnRegister();

  }

  @When("Enter all details for registration")
  public void enter_all_details_for_registration() {

    registrationPage.toVerifyUserIsOnRegisterPage();
    registrationPage.clickOnRegister();
  }

  @Then("User should be able to register successfully")
  public void user_should_be_able_to_register_successfully() {

registrationPage.toConfirmRegistrationSuccessfull();

  }


  //Refer a product to friend when loggged in

  @Given("User is on homepage")
  public void user_is_on_homepage() {

    homePage.clickOnLogin();

  }

  @Given("Login successfully to an account")
  public void login_successfully_to_an_account() {

    logInPage.checkLoginPageDisplayed();
    logInPage.clickLogin();
    logInPage.checkUserLoggedIn();

  }

  @When("select a product to refer to a friend")
  public void select_a_product_to_refer_to_a_friend() {

    referAProductToFriend.referProduct();

  }

  @Then("User is able to refer a product to a friend successfully")
  public void user_is_able_to_refer_a_product_to_a_friend_successfully() {

    referAProductToFriend.referSuccess();

  }

  //User should not be able to refer a product to friend if not logged in


    @Given("User in on homepage as")
    public void userInOnHomepageAs() {

    }




  @When("select a product to refer")
  public void selectAProductToRefer() {

    referAProductToFriend.cannotReferProduct();
  }

  @Then("User cannot refer a product as guest")
  public void userCannotReferAProductAsGuest() {
  referAProductToFriend.referFailed();

  }

  //Buy product when logged in


  @Given("User is on home")
  public void userIsOnHome() {
    homePage.clickOnLogin();

  }

  @And("Login successfully to an account for purchase")
  public void loginSuccessfullyToAnAccountForPurchase() {

    logInPage.checkLoginPageDisplayed();
    logInPage.clickLogin();
    logInPage.checkUserLoggedIn();
  }

  @When("select a product to buy")
  public void select_a_product_to_buy() {

    shoppingCart.addProductToCart();
    shoppingCart.addShoesToCart();

  }

  @When("proceed to checkout")
  public void proceed_to_checkout() {

    shoppingCart.shoppingCheckout();
    shoppingCart.paymentMethod();
    shoppingCart.paymentInformaiton();

  }

  @Then("User is able to buy a product successfully")
  public void user_is_able_to_buy_a_product_successfully() {
shoppingCart.orderPlaceCheck();
shoppingCart.continueToHomePage();
  }


  //Buy a product as guest

  @Given("User on home_page")
  public void userOnHome_page() throws InterruptedException {

    shoppingCart.guestCheckOut();

  }



  @When("select a product to buy as guest")
  public void selectAProductToBuyAsGuest() {
  }



  @And("proceed to checkout as guest")
  public void proceedToCheckoutAsGuest() {

    shoppingCart.paymentMethod();
    shoppingCart.paymentInformaiton();


  }




  @Then("User is able to buy a product successfully Guest")
  public void userIsAbleToBuyAProductSuccessfullyGuest() {

    shoppingCart.orderPlaceCheck();
    shoppingCart.continueToHomePage();
  }



}
