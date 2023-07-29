package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void clickElement(By locator) {
        findElement(locator).click();
    }

    protected void sendKeysToElement(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected String getTextFromElement(By locator) {
        return findElement(locator).getText();
    }

    public void openURL(String url) {
        driver.get(url);
    }

    protected void takeScreenshot(String filename) {

    }
}
