package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{	
	
		WebDriver driver;
		
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(xpath="//a[@role='button'][contains(text(),'Accept all')]")
		WebElement acceptAll;
		
		@FindBy(xpath="//div[@class='header-right col-md-3 hidden-xs']//a[@title='My Account']")
		WebElement symMyAccount;
		
		@FindBy(xpath="//input[@id='username']")
		WebElement txtEmail;
		
		@FindBy(xpath="//input[@id='password']")
		WebElement txtPassword;
		
		@FindBy(xpath="//button[@name='login']")
		WebElement clickSignIn;
		
		public void clickAcceptAll()
		{		
			clickOn(driver, acceptAll, 10);		
		}	
		
		public void clickMyAccount()
		{		
			symMyAccount.click();		
		}	
			
		public void setEmail(String email)
		{		
			txtEmail.sendKeys(email);		
		}

		public void setPassword(String password)
		{
			txtPassword.sendKeys(password);
		}
		public void btnSignin()
		{
			clickOn(driver, clickSignIn, 10);
		}
		
		@FindBy(xpath="//strong[1][contains(text(),'Samiksha')]")
		WebElement confUsername;
		public boolean isMyAccountPageExists()
		{
			try
			{
			return (confUsername.isDisplayed());
			}
			catch(Exception e)
			{
				return(false);
			}
		}
		
		@FindBy(xpath="//a[@title='Home']")
		WebElement lnkHome;
		public void clickHome()
		{		
			lnkHome.click();		
		}
		@FindBy(xpath="//ul[@@id='menu-categories-menu']//a[@title='Women's Clothing']")
		WebElement lnkWomensClothing;
		
		@FindBy(xpath="//li[@class='menu-item menu-item-has-children dropdown']//a[@class='envo-categories-menu-first']")
		WebElement lnkCategory;
		public void clickCategories()
		{
			Actions act=new Actions(driver);
			act.moveToElement(lnkCategory);
		}		
		public void selectWomensClothing()
		{
			Actions act=new Actions(driver);
			act.moveToElement(lnkCategory).moveToElement(lnkWomensClothing).click().perform();
		}
		@FindBy(xpath="//li[contains(@class,'product type-product post-20 "
				+ "status-publish instock product_cat-clothing product_cat-womens-clothing has-post-thumbnail "
				+ "sale featured downloadable virtual purchasable product-type-simple')]"
				+ "//a[contains(@class,'add_to_wishlist single_add_to_wishlist')]")
		
				WebElement product1;
		public void addToWishListProduct1()
		{
			clickOn(driver, product1, 10);
		}
		
		@FindBy(xpath="//li[contains(@class,'product type-product post-23 status-publish instock "
				+ "product_cat-clothing product_cat-womens-clothing has-post-thumbnail "
				+ "featured shipping-taxable product-type-grouped')]//span[contains(text(),'Add to wishlist')]")
		
				WebElement product2;
		public void addToWishListProduct2()
		{
			clickOn(driver, product2, 10);
		}
		
		@FindBy(xpath="//li[contains(@class,'product type-product post-22 status-publish first instock "
				+ "product_cat-clothing product_cat-womens-clothing has-post-thumbnail sale shipping-taxable "
				+ "purchasable product-type-simple')]//span[contains(text(),'Add to wishlist')]")
				
				WebElement product3;
		public void addToWishListProduct3()
		{
			clickOn(driver, product3, 10);
		}
		
		@FindBy(xpath="//li[contains(@class,'product type-product post-19 status-publish instock "
				+ "product_cat-clothing product_cat-womens-clothing has-post-thumbnail sale "
				+ "shipping-taxable purchasable product-type-variable')]//span[contains(text(),'Add to wishlist')]")
		
				WebElement product4;
		public void addToWishListProduct4()
		{
			clickOn(driver, product4, 10);
		}
		
		@FindBy(xpath="//a[@title='Wishlist']")
		WebElement btnWishlist;
		public void clickWishList()
		{
			btnWishlist.click();
			
		}
		
		public void totalrow()
		{
			int rowcount=driver.findElements(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody/tr")).size();
			System.out.println("Product count in my wishlist:"+rowcount);
			
			
			
			
		}
}

		
			
			
			
		
				
