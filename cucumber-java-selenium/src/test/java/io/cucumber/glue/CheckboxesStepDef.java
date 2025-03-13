package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.pages.Checkboxes;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CheckboxesStepDef extends Context {
    Checkboxes ch = new Checkboxes(manager.getDriver());

    public CheckboxesStepDef(Manager manager) {
        super(manager);
    }

    @Then("{string} checkbox{int} and verify")
    public void checkCheckboxAndVerify(String action, int arg0) {
        List<WebElement> boxes = ch.getCheckboxes();

        if (action.equals("Check") && arg0 <= boxes.size()) {
            boxes.get(arg0 - 1).click();
            Assert.assertTrue(boxes.get(arg0 - 1).isSelected());
        } else if (action.equals("Uncheck") && arg0 <= boxes.size()) {
            boxes.get(arg0 - 1).click();
            Assert.assertFalse(boxes.get(arg0 - 1).isSelected());
        } else
            System.err.println("Incorrect action or checkbox number provided in the Step");
    }
}
