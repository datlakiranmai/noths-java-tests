package main.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kiranmaid on 11/9/17.
 */
public class FavouritesPage {

    private WebDriver driver;

    public FavouritesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".gc-header-favourites.gc-header__item.gc-header__item--favourites.gc-header__item--active")
    private WebElement favsBtnHeader;

    @FindBy(css = ".styles__Text-s1ndm7fz-1.hJHaar")
    public WebElement favsPageTitle;

    @FindBy(css = ".folderName.styles__Text-s1dfcrjt-1.cOxogp")
    public WebElement myFavsPageTitle;

    @FindBy(xpath = "//img[contains(@src, 'preview_hanging-tealight-bubbles.jpg')]")
    private WebElement myFavs;

    @FindBy(xpath = "//a[contains(@class, 'AccountLogin__sign-in')]")
    private WebElement signinButton;


    public void viewFavs() {
        myFavs.click();
    }

    public void login() {
        signinButton.click();
    }


}
