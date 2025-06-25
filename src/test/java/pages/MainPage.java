package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private final By TITLE = By.xpath("//span[text()='Учебный центр']");
    private final By TITLE2 = By.xpath("//a[text()='Компания']");
    private final By TITLE3 = By.xpath("//span[@title='Компания Учебный центр Хогвардса']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем, что отображено название раздела Учебный центр в боковом меню")
    public boolean titleIsDisplayed() {
        return driver.findElement(TITLE).isDisplayed();
    }

    @Step("Проверяем доступность страницы Компания")
    public boolean companyIsEnabled() {
        driver.findElement(TITLE).click();
        driver.findElement(TITLE2).click();
        return driver.findElement(TITLE3).isDisplayed();
    }
}
