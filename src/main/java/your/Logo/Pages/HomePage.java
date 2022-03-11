package your.Logo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import your.Logo.Base.PageBase;


public class HomePage extends PageBase {
	
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		 wait= new WebDriverWait(driver, 20);
	}
	
	
	
	By signIN= By.xpath("//*[@class='login']");	
	By emailAddressTxtBox = By.id("email_create");
	By CreateAccountBtn =  By.xpath("//*[@class='icon-user left']");
	By registerSuccessMessage = By.xpath("//*[contains(text(),'Welcome to your account.')]");


		 
    public void CreateNewAccount(String email) throws InterruptedException
    {
    	clickButton(drvier,  signIN);
    	setTextElementText(drvier, emailAddressTxtBox, email);
    	clickButton(drvier,  CreateAccountBtn);	
    	
 	   
    }	 
		
	public Boolean checkUserIsRegisteredSuccessfully ()
	{
		if (elementIsDisplayed(drvier,registerSuccessMessage)) {
			return true;
		
		}
		else return false;
		
	}
	

	//Select specific Category
	public void  selectSpecificSubCategory (String mainMenu, String subMenu)
	{
		
		By mainMenuBY = By.xpath("//a[text()='"+mainMenu+"']");
		waitUntilvisibilityOf(drvier, mainMenuBY);		
		action.moveToElement(convertFromByToWebElement(drvier, mainMenuBY)).perform();
		By item = By.xpath("//a[text()='"+subMenu+"']");
		waitUntilvisibilityOf(drvier, item);
		clickButton(drvier, item);
		
	}
	
	
	
	//Check web site navigate to selected Category 
	public Boolean  VerifySubCategorySelectedSuccessfully (String subMenu)
	{
		By subMenuBY = By.xpath("//span[@class='category-name'][contains(text(),'"+subMenu+"')]");
		waitUntilvisibilityOf(drvier, subMenuBY);
		if (elementIsDisplayed(drvier,subMenuBY)) {
			return true;
			
		}
		else return false;
		}
	
	
	
}
