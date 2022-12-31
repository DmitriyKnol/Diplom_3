package main.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    // Кнопка "Личный кабинет"
    private final By personalAccount = By.xpath(".//p[text()='Личный Кабинет']");

    private final WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUrl() {
        return url;
    }
    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }
}
