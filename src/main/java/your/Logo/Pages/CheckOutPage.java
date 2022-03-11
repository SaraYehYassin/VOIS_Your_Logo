package your.Logo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import your.Logo.Base.PageBase;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		 wait= new WebDriverWait(driver, 20);
	}
	
	By proceedToCheckoutFromSummaryBtn = By.xpath("(//*[contains(text(),'Proceed to checkout')]/..)[2]");
	By shoppingCartSummary =By.id("cart_title");
	By shopping_AdressPhase =By.xpath("//*[@class='navigation_page'][text()='Addresses']");
	By shippingAgreeCheckbox =By.id("uniform-cgv");
	By payByBankWire =By.xpath("//*[contains(text(),'Pay by bank wire')]");
	By iConfirmMyOrder =By.xpath("//*[contains(text(),'I confirm my order')]/..");
	By yourOrderCompleted =By.xpath("//*[contains(text(),'Your order on My Store is complete.')]");
	By backToOrders =By.xpath("//*[contains(text(),'Back to orders')]");
	By cartBlackButton= By.xpath("//a[@title='View my shopping cart']");
	By textCartEmptyMsg= By.xpath("//*[text()='Your shopping cart is empty.']");
	
	//Check if cart empty
	public void CheckErrorMessage()  {
	WebElement textCartEmptyMsgElement = drvier.findElement(textCartEmptyMsg);
		if(textCartEmptyMsgElement.isDisplayed()) {
			drvier.findElement(cartBlackButton).click();
			drvier.findElement(cartBlackButton).click();
		}
			
	  	}
	
	
	//Select specific Category
	public Boolean  isProductAppearsOnSummary (String itemType)
	{
		
		By description = By.xpath("//p[@class='product-name']/a[text()='"+itemType+"']");
		waitUntilvisibilityOf(drvier, description);
		scrollToElementByJavaScript(drvier, description);
	
		if (elementIsDisplayed(drvier,description)) {
			return true;			
		}
		else return false;
		}
	
	//Proceed in checkout
	public void  CheckOut_Procedure ( )
	{
		refreshPage(drvier);
		waitUntilvisibilityOf(drvier, proceedToCheckoutFromSummaryBtn);
		scrollToElementByJavaScript(drvier, proceedToCheckoutFromSummaryBtn);
		clickButton(drvier, proceedToCheckoutFromSummaryBtn);
		waitUntilvisibilityOf(drvier, shopping_AdressPhase);
		scrollToElementByJavaScript(drvier, proceedToCheckoutFromSummaryBtn);
		clickButton(drvier, proceedToCheckoutFromSummaryBtn);
		waitUntilvisibilityOf(drvier, shippingAgreeCheckbox);
		scrollToElementByJavaScript(drvier, shippingAgreeCheckbox);
		clickButton(drvier, shippingAgreeCheckbox);
		clickButton(drvier, proceedToCheckoutFromSummaryBtn);
		waitUntilvisibilityOf(drvier, payByBankWire);
		scrollToElementByJavaScript(drvier, payByBankWire);
		clickButton(drvier, payByBankWire);
		waitUntilvisibilityOf(drvier, iConfirmMyOrder);
		clickButton(drvier, iConfirmMyOrder);
		
		
		
	}
	public void  backToOrder ( )
	{
		waitUntilvisibilityOf(drvier, backToOrders);
		clickButton(drvier, backToOrders);	
		
	}

}
