package main.stepdefinition;

import cucumber.api.java.en.Given;
import main.CucumberRunner;
import main.pageObjects.CMSLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by kiranmaid on 9/3/18.
 */
public class Helper extends CucumberRunner {

    public void LoadConfigProperty() throws IOException {
        config = new Properties();
        FileInputStream address = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//java//resources//config//config.properties");
        config.load(address);
    }

    @Given("^I enable the user account feature flag$")
    public void enable_user_account_feature_flag() throws IOException {
        driver.get("https://noths.public.shared.qa.noths.com/admin#home");
        LoadConfigProperty();
        String email = config.getProperty("loginEmail");
        String pwd = config.getProperty("loginPassword");
        CMSLoginPage cmslogin = new CMSLoginPage(driver);
        cmslogin.setLoginCredentials(email, pwd);
        driver.get("https://noths.public.shared.qa.noths.com/admin/features");
        //WebElement user_account_flag = driver.findElement(By.xpath("//tbody//tr[141]//td[1]//form[1]//input[5]"));
        WebElement user_account_flag = driver.findElement(By.xpath("//form[@action='/admin/features/user_account/preview']//input[@name='commit']"));
        user_account_flag.click();
    }
}
