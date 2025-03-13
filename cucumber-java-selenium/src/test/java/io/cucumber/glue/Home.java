package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Home extends Context {

    public Home(Manager manager) {
        super(manager);
    }

    io.cucumber.pages.Home home = new io.cucumber.pages.Home(manager.getDriver());

    @Given("an example Home Page step")
    public void exampleHomePageStep() {
        System.out.println("printing shared stash :" + getTestStash().toString());
    }

    @When("the {string} example is opened")
    public void clickOnLink(String link) {
        System.out.println("Clicking on Link: " + link);
        home.click(link);
    }

    @And("check the AB test control page is displayed")
    public void check_the_ab_test_control_page() {
        Assert.assertTrue(home.getABTestControlHeadingWebEle().isDisplayed());
    }

    @And("compare the list of links with {string} file")
    public void compareTheListOfLinksWithDataFile(String filename) throws IOException {
        List<String> actualList = home.getAllLinksText();
        List<String> expectedList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            expectedList.add(line);
        }

        SoftAssert softAssert = new SoftAssert();

        for (String s : actualList) {
            softAssert.assertTrue(expectedList.contains(s), s + " not present");
        }
        softAssert.assertAll();

    }
}