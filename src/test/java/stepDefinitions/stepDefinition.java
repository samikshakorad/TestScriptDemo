package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.WishList;

public class stepDefinition {
	
	WebDriver driver;
	WebElement lowPriceAddToCartWebElement;
	String lowPriceProductName;
    double lowPrice;
	
	@Given("I open the website")
	public void i_open_the_website() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		driver.get("https://testscriptdemo.com/");		
		home.clickAcceptAll();	    
	}

	@Given("I add four different products to my wishlist")
	public void i_add_four_different_products_to_my_wishlist() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");	
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.addProduct1();
		home.addProduct2();
		js.executeScript("window.scrollBy(350,700)", "");	
	    home.addProduct3();
	    home.addProduct4();
	}

	@When("I view my wishlist table")
	public void i_view_my_wishlist_table() {
		WishList wishListPage=PageFactory.initElements(driver, WishList.class);
		wishListPage.clickOnWishList();
	}

	@Then("I find total four selected items in my wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() {
		WishList wishListPage=PageFactory.initElements(driver, WishList.class);
		int totalItemInWishList=wishListPage.getWishListTableSize();
		Assert.assertEquals(totalItemInWishList, 4);
		
	}

	@When("I search for lowest price product")
	public void i_search_for_lowest_price_product() {
		WishList wishListPage=PageFactory.initElements(driver, WishList.class);
		
		double minimumPrice = Double.MAX_VALUE;
		//List<WebElement> row=table.findElements(By.tagName("tr"));		
		//List<WebElement> column=driver.findElements(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody/tr/th[4]"));
		for(int i=1; i<=wishListPage.getWishListTableSize(); i++)
		{
			
			String priceXPath = "//*[@class=\"shop_table cart wishlist_table wishlist_view traditional responsive   \"]//tbody/tr["+i+"]/td[4]";
			WebElement priceElement=driver.findElement(By.xpath(priceXPath));
			String addToCartXPath = "//*[@class=\"shop_table cart wishlist_table wishlist_view traditional responsive   \"]//tbody/tr["+i+"]/td[6]";
			 WebElement addToCartElement = driver.findElement(By.xpath(addToCartXPath));
			String productNameXPath = "//*[@class=\"shop_table cart wishlist_table wishlist_view traditional responsive   \"]//tbody/tr["+i+"]/td[3]";
			WebElement productNameElement = driver.findElement(By.xpath(productNameXPath));
			
			String unitpriceRange=priceElement.getText();
			
			 double unitPrice = Double.parseDouble(unitpriceRange.substring(unitpriceRange.lastIndexOf('£')+1));
			 if(unitPrice < minimumPrice) {
	                minimumPrice = unitPrice;
	                lowPriceAddToCartWebElement = addToCartElement;
	                lowPriceProductName = productNameElement.getText();
	                lowPrice = minimumPrice;
	            }
	   
	}
	}

	@And("I am able to add lowest price item to my cart")
	public void i_am_able_to_add_lowest_price_item_to_my_cart() throws InterruptedException 
	{
		
		 lowPriceAddToCartWebElement.click();
	        Thread.sleep(1000);
	}
	    
	

	@Then("I am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_my_cart() throws InterruptedException 
	{
		AddToCartPage cartPage=PageFactory.initElements(driver, AddToCartPage.class);
		cartPage.goToCart();
	        Thread.sleep(1000);
	        WebElement productNameElement=driver.findElement(By.xpath("//*[@class=\"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]//tbody/tr[1]/td[3]"));
	        String productName = productNameElement.getText();

	        WebElement productPriceElement=driver.findElement(By.xpath("//*[@class=\"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]//tbody/tr[1]/td[4]"));
	        String productPrice = productPriceElement.getText();
	        
	        int lastPoundIndex=productPrice.lastIndexOf('£');
	        String substring=productPrice.substring(lastPoundIndex+1);
	        double price=Double.parseDouble(substring);

	        Assert.assertEquals(productName, lowPriceProductName);
	        Assert.assertEquals(price, lowPrice, 0.00);

	        driver.close();
	    
	}

}

