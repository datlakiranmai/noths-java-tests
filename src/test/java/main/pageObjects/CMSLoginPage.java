package main.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kiranmaid on 9/3/18.
 */
public class CMSLoginPage {

    private WebDriver driver;

    public CMSLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="email")
    private WebElement cms_login_email;

    @FindBy(id="password")
    private WebElement cms_login_pwd;

    @FindBy(id="admin_log_in_button")
    private WebElement cms_login_button;

    public void setLoginCredentials(String username, String pwd){
        cms_login_email.click();
        cms_login_email.sendKeys(username);
        cms_login_pwd.sendKeys(pwd);
        cms_login_button.click();
    }
}
