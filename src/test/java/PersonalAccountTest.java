import jdk.jfr.Description;
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
public class PersonalAccountTest {
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    PersonalAccountPage personalAccountPage;
    SetUp setUp;
    BrowserRule browserRule = new BrowserRule();
    private final String browser;

    public PersonalAccountTest(String browser) {
        this.browser = browser;
    }
    @Parameterized.Parameters (name = "{0}")
    public static Object[][] getBrowser() {
        return new Object[][]{
                {"Chrome",},
                {"Yandex",}
        };
    }
    @Before
    public void openPage() {
        driver = browserRule.selectBrowser(browser);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        setUp = new SetUp(driver);
        setUp.prepareForLogin();
        setUp.login();
    }
    @Test
    @Description("Проверка возможности перехода в личный кабинет")
    public void clickOnPersonalAccount() {
        mainPage.clickPersonalAccount();
        personalAccountPage.clickLogoutButton();
        assertEquals("Выход",personalAccountPage.logoutButtonText());
    }
    @Test
    @Description("Проверка нажатия на логотип")
    public void clickOnLogo() {
        mainPage.clickPersonalAccount();
        personalAccountPage.clickLogo();
       assertEquals("Соберите бургер", mainPage.textOfChooseBurger());
    }
    @Test
    @Description("Проверка возможности перехода в конструктор из личного кабинета")
    public void clickOnConstructorButton() {
        mainPage.clickPersonalAccount();
        personalAccountPage.clickConctructorButton();
        assertEquals("Соберите бургер", mainPage.textOfChooseBurger());
    }
    @Test
    @Description("Проверка возможности выхода из аккаунта")
    public void successfullLogout() {
        mainPage.clickPersonalAccount();
        personalAccountPage.clickLogoutButton();
        assertEquals("Войти",loginPage.buttonEnterText());
    }
    @After
    public void quitDriver() {
        driver.quit();
    }
}
