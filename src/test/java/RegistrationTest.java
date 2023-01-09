import com.github.javafaker.Faker;
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
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    WebDriver driver = new ChromeDriver();
    MainPage mainPage = new MainPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    Faker faker = new Faker();

    private final String email = faker.internet().emailAddress();
    private final String password = faker.internet().password(6, 10);
    private final String invalidpassword = faker.random().toString().substring(0, 5);
    private final String userName = faker.name().firstName();
    SetUp setUp = new SetUp(driver);

    @Before
    public void start() {
        setUp.prepareForLogin();
        mainPage.clickPersonalAccount();
        loginPage.clickButtonFromStartRegistration();

    }

    @Test
    @DisplayName("Проверка возможности успешной регистрации")
    public void successfullRegistration() {
        registrationPage.registrationInputFieldsAndClickButton(userName, email, password);
        assertEquals("Войти", loginPage.buttonEnterText());
    }

    @Test
    @DisplayName("Проверка регистрации с невалидным паролем")
    public void registrationWithInvalidPassword() throws Exception {
        try {
            registrationPage.registrationInputFieldsAndClickButton(userName, email, invalidpassword);
            assertEquals("Войти", loginPage.buttonEnterText());
        } catch (Exception exception) {
        }
        assertEquals("Некорректный пароль", loginPage.textUncorrectPassword());

    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}