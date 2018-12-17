package main.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by kiranmaid on 11/6/17.
 */
public class MyAccountDetailsPage {

    private WebDriver driver;

    public MyAccountDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "page_title")
    public WebElement page_title;

    @FindBy(css = ".gc-header-myaccount__trigger.logged-in>span")
    public WebElement loggedin_user;

    @FindBy(className = "gc-header-myaccount__link")
    private List<WebElement> my_account;

    public void navigate_to_my_details(){
        loggedin_user.click();
        my_account.get(0).click();
    }

}
