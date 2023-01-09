import io.qameta.allure.junit4.DisplayName;
import main.SetUp;
import main.pom.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
public class PersonalAccountTest {
    WebDriver driver = new ChromeDriver();
    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
    SetUp setUp = new SetUp(driver);

    @Before
    public void openPage() {
        setUp.prepareForLogin();
        setUp.login();
    }

    @Test
    @DisplayName("Проверка возможности перехода в личный кабинет")
    public void clickOnPersonalAccount() {
        mainPage.clickPersonalAccount();
        assertEquals("Выход", personalAccountPage.logoutButtonText());
    }

    @Test
    @DisplayName("Проверка нажатия на логотип из личного кабинета")
    public void clickOnLogo() {
        mainPage.clickPersonalAccount();
        personalAccountPage.clickLogo();
        assertEquals("Соберите бургер", mainPage.textOfChooseBurger());
    }

    @Test
    @DisplayName("Проверка возможности перехода в конструктор из личного кабинета")
    public void clickOnConstructorButton() {
        mainPage.clickPersonalAccount();
        personalAccountPage.clickConctructorButton();
        assertEquals("Соберите бургер", mainPage.textOfChooseBurger());
    }

    @Test
    @DisplayName("Проверка возможности выхода из аккаунта")
    public void successfullLogout() {
        mainPage.clickPersonalAccount();
        personalAccountPage.clickLogoutButton();
        assertEquals("Войти", loginPage.buttonEnterText());
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
