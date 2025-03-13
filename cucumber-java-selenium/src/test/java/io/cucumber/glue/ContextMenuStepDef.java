package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.And;
import io.cucumber.pages.ContextMenu;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ContextMenuStepDef extends Context {
    ContextMenu cm = new ContextMenu(manager.getDriver());

    public ContextMenuStepDef(Manager manager) {
        super(manager);
    }

    @And("right click in the box and close the popup")
    public void rightClickInTheBoxAndCloseThePopup() {
        Actions actions = new Actions(manager.getDriver());
        actions.contextClick(cm.getContextMenuBoxElement()).perform();
        System.out.println("Right-click performed on input box");
        Alert alert = manager.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }
}
