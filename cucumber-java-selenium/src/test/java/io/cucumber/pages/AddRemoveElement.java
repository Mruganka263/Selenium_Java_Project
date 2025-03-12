package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddRemoveElement extends Page{
    public AddRemoveElement(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//button[text()='Add Element']")
    private WebElement addButton;

    @FindAll({@FindBy(css="#elements .added-manually")})
    List<WebElement> listOfElements;

    public void addElement() {
        addButton.click();
    }

    public int noOfElementsPresent(){
        return listOfElements.size();
    }

    public void deleteAllElement() {
        for (WebElement e: listOfElements)
            e.click();
    }
}
