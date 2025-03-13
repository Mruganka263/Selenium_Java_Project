package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Checkboxes extends Page {
    public Checkboxes(ChromeDriver driver) {
        super(driver);
    }

    @FindAll({@FindBy(css = "[type='checkbox']")})
    List<WebElement> checkboxes;

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }
}
