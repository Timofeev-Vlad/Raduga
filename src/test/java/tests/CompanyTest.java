package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.*;

public class CompanyTest extends BaseTest {
    @Test(description = "Совпадение пользователя с указанным Руководителем компании")
    public void matchDirector() {
        loginPage.open()
                .login(UserFactory.withAdminPermission());
        mainPage.companyIsEnabled();
        companyPage.getDumbledoreHrefValue();
        companyPage.getAnotherLinkHrefValue();
        assertTrue(companyPage.areHrefsEqual(), "Href does not equal");
    }
}
