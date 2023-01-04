package main.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    // Кнопка "Личный кабинет"
    private final By personalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    // Кнопка "Оформить заказ"
    private final By createOrder = By.xpath(".//button[text()='Оформить заказ']");
   // Кнопка Вход в форме регистрации
    private final By enterOnRegistrationForm = By.xpath(".//a[text()='Войти']");
   // Кнопка войти в аккаунт на главной странице
    private final By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    // Надпись Соберите бургер на главной странице
    private final By chooseBurger = By.xpath(".//h1[text()='Соберите бургер']");
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
    public void clickEnterOnRegistrationForm() {
        driver.findElement(enterOnRegistrationForm).click();
    }
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    public String textOfChooseBurger() {
        return driver.findElement(chooseBurger).getText();
    }
    public String buttonCreateOrderText() {
        return driver.findElement(createOrder).getText();
    }
}
