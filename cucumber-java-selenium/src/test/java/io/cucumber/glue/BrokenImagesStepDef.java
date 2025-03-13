package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.And;
import io.cucumber.pages.BrokenImages;
import io.cucumber.util.CommonUtil;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class BrokenImagesStepDef extends Context {


    BrokenImages bi;
    SoftAssert softAssert;

    public BrokenImagesStepDef(Manager manager) {
        super(manager);
    }

    @And("verify if images have broken links")
    public void verifyIfImagesHaveBrokenLinks() throws IOException {
        bi = new io.cucumber.pages.BrokenImages(manager.getDriver());
        System.out.println("No. of images: "+bi.noOfImagesPresent());
        List<String> listOfImageSrc= bi.getImageSourceUrl();
        softAssert=new SoftAssert();
        //String currentUrl= manager.getDriver().getCurrentUrl();
        String baseURL= CommonUtil.getConfigProperty("baseurl");
        System.out.println(baseURL);
        for(String link:listOfImageSrc) {
            if (link != null && !link.isEmpty()) {
                int statusCode = CommonUtil.getResponseCode(baseURL+"/"+link);
                if (statusCode >= 400) {
                    System.out.println("Broken Image: " + link + " (Status Code: " + statusCode + ")");
                } else {
                    System.out.println("Valid Image: " + link);
                }
            } else {
                System.out.println("Image with empty src attribute found.");
            }

        }
    }
}
