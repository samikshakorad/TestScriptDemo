package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import utilities.BaseUtil;

public class LoginSteps {
	
	WebDriver driver;	
	LoginPage login;
	WebElement lowestPriceAddToCartWebElement;
	String lowestPriceProductName;
    double lowestPrice;
	
	@Given("open browser")
	public void open_browser() {
		
		System.out.println("Step1: Browser is open");
		String projectPath= System.getProperty("user.dir");
		System.out.println(projectPath);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		    
	}

	@Given("user pass the url {string}")
	public void user_pass_the_url(String url)  {
		System.out.println("Step2: Pass the URL:"+url);
		driver.get(url);	   
	}
	
	@Then("click on accept all button")
	public void click_on_accept_all_button() {
		System.out.println("Step4: Click on Accept All");
		login=new LoginPage(driver);
		login.clickAcceptAll();
	}

	@When("click on My Account")
	public void click_on_sing_in() {
		System.out.println("Step3: Click on sign in");
		login=new LoginPage(driver);
		login.clickMyAccount();
		
	}

	@And("user enters valid user name {string} and password {string}")
	public void user_enters_valid_user_name_and_password(String username, String pswd) {
		System.out.println("Step5: Enter User name:"+username+ "Password:"+pswd);
		login=new LoginPage(driver);
		login.setEmail(username);
		login.setPassword(pswd);
	}

	@And("user click on sign in")
	public void user_click_on_sign_in() {
		System.out.println("Step6: Click on sign in");
		login=new LoginPage(driver);
		login.btnSignin();
	}

	@Then("user navigate to homepage")
	public void user_navigate_to_homepage() {
		System.out.println("Step7: Welcome to Home Page.");
		login=new LoginPage(driver);
		boolean targetpage=login.isMyAccountPageExists();
		
		if(targetpage)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
		}
	
	@Given("I add four different products to my wish list")
	public void i_add_four_different_products_to_my_wish_list() {
	   login.clickHome();
	   JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,350)", "");
       login.addToWishListProduct1();
       login.addToWishListProduct2();
       js.executeScript("window.scrollBy(350,700)", "");
       login.addToWishListProduct3();
       login.addToWishListProduct4();
		//login.clickCategories();
	   //login.selectWomensClothing();
	}

	@When("I view my wishlist table")
	public void i_view_my_wishlist_table() throws InterruptedException {

        BaseUtil.getHomePage().goToWishList();
    }

	@Then("I find total four selected items in my Wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() {
		int actualNoOfItemsInWishList = BaseUtil.getWishListPage().getWishListTableSize();
        Assert.assertEquals(actualNoOfItemsInWishList, 4);
	   
	}

	@When("I search for lowest price product")
	public void i_search_for_lowest_price_product() {

        double minimumPrice = Double.MAX_VALUE;

        for(int i=1;i<=BaseUtil.getWishListPage().getWishListTableSize();i++){
            String priceXPath = "//*[@class=\"shop_table cart wishlist_table wishlist_view traditional responsive   \"]//tbody/tr["+i+"]/td[4]";
            WebElement priceElement=BaseUtil.getDriver().findElement(By.xpath(priceXPath));

            String addToCartXPath = "//*[@class=\"shop_table cart wishlist_table wishlist_view traditional responsive   \"]//tbody/tr["+i+"]/td[6]";
            WebElement addToCartElement = BaseUtil.getDriver().findElement(By.xpath(addToCartXPath));

            String productNameXPath = "//*[@class=\"shop_table cart wishlist_table wishlist_view traditional responsive   \"]//tbody/tr["+i+"]/td[3]";
            WebElement productNameElement = BaseUtil.getDriver().findElement(By.xpath(productNameXPath));

            String unitpriceRange=priceElement.getText();

            double unitPrice = Double.parseDouble(unitpriceRange.substring(unitpriceRange.lastIndexOf('£')+1));

            if(unitPrice < minimumPrice) {
                minimumPrice = unitPrice;
                lowestPriceAddToCartWebElement = addToCartElement;
                lowestPriceProductName = productNameElement.getText();
                lowestPrice = minimumPrice;
            }
        }
	}
    
						
		  
	

	@When("I am able to add the lowest price item to my cart")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() throws InterruptedException {
        lowestPriceAddToCartWebElement.click();
        Thread.sleep(1000);
    }

	@Then("I am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_my_cart() throws InterruptedException {
        BaseUtil.getWishListPage().goToCart();
        Thread.sleep(1000);
        WebElement productNameElement=BaseUtil.getDriver().findElement(By.xpath("//*[@class=\"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]//tbody/tr[1]/td[3]"));
        String productName = productNameElement.getText();

        WebElement productPriceElement=BaseUtil.getDriver().findElement(By.xpath("//*[@class=\"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]//tbody/tr[1]/td[4]"));
        String productPrice = productPriceElement.getText();
        int lastPoundIndex=productPrice.lastIndexOf('£');
        String substring=productPrice.substring(lastPoundIndex+1);
        double price=Double.parseDouble(substring);

        Assert.assertEquals(productName, lowestPriceProductName);
        Assert.assertEquals(price, lowestPrice, 0.00);

        BaseUtil.getDriver().close();
    }

}
