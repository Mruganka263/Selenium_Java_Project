package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ContextMenu extends Page {
    public ContextMenu(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(id = "hot-spot")
    private WebElement contextMenu;

    public WebElement getContextMenuBoxElement() {
        return contextMenu;
    }
}
