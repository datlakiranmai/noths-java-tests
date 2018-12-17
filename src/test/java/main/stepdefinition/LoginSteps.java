package main.stepdefinition;

/**
 * Created by kiranmaid on 11/3/17.
 */

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.CucumberRunner;
import main.pageObjects.*;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginSteps extends CucumberRunner {


    private static String testEnv = System.getProperty("environment");
    /*private static String scenarioName;
    public static WebDriver driver = null;
    public String sessionId;
    public static Properties config = null;


    public String username = "nothstest";//System.getenv("SAUCE_USERNAME");


    public String accesskey = "ffff578d-ec01-474e-b623-0c0f4c7ef670"; //System.getenv("SAUCE_ACCESS_KEY");
*/


    public void LoadConfigProperty() throws IOException {
        config = new Properties();
        FileInputStream address = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//java//resources//config//config.properties");
        config.load(address);
    }

    /* @Before
    public void setUp(Scenario scenario) throws Exception {
        DesiredCapabilities capabilities;

        capabilities = SauceTestRunner.createCapabilities();
        capabilities.setCapability("name", scenario.getName() );
        // Launch remote browser and set it as the current thread
        driver = new RemoteWebDriver(
                new URL("https://" + username + ":" + accesskey + "@ondemand.saucelabs.com:443/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("http://www.public."+testEnv+
                ".qa.noths.com");

        sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
    }*/

    @Given("^I am on home page$")
    public void navigate_to_home_page() {
        driver.get("http://www.public."+testEnv+
                ".qa.noths.com");    }

    @When("^I click on Signin from the header$")
    public void click_Signin_from_the_header() {
        HomePage homePage = new HomePage(driver);
        homePage.buttonClick("SignIn");
    }

    @When("^I enter my login credentials$")
    public void enter_login_credentials() throws IOException {
        LoadConfigProperty();
        String email = config.getProperty("loginEmail");
        String pwd = config.getProperty("loginPassword");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginCredentials(email, pwd);
    }

    @Then("^I should login successfully$")
    public void check_login_status() {
        MyAccountDetailsPage accountDetails = new MyAccountDetailsPage(driver);
        accountDetails.navigate_to_my_details();
        Assert.assertEquals("my account", accountDetails.loggedin_user.getText());
    }

    @Then("^I should be taken to My details page$")
    public void navigate_to_My_details_page() {
        MyAccountDetailsPage accountDetails = new MyAccountDetailsPage(driver);
        Assert.assertEquals("MY DETAILS", accountDetails.page_title.getText());
    }

    @When("^I click on favourites from header$")
    public void click_on_favourites_from_header() {
        HomePage homePage = new HomePage(driver);
        homePage.buttonClick("favourites");
    }

    @When("^I click on Signin from favourites page$")
    public void i_click_on_Signin_from_favourites_page() {
        FavouritesPage favsPage = new FavouritesPage(driver);
        favsPage.viewFavs();
        favsPage.login();
    }

    @Given("^I navigate to \"([^\"]*)\" product detail page$")
    public void navigate_to_product_page(String productPageURL) {
        driver.get("http://www.public."+testEnv+
                ".qa.noths.com" + productPageURL);
    }

    @Given("^I add the product to my favourites$")
    public void i_add_the_product_to_my_favourites() {
        ProductDetailsPage favsPage = new ProductDetailsPage(driver);
        favsPage.addToFavourites();
    }

    @When("^I click on Favourites from the header$")
    public void i_click_on_Favourites_from_the_header() {
        HomePage homePage = new HomePage(driver);
        homePage.buttonClick("favourites");
    }

    @When("^I am redirected to My Favourites page$")
    public void i_am_redirected_to_My_Favourites_page() {
        FavouritesPage favsPage = new FavouritesPage(driver);
        Assert.assertEquals("MY FAVOURITES", favsPage.favsPageTitle.getText());
    }

    @When("^I click on My Faves icon$")
    public void i_click_on_My_Faves_icon() {
        FavouritesPage favsPage = new FavouritesPage(driver);
        favsPage.viewFavs();
    }

    @When("^I click on Signin$")
    public void i_click_on_Signin() throws Throwable {
        FavouritesPage favsPage = new FavouritesPage(driver);
        favsPage.login();
    }

    @Then("^I should be taken to My Faves page$")
    public void navigate_to_my_faves_page() {
        FavouritesPage favsPage = new FavouritesPage(driver);
        Assert.assertEquals("MY FAVES", favsPage.myFavsPageTitle.getText());
    }


}
