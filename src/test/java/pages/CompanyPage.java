package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyPage extends BasePage {
    private final By dumbledoreLinkLocator = By.xpath("//a[text()='Дамблдор Альбус']");
    private final By dumbledoreAvatar = By.xpath("//span[contains(@class, 'tooltip')]");
    private final By anotherLinkLocator = By.xpath("//a[text()='dumbledore@sct.team']");

    public CompanyPage(WebDriver driver) {
        super(driver);
    }

    public String getDumbledoreHrefValue() {
        WebElement link = driver.findElement(dumbledoreLinkLocator);
        return link.getAttribute("href");
    }

    public String getAnotherLinkHrefValue() {
        driver.findElement(dumbledoreAvatar).click();
        WebElement link = driver.findElement(anotherLinkLocator);
        return link.getAttribute("href");
    }

    public boolean areHrefsEqual() {
        String dumbledoreHref = getDumbledoreHrefValue();
        String anotherHref = getAnotherLinkHrefValue();
        return dumbledoreHref.equals(anotherHref);
    }
}