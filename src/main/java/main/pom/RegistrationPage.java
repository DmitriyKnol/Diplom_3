package main.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    // Поле Имя пользователя
    private final By fieldUserName = By.xpath(".//form/fieldset[1]/div/div/input[@name='name']");
    // Поле Email
    private final By fieldEmail = By.xpath(".//form/fieldset[2]/div/div/input[@name='name']");
    // Поле Пароль
    private final By fieldPassword =  By.xpath(".//div/input[@name='Пароль']");
    // Кнопка зарегестрироваться
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // Кнопка восстановить пароль
    private final By recoveryPassword = By.xpath(".//a[text()='Восстановить пароль']");
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void valueUserName(String inputName) {
        driver.findElement(fieldUserName).clear();
        driver.findElement(fieldUserName).sendKeys(inputName);

    }
    public void valueEmail(String inputEmail) {
        driver.findElement(fieldEmail).clear();
        driver.findElement(fieldEmail).sendKeys(inputEmail);
    }
    public void valuePassword(String inputPassword) {
        driver.findElement(fieldPassword).clear();
        driver.findElement(fieldPassword).sendKeys(inputPassword);
    }
    public void clickButtonRegistration() {
        driver.findElement(registrationButton).click();
    }
    public void clickRecoveryPassword() {
        driver.findElement(recoveryPassword).click();
    }
    public void registrationInputFieldsAndClickButton(String inputName,String inputEmail, String inputPassword) {
        valueUserName(inputName);
        valueEmail(inputEmail);
        valuePassword(inputPassword);
        clickButtonRegistration();
    }
}
