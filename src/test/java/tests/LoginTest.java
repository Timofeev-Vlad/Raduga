package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(description = "Проверка авторизации")
    public void correctPass() {
        loginPage.open()
                .login(UserFactory.withAdminPermission());
        assertTrue(mainPage.titleIsDisplayed());
    }

    @Test(description = "Проверка появления окна с ошибкой при вводе неверного пароля")
    public void uncorrectPass() {
        loginPage.open()
                .login(UserFactory.withWrongPassword());
        assertTrue(loginPage.errorIsDisplayed());
    }

    @Test(description = "Проверка наличия кнопки на форму восстановления")
    public void forgotPass() {
        loginPage.open();
        assertTrue(loginPage.findForgotBtn());
    }
}
