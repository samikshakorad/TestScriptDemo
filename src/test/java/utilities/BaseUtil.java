package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.WishListPage;

import java.util.concurrent.TimeUnit;

public class BaseUtil {

    private static WebDriver driver;
    private static HomePage homePage;
    private static WishListPage wishListPage;
    private static CartPage cartPage;

    

    public static WebDriver getDriver() {
        return driver;
    }

    public static HomePage getHomePage() {
        return homePage;
    }

    public static WishListPage getWishListPage() {
        return wishListPage;
    }

    public static void createWishListPage() {
        wishListPage = new WishListPage(driver);
    }

    public static CartPage getCartPage() {
        return cartPage;
    }

    public static void createCartPage() {
        cartPage = new CartPage(driver);
    }

}
