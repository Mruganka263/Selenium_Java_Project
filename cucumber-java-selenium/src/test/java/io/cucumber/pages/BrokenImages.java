package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrokenImages extends Page {
    public BrokenImages(ChromeDriver driver) {
        super(driver);
    }

    @FindAll({@FindBy(css = "img")})
    List<WebElement> listOfImages;


    public int noOfImagesPresent() {
        return listOfImages.size();
    }

    public List<String> getImageSourceUrl() {
        List<String> listOfImageSrc = new ArrayList<>();
        for (WebElement e : listOfImages)
            listOfImageSrc.add(e.getDomAttribute("src"));
        return listOfImageSrc;
    }
}
