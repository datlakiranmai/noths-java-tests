package main;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/**
 * Created by kiranmaid on 11/3/17.
 */



public class CucumberRunner {

    public static Properties config = null;
    public static WebDriver driver = null;
    private static String testEnv = System.getProperty("environment");

    public void openBrowser(String browser) throws Exception {
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            //System.setProperty("webdriver.chrome.driver","//Users//kiranmaid//Downloads//chromedriver");
            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            ChromeOptions options = new ChromeOptions();
              options.addArguments("--no-sandbox");
            //options.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase(("Safari"))) {
            System.setProperty("webdriver.safari.driver","//usr//bin//safaridriver");
            driver = new SafariDriver();
        }
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void implicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void pageLoad(int time) {
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void setEnv() throws Exception {
        driver.get("http://www.public."+testEnv+
                ".qa.noths.com");
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browserName) throws Exception {
        openBrowser(browserName);
        maximizeWindow();
        implicitWait(30);
        deleteAllCookies();
        setEnv();
    }

    @AfterMethod
    public void quit() throws IOException, InterruptedException {
        driver.quit();
    }

}

