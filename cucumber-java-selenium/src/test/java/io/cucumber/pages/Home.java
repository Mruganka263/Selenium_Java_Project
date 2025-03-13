package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Home extends Page {

    public Home(ChromeDriver driver) {
        super(driver);
        System.out.println("Homepage title is : " + getTitle().getText());
    }

    @FindBy(css = "h1")
    private WebElement title;

    @FindAll({@FindBy(css = "ul li")})
    private List<WebElement> allLinks;

    @FindBy(css = "[href*='abtest']")
    private WebElement ABTestLink;
    @FindBy(css = "h3")
    private WebElement ABTestControlHeading;

    @FindBy(css = "[href='/add_remove_elements/']")
    private WebElement addRemoveLink;

    @FindBy(css = "[href='/basic_auth']")
    private WebElement basicAuthLink;

    @FindBy(css = "[href='/broken_images']")
    private WebElement brokenImagesLink;

    @FindBy(css = "[href='/checkboxes']")
    private WebElement checkboxesLink;

    @FindBy(css = "[href='/context_menu']")
    private WebElement contextMenu;

    @FindBy(css = "[href=\"/tables\"]")
    private WebElement sortableDataTablesLink;


    public WebElement getTitle() {
        return title;
    }

    public void refresh() {
        driver.navigate().refresh();
        System.out.println("Refreshed page");
    }

    public List<String> getAllLinksText() {
        List<String> list = new ArrayList<>();
        for (WebElement l : allLinks)
            list.add(l.getText());
        return list;
    }

    public void click(String link) {
        switch (link) {
            case "A/B Testing":
                ABTestLink.click();
                break;
            case "Add/Remove Elements":
                addRemoveLink.click();
                break;
            case "Basic Auth":
                basicAuthLink.click();
                break;
            case "Broken Images":
                brokenImagesLink.click();
                break;
            case "Checkboxes":
                checkboxesLink.click();
                break;
            case "Context Menu":
                contextMenu.click();
                break;
            case "Sortable Data Tables":
                sortableDataTablesLink.click();
                break;
            default:
                System.out.println("Error");
        }
    }

    public WebElement getABTestControlHeadingWebEle() {
        return this.ABTestControlHeading;
    }

}
