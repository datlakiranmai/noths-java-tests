package main.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kiranmaid on 3/15/18.
 */
public class DeliveryDetailsPage {
    private WebDriver driver;

    public DeliveryDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
