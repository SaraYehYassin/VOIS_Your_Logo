package your.Logo.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import your.Logo.Base.PageBase;

public class ShoppingPage extends PageBase{
	
	By boxInfoProduct= By.xpath("//div[@class='box-info-product']");	
	By addCartButton = By.linkText("Add to cart");
	By proceedToCheckoutBtn = By.xpath("//*[@title='Proceed to checkout']");	

	

	public ShoppingPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		 wait= new WebDriverWait(driver, 20);
	}
		
	public void  addToCart_ByIndex (String index )
	{
		
		By selectedProduct = By.xpath("//*[@class='product-image-container']/a["+index+"]");
		waitUntilvisibilityOf(drvier, selectedProduct);
        //action.moveToElement(convertFromByToWebElement(drvier, selectedProduct)).build().perform();	
		HoverOverElement(drvier, selectedProduct);
	    waitUntilvisibilityOf(drvier, addCartButton);
		clickByJavaScript(drvier, addCartButton);
	    waitUntilvisibilityOf(drvier, proceedToCheckoutBtn);
		clickByJavaScript(drvier, proceedToCheckoutBtn);
		
		
	}

}
