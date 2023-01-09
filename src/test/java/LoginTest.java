import io.qameta.allure.junit4.DisplayName;
import main.SetUp;
import main.pom.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
public class LoginTest {
    WebDriver driver = new ChromeDriver();
    MainPage mainPage = new MainPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(driver);
    private final String email = "ddmwkd@mail.ru";
    private final String password = "123456";
    SetUp setUp = new SetUp(driver);

    @Before
    public void openPage() {
        setUp.prepareForLogin();
    }

    @Test
    @DisplayName("Проверка возможности успешного входа через кнопку войти в аккаунт на главной странице")
    public void loginOnMainPage() {
        mainPage.clickEnterButton();
        loginPage.loginEnterFieldsAndClick(email, password);
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @Test
    @DisplayName("Проверка возможности успешного входа через кнопку Личный кабинет")
    public void loginOnClickPersonalAccount() {
        mainPage.clickPersonalAccount();
        loginPage.loginEnterFieldsAndClick(email, password);
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @Test
    @DisplayName("Проверка возможности успешного входа через кнопку войти в форме регистрации")
    public void loginOnRegistrationForm() {
        mainPage.clickPersonalAccount();
        loginPage.clickButtonFromStartRegistration();
        mainPage.clickEnterOnRegistrationForm();
        loginPage.loginEnterFieldsAndClick(email, password);
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @Test
    @DisplayName("Проверка возможности успешного входа через кнопку войти в форме восстановления пароля")
    public void loginOnRefreshPasswordForm() {
        mainPage.clickPersonalAccount();
        registrationPage.clickRecoveryPassword();
        recoveryPasswordPage.clickEnterButton();
        loginPage.loginEnterFieldsAndClick(email, password);
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}


