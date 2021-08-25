package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage {
	
	 WebDriver driver;
	 
	 @FindBy(xpath = "//*[@class=\"cart-contents\"]")
	 public WebElement clickCart;
	 public void goToCart()
	 {
		 clickCart.click();
	 }

}
