package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortableDataTable extends Page {
    public SortableDataTable(ChromeDriver driver) {
        super(driver);
    }

    @FindAll({@FindBy(css = "#table1 thead th")})
    private List<WebElement> headers;

    @FindAll({@FindBy(css = "#table1 tbody td")})
    private List<WebElement> userTableValues;


    public List<Map<String, String>> getUserDetails() {
        List<Map<String, String>> userDetails = new ArrayList<>();
        int rows = userTableValues.size() / headers.size();

        for (int i = 0, k = 0; i < rows; i++) {
            Map<String, String> m = new HashMap<>();
            for (int j = 0; j < headers.size() - 1; j++, k++) {
                m.put(headers.get(j).getText(), userTableValues.get(k).getText());
            }
            k++;
            userDetails.add(m);
        }
        return userDetails;
    }
}
