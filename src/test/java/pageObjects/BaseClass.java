package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public static void visibleElement(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeSelected(element));
		
		
	}


}
