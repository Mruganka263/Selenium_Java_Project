package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.pages.BasicAuth;
import io.cucumber.util.CommonUtil;
import org.testng.Assert;

import java.io.IOException;

public class BasicAuthStepDef extends Context {

    public BasicAuthStepDef(Manager manager) {
        super(manager);
    }
    BasicAuth ba = new BasicAuth(manager.getDriver());

    @And("valid credentials are supplied")
    public void validCredentialsAreSupplied() throws IOException {
        String currentURL= manager.getDriver().getCurrentUrl();
        String sb = currentURL;
        sb= sb.substring(0,8)+
                CommonUtil.getConfigProperty("user")+
                ":"+CommonUtil.getConfigProperty("password")+"@"
                +sb.substring(8);
        System.out.println(sb);
        manager.getDriver().get(sb);
    }

    @Then("Congratulations should be displayed")
    public void congratulationsShouldBeDisplayed() {

        Assert.assertTrue(ba.getMessage().getText().contains("Congratulations"),"Not Authorized");
    }
}
