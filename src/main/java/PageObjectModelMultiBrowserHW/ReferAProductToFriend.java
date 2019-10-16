package PageObjectModelMultiBrowserHW;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ReferAProductToFriend  extends Utils{

  LoadProp prop = new LoadProp();

  private By _macBookImage = By.xpath("//img[@alt=\"Picture of Apple MacBook Pro 13-inch\"]");
  private By _emailAFriendButton = By.xpath("//input[@value=\"Email a friend\"]");
  private By _friendEmailField = By.className("friend-email");
  private By _yourEmailField = By.className("your-email");
  private By _personalMessage = By.id("PersonalMessage");
  private By _sendEmailButton = By.name("send-email");

  private By _errorMessage = By.xpath("//li[text()=\"Only registered customers can use email a friend feature\"]");
  private By _personalErrorMessage = By.xpath("//textarea[@id=\"PersonalMessage\"]");
  private By _compareResult = By.className("result");

public void referProduct(){

  clickElement(_macBookImage);
  clickElement(_emailAFriendButton);
  enterText(_friendEmailField,prop.getProperty("refer"));
  enterText(_personalMessage, prop.getProperty("MSS"));
  clickElement(_sendEmailButton);


  }

  public void referSuccess(){

    Assert.assertEquals(getTextFromElement(_compareResult),"Your message has been sent.");

  }


public void cannotReferProduct(){

  clickElement(_macBookImage);
  clickElement(_emailAFriendButton);
  enterText(_friendEmailField, prop.getProperty("refer"));
  enterText(_yourEmailField,prop.getProperty("loginTXT"));
  enterText(_personalMessage,prop.getProperty("MSS"));
  clickElement(_sendEmailButton);



}
public void referFailed(){

  Assert.assertEquals(getTextFromElement(_errorMessage),"Only registered customers can use email a friend feature");

}



}


