package your.Logo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import your.Logo.Base.PageBase;

public class HistoryPage extends PageBase{

	public HistoryPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		 wait= new WebDriverWait(driver, 20);
		
	}
	By bankWirePayment = By.xpath("//td[text()='Bank wire']");

	
	public boolean CheckPaymentMethod()  {

		WebElement bankWirePaymentElement = drvier.findElement(bankWirePayment);
		if(bankWirePaymentElement.isDisplayed())
		{
			return true;
			}
		else return false;
	}
		}


