package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By searchTxtBox = By.id("twotabsearchtextbox");
    public void setSearchTxtBox(String searchTxt) {
        sendKeysToElement(searchTxtBox, searchTxt);
    }

    private By searchBtn = By.id("nav-search-submit-button");
    public void setSrcBtn() {
        clickElement(searchBtn);
    }
}
