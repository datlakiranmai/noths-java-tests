package main.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by kiranmaid on 11/4/17.
 */
public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="email")
    private WebElement login_email;

    @FindBy(id="password")
    private WebElement login_pwd;

    /*@FindBy(id="button_existing_customer")
    private WebElement signin_button;*/

    @FindBy(css=".NFC-Button.NFC-Button--medium")
    private List<WebElement> signin_button;

    public void setLoginCredentials(String username, String pwd){
        login_email.click();
        login_email.sendKeys(username);
        login_pwd.sendKeys(pwd);
        System.out.println(signin_button.size());
        signin_button.get(0).click();
        //signin_button.click();
    }


}
