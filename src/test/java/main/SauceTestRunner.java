package main;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



/**
 * Created by kiranmaid on 3/20/18.
 */

@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "src/test/java/resources/features",
        glue = "main.stepdefinition",
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"})


public class SauceTestRunner extends AbstractTestNGCucumberTests {

    private String browserName;
    private String browserVersion;
    private String os;
    private String scanerioName;
    public static Properties config = null;


    public String username = "nothstest";//System.getenv("SAUCE_USERNAME");

    public String accesskey = "ffff578d-ec01-474e-b623-0c0f4c7ef670"; //System.getenv("SAUCE_ACCESS_KEY");

    public static WebDriver driver = null;
    static Scenario scenario;

    private ThreadLocal<String> sessionId = new ThreadLocal<String>();

    private static String testEnv = System.getProperty("environment");

    public void LoadConfigProperty() throws IOException {
        config = new Properties();
        FileInputStream ip = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//java//resources//config//config.properties");
        config.load(ip);
    }

    public SauceTestRunner() {
    }

    @Factory(dataProvider = "dp")
    public SauceTestRunner(String name, String version, String os) {
        this.browserName = name;
        this.browserVersion = version;
        this.os = os;
    }


    public String getSessionId() {
        return sessionId.get();
    }


    @DataProvider
    public static Object[][] dp() {
        return new Object[][] { {"chrome", "64.0", "OS X 10.11"} };
    }


    @BeforeMethod
    public void setUp() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // set desired capabilities to launch appropriate browser on Sauce
        capabilities.setCapability(CapabilityType.BROWSER_NAME, this.browserName);
        capabilities.setCapability(CapabilityType.VERSION, this.browserVersion);
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, this.os);
        //capabilities.setCapability("name", scenario.getName());
        // Launch remote browser and set it as the current thread
        driver = new RemoteWebDriver(
                new URL("https://" + username + ":" + accesskey + "@ondemand.saucelabs.com:443/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("http://www.public."+testEnv+
                ".qa.noths.com");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        //SauceUtils.UpdateResults(username, accesskey, !scenario.isFailed(), getSessionId());
        driver.quit();
    }

}
