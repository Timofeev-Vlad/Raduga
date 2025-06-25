package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

import java.time.Duration;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.id("sdo-login");
    private static final By PASSWORD_INPUT = By.id("sdo-password");
    private static final By LOGIN_BUTTON = By.xpath("//span[text()='Войти']//ancestor::button[@type='button']");
    private static final By FORGOT_BUTTON = By.xpath("//span[text()='Забыли пароль?']//ancestor::button[@type='button']");
    private final By alertLocator = By.xpath("//div[contains(@class, 'el-notification__content')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие браузера")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Вводим данные пользователя")
    public void login(User user) {
        fillLoginInput(user.getName());
        fillPasswordInput(user.getPassword());
        clickSubmitBtn();
    }

    public LoginPage fillLoginInput(String user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        return this;
    }

    public LoginPage fillPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public void clickSubmitBtn() {
        driver.findElement(LOGIN_BUTTON).submit();
    }

    @Step("Проверяем окно ошибки при безуспешной авторизации")
    public boolean errorIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertLocator));
        return driver.findElement(alertLocator).isDisplayed();
    }


    @Step("Проверяем ссылку для восстановления доступа")
    public boolean findForgotBtn() {
        return driver.findElement(FORGOT_BUTTON).isDisplayed();
    }

}
