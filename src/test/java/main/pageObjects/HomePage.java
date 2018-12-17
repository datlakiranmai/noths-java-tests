package main.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by kiranmaid on 11/4/17.
 */
public class HomePage{

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".gc-header-myaccount__link.gc-header-myaccount__link--inline")
    private List<WebElement> user_button;

    @FindBy(className = "gc-header-favourites")
    private WebElement favourite_button;

    public void buttonClick(String action){
        if (action.equalsIgnoreCase("SignIn")) {
            user_button.get(0).click();
        } else if(action.equalsIgnoreCase("Register")){
            user_button.get(1).click();
        } else{
            favourite_button.click();
        }
    }


}
