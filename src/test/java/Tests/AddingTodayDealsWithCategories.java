package Tests;

import Pages.*;
import RetryAnalyzer.RetryAnalyzer;
import Utils.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddingTodayDealsWithCategories {
    private static WebDriver driver;
    private HomePage homePage;
    private TodayDealsPage todayDealsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private String productTitle;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768));

        homePage = new HomePage(driver);
        todayDealsPage = new TodayDealsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        homePage.openURL(TestConfig.BASE_URL);
    }

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void testOpenTodayDeals(){
        homePage.clickTodayDealsBtn();
    }

    @Test (retryAnalyzer = RetryAnalyzer.class, dependsOnMethods = "testOpenTodayDeals")
    public void testSelectCategories(){
        todayDealsPage.clickHeadphonesCheckBox();
        todayDealsPage.clickGroceryCheckBox();
        todayDealsPage.clickDiscountBtn();
    }

    @Test (retryAnalyzer = RetryAnalyzer.class, dependsOnMethods = "testSelectCategories")
    public void testSelectFourthPage(){
        todayDealsPage.clickFourthPageBtn();
    }

    @Test (retryAnalyzer = RetryAnalyzer.class, dependsOnMethods = "testSelectFourthPage")
    public void testSelectProduct() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        todayDealsPage.clickDealsProductTitle();
    }

    @Test (retryAnalyzer = RetryAnalyzer.class, dependsOnMethods = "testSelectProduct")
    public void testAddItemToCart(){
        productTitle = productPage.getProductTitle();
        productPage.clickAddToCartBtn();
    }

    @Test (retryAnalyzer = RetryAnalyzer.class, dependsOnMethods = "testAddItemToCart")
    public void testCheckItemAddedToCart(){
        cartPage.clickCartBtn();
        String cartProductTitle = cartPage.getCartProductTitle();
        Assert.assertEquals(cartProductTitle, productTitle, "The selected item didn't added to the cart");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}