package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.And;
import io.cucumber.pages.AddRemoveElement;
import org.testng.Assert;

public class AddRemoveStepDef extends Context {
    AddRemoveElement add,del;

    public AddRemoveStepDef(Manager manager) {
        super(manager);
    }

    @And("Add Element and check element is added")
    public void addAndVerifyElement(){
        add= new AddRemoveElement(manager.getDriver());
        add.addElement();
        Assert.assertEquals(add.noOfElementsPresent(),1);
        System.out.println("Element Added");
    }

    @And("Delete Element and check element is deleted")
    public void deleteAndVerifyElement(){
        del = new AddRemoveElement(manager.getDriver());
        del.deleteAllElement();
        Assert.assertEquals(del.noOfElementsPresent(),0);
        System.out.println("Element Deleted");
    }
}
