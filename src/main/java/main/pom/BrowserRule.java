package main.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserRule {
    private WebDriver driver;
    public WebDriver selectBrowser(String browser) {
        if (browser == "Chrome") {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
            return new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\User\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
           return new ChromeDriver(options);
        }
    }
}
