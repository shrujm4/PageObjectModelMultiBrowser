package PageObjectModelMultiBrowserHW;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static gherkin.Parser.RuleType.Scenario;

public class Hooks extends BasePage {


BrowserSelector browserSelector = new BrowserSelector();
LoadProp prop = new LoadProp();

@Before

  public void setUPBrowser(){

browserSelector.setUpBrowser();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://demo.nopcommerce.com/");

}

  @After

  public void tearDown(Scenario scenario) {

    if (scenario.isFailed()) {
      TakesScreenshot ts = (TakesScreenshot) driver;
      File scrFile = ts.getScreenshotAs(OutputType.FILE);

      try {
        FileUtils.copyFile(scrFile, new File("src\\test\\Resources\\ScreenShots" + System.currentTimeMillis() + ".png"));
        System.out.println("ScreenShot Taken");
      } catch (IOException e) {
// TODO Auto-generated catch block
        e.printStackTrace();
      }

  }}




  @After
  public void closeBrowser(){

 driver.close();

}



}
