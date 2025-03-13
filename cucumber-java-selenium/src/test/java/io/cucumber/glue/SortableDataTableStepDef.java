package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.pages.SortableDataTable;
import io.cucumber.util.CommonUtil;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class SortableDataTableStepDef extends Context {
    public SortableDataTableStepDef(Manager manager) {
        super(manager);
    }
    SortableDataTable sdt= new SortableDataTable(manager.getDriver());
    @And("Verify the Example 1 data on UI matches with following:")
    public void verifyTheExampleDataOnUIMatchesWithFollowing(DataTable table) {
        List<Map<String, String>> expectedUserDetails = table.asMaps(String.class,String.class);
        List<Map<String,String>> actualUserDetails = sdt.getUserDetails();

        Assert.assertTrue(CommonUtil.areListsEqual(actualUserDetails,expectedUserDetails));

    }
}
