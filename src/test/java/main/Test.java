package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
    public static void main(String s[]) {
        System.setProperty("webdriver.chrome.driver", "//Users//kiranmaid//Downloads//chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver");
        //System.setProperty("webdriver.chrome.driver","//usr//local//bin//chromedriver");

        WebDriver driver = new ChromeDriver();
    }
}