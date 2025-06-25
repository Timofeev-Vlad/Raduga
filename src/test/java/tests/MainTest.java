package tests;

import org.testng.annotations.Test;
import user.UserFactory;

public class MainTest extends BaseTest {
    @Test(description = "Доступность страницы Компания после авторизации")
    public void findCompany() {
        loginPage.open()
                .login(UserFactory.withAdminPermission());
        mainPage.companyIsEnabled();
    }
}
