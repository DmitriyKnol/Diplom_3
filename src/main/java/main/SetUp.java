package main;

import main.pom.LoginPage;
import main.pom.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SetUp {
    private WebDriver driver;
    private final String email = "ddmwkd@mail.ru";
    private final String password = "123456";
    public SetUp(WebDriver driver) {
        this.driver = driver;
    }
    public void prepareForLogin() {
        MainPage mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public void login() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickEnterButton();
        loginPage.loginEnterFieldsAndClick(email, password);
    }
    public void selectBrowser(String browser) {
        if (browser == "Chrome") {
            driver = new ChromeDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\User\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
           driver = new ChromeDriver(options);
        }
    }
}
