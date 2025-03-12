package io.cucumber.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.time.Duration;

public class Home extends Context {

  public Home(Manager manager) {
    super(manager);
  }

  io.cucumber.pages.Home home= new io.cucumber.pages.Home(manager.getDriver());

  @Given("an example Home Page step")
  public void exampleHomePageStep() {
    System.out.println("printing shared stash :" + getTestStash().toString());
  }

  @When("the {string} example is opened")
  public void clickOnLink(String link){
    System.out.println("Clicking on Link: "+link);
    home.click(link);
    manager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }
  @And("check the AB test control page is displayed")
  public void check_the_ab_test_control_page() {
    Assert.assertTrue(home.getABTestControlHeadingWebEle().isDisplayed());
  }
}