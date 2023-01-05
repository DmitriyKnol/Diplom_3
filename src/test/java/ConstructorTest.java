import io.qameta.allure.junit4.DisplayName;
import main.BrowserRule;
import main.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConstructorTest {
    WebDriver driver;
    MainPage mainPage;
    BrowserRule browserRule = new BrowserRule();
    private final String browser;

    public ConstructorTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "{0}")
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
        driver.get(mainPage.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Бургеры")
    public void clickOnBread() {
        mainPage.clickSauceButton();
        mainPage.clickBreadButton();
        assertEquals("Краторная булка N-200i", mainPage.getTextCratorBread());
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Соусы")
    public void clickOnSauce() {
        mainPage.clickSauceButton();
        assertEquals("Соус традиционный галактический", mainPage.getTextGalaxySauce());
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Начинки")
    public void clickOnFiling() {
        mainPage.clickFilingsButton();
        assertEquals("Филе Люминесцентного тетраодонтимформа", mainPage.getTextLuminFiling());
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
