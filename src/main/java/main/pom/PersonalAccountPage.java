package main.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    WebDriver driver;
    // Логотип страницы
    private final By logo = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']/a");
    // Кнопка выход из аккаунта
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    // Кнопка раздела конструктор
    private final By conctructorButton = By.xpath(".//p[text()='Конструктор']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickConctructorButton() {
        driver.findElement(conctructorButton).click();
    }

    public String logoutButtonText() {
        return driver.findElement(logoutButton).getText();
    }
}
