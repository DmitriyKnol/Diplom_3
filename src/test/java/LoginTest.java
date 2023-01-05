import io.qameta.allure.junit4.DisplayName;
import main.BrowserRule;
import main.SetUp;
import main.pom.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LoginTest {
    WebDriver driver;
    MainPage mainPage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    RecoveryPasswordPage recoveryPasswordPage;
    private final String email = "ddmwkd@mail.ru";
    private final String password = "123456";
    SetUp setUp;
    BrowserRule browserRule = new BrowserRule();
    private final String browser;

    public LoginTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getBrowser() {
        return new Object[][]{
                {"Chrome"},
                {"Yandex"},
        };
    }

    @Before
    public void openPage() {
        driver = browserRule.selectBrowser(browser);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        recoveryPasswordPage = new RecoveryPasswordPage(driver);
        setUp = new SetUp(driver);
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


