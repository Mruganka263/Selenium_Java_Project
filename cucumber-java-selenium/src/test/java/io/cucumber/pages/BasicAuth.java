package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class BasicAuth extends Page{

    public BasicAuth(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(css=".example p")
    private WebElement message;


    public WebElement getMessage(){
        return message;
    }
}
