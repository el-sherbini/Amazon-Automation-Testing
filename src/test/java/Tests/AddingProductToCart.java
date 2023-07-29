package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.ResultsPage;
import Utils.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddingProductToCart {
    private static WebDriver driver;
    HomePage homePG;
    ResultsPage resultsPG;
    ProductPage productBG;
    CartPage cartPG;
    String productTitle, cartProductTitle;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768));
        homePG = new HomePage(driver);
        resultsPG = new ResultsPage(driver);
        productBG = new ProductPage(driver);
        cartPG = new CartPage(driver);
        homePG.openURL(TestConfig.BASE_URL);
    }

    @Test
    public void categorySearch(){
        homePG.setSearchTxtBox("car accessories");
        homePG.setSrcBtn();
    }

    @Test (dependsOnMethods = "categorySearch")
    public void selectFirstItem(){
        resultsPG.setProductLink();
    }

    @Test (dependsOnMethods = "selectFirstItem")
    public void addItemToCart(){
        productTitle = productBG.getProductTitle();
        productBG.setAddToCartBtn();
    }

    @Test (dependsOnMethods = "addItemToCart")
    public void checkItemAddedToCart(){
        cartPG.setCartBtn();
        cartProductTitle = cartPG.getCartProductTitle();
        Assert.assertEquals(cartProductTitle, productTitle, "The added item to the cart is wrong");
    }

    @AfterSuite
    public static void teardown() {
        driver.quit();
    }
}
