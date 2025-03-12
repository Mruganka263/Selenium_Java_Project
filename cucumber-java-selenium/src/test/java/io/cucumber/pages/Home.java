package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Home extends Page {

  public Home(ChromeDriver driver) {
    super(driver);
    System.out.println("Homepage title is : " + getTitle().getText());
  }

  @FindBy(css = "h1")
  private WebElement title;

  @FindBy(css ="[href*='abtest']")
  private  WebElement ABTestLink;
  @FindBy(css = "h3")
  private WebElement ABTestControlHeading;

  @FindBy(css ="[href='/add_remove_elements/']")
  private WebElement addRemoveLink;

  @FindBy(css ="[href='/basic_auth']")
  private WebElement basicAuthLink;

  @FindBy(css ="[href='/broken_images']")
  private WebElement brokenImagesLink;

  @FindBy(css ="[href='/challenging_dom']")
  private WebElement challengingDomLink;

  @FindBy(css ="[href='/checkboxes']")
  private WebElement checkboxesLink;

  @FindBy(css ="[href='/context_menu']")
  private WebElement contextMenu;

  @FindBy(css="[href='/disappearing_elements']")
  private WebElement disapperingElement;

  @FindBy(css="[href='/drag_and_drop']")
  private WebElement dragAndDrop;

  @FindBy(css="[href='/dropdown']")
  private WebElement dropdown;

  @FindBy(css="[href='/dynamic_content']")
  private WebElement dynamicContent;

  @FindBy(css="[href=\"/dynamic_controls\"]")
  private WebElement dynamicControl;

  @FindBy(css="[href=\"/dynamic_loading\"]")
  private WebElement dynamicLoading;

  public WebElement getTitle() {
    return title;
  }

  public void refresh() {
    driver.navigate().refresh();
    System.out.println("Refreshed page");
  }

  public void click(String link){
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
      case "Challenging DOM":
        challengingDomLink.click();
        break;
      case "Checkboxes":
        checkboxesLink.click();
        break;
      case "Context Menu":
        contextMenu.click();
        break;
      case "Disappearing Elements":
        disapperingElement.click();
        break;
      case "Drag and Drop":
        dragAndDrop.click();
        break;
      case "Dropdown":
        dropdown.click();
        break;
      case "Dynamic Content":
        dynamicContent.click();
        break;
      case "Dynamic Controls":
        dynamicControl.click();
        break;
      case "Dynamic Loading":
        dynamicLoading.click();
        break;
      default:
        System.out.println("Error");
    }
  }

  public WebElement getABTestControlHeadingWebEle(){
    return this.ABTestControlHeading;
  }

}
