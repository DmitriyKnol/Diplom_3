package main.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // Кнопка зарегестрироваться
    private final By buttonFromStartRegistration = By.className("Auth_link__1fOlj");
    // Поле Email
    private final By fieldEmail = By.xpath(".//div/input[@name='name']");
    // Поле пароль
    private final By fieldPassword = By.xpath(".//div/input[@name='Пароль']");
    // Кнопка войти
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By messageErrorPassword = By.xpath(".//p[text()='Некорректный пароль']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonFromStartRegistration() {
        driver.findElement(buttonFromStartRegistration).click();
    }
    public void valueEmail(String inputEmail) {
        driver.findElement(fieldEmail).sendKeys(inputEmail);
    }
    public void valuePassword(String inputPassword) {
        driver.findElement(fieldPassword).sendKeys(inputPassword);
    }
    public String buttonEnterText() {
        return driver.findElement(enterButton).getText();
    }
    public String textUncorrectPassword() {
        return driver.findElement(messageErrorPassword).getText();
    }
    public void clickButtonEnter() {
        driver.findElement(enterButton).click();
    }
    public void loginEnterFieldsAndClick(String inputEmail, String inputPassword) {
        valueEmail(inputEmail);
        valuePassword(inputPassword);
        clickButtonEnter();
    }
}
