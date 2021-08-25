public class HomePage {
	
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

