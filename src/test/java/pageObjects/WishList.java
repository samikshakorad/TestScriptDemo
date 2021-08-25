package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishList {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'header-right col-md-3 hidden-xs')]//i[contains(@class,'lar la-heart')]")
	WebElement clickWishList;
	
	public void clickOnWishList()
	{
		clickWishList.click();
	}
	
	@FindBy(xpath="//*[@class=\"shop_table cart wishlist_table wishlist_view traditional responsive   \"]//tbody/tr")
    public List<WebElement> wishlistItemList;
	 public int getWishListTableSize() 
	 {
	        return wishlistItemList.size();
	    }
	


}

