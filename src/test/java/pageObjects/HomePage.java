package pageObjects;

import utilities.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"yith-wcwl-add-button\"]")
    public List<WebElement> allWishlist;

    @FindBy(xpath = "//*[@class=\"site-header container-fluid\"]//*[@class=\"lar la-heart\"]")
    public WebElement wishListIcon;

    public void doWishList(int noOfProductsToWishlist) throws InterruptedException {
        List<WebElement> toBeWishlisted = new ArrayList<>();

        int countClickedWishlist = 0; // 2
        for(int i = 0; i < allWishlist.size() && countClickedWishlist < noOfProductsToWishlist; i++) {
            if(allWishlist.get(i).isDisplayed() == true) {
                countClickedWishlist++;
                toBeWishlisted.add(allWishlist.get(i));

            }
        }

        for(int i = 0; i < toBeWishlisted.size(); i++) {
            toBeWishlisted.get(i).click();
            Thread.sleep(1000); // put sleep between wishlist click
        }
    }

    public void goToWishList() throws InterruptedException {
        wishListIcon.click();
        Thread.sleep(1000);
        BaseUtil.createWishListPage();
    }
}
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	////cucumber.publish.enabled=true
	WebDriver driver;
		
	/*public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}*/
	
	@FindBy(xpath="//a[@role='button'][contains(text(),'Accept all')]")
	WebElement acceptAll;
	public void clickAcceptAll()
	{	
		System.out.println("I am on step1");
		acceptAll.click();
	}	
	
	@FindBy(xpath="//li[contains(@class,'product type-product post-20 status-publish instock product_cat-clothing product_cat-womens-clothing has-post-thumbnail sale featured downloadable virtual purchasable product-type-simple')]//span[contains(text(),'Add to wishlist')]")
	WebElement product1;
	public void addProduct1()
	{
		System.out.println("I am on step2");
		product1.click();
	}
	
	
	@FindBy(xpath="//li[contains(@class,'product type-product post-23 status-publish instock product_cat-clothing product_cat-womens-clothing has-post-thumbnail featured shipping-taxable product-type-grouped')]//span[contains(text(),'Add to wishlist')]")
	WebElement product2;
	public void addProduct2()
	{
		product2.click();
	}
	
	@FindBy(xpath="//li[contains(@class,'product type-product post-22 status-publish first instock product_cat-clothing product_cat-womens-clothing has-post-thumbnail sale shipping-taxable purchasable product-type-simple')]//span[contains(text(),'Add to wishlist')]")
	WebElement product3;
	public void addProduct3()
	{
		product3.click();
	}
	
	@FindBy(xpath="//li[contains(@class,'product type-product post-19 status-publish instock product_cat-clothing product_cat-womens-clothing has-post-thumbnail sale shipping-taxable purchasable product-type-variable')]//span[contains(text(),'Add to wishlist')]")
	WebElement product4;	
	public void addProduct4()
	{
		product4.click();
	}	
	
	
	
}

