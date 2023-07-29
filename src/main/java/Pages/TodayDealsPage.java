package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodayDealsPage extends BasePage {
    public TodayDealsPage(WebDriver driver) {
        super(driver);
    }

    private By headphonesCheckBox = By.xpath("//span[contains(@class, 'CheckboxFilter-module') and normalize-space(text())=\"Headphones & Earbuds\"]");
    public void clickHeadphonesCheckBox() {
        clickElement(headphonesCheckBox);
    }

    private By groceryCheckBox = By.xpath("//span[contains(@class, 'CheckboxFilter-module') and normalize-space(text())=\"Grocery & Gourmet Food\"]");
    public void clickGroceryCheckBox() {
        clickElement(groceryCheckBox);
    }

    private By discountBtn = By.xpath("//a[@data-csa-c-element-id='filter-discount-10-']//span[normalize-space(text())=\"10% off or more\"]");
    public void clickDiscountBtn() {
        clickElement(discountBtn);
    }

    private By fourthPageBtn = By.xpath("//li[@class='a-normal' and contains(@aria-label, 'Page 4')]//a[normalize-space(text())='4']");
    public void clickFourthPageBtn() {
        clickElement(fourthPageBtn);
    }

    private By dealsProductTitle = By.xpath("(//a[contains(@class, 'a-link-normal DealLink-module__dealLink')])[1]");
    public void clickDealsProductTitle() {
        clickElement(dealsProductTitle);
    }
}
