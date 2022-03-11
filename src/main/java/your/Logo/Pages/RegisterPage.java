package your.Logo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import your.Logo.Base.PageBase;

public class RegisterPage extends PageBase{
	public RegisterPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		 wait= new WebDriverWait(driver, 20);
	}

	
    By femaleChkBtn = By.xpath("//input[@id='id_gender2']");
    By maleChkBtn = By.xpath("//input[@id='id_gender1']");
	By firstNameTxtBox = By.id("customer_firstname");
	By lastNameTxtBox= By.id("customer_lastname");
    By passwordTxtBox = By.id("passwd");
    By addressTxtBox = By.id("address1");
	By cityTxtBox= By.id("city"); 
	By stateTxtBox = By.id("id_state");
	By postalCodeTxtBox = By.id("postcode");
    By countryTxtBox = By.id("id_country");
    By mobilePhoneTxtBox= By.id("phone_mobile");
    By aliasAddressTxtBox =By.id("alias");
	By registerBtn= By.xpath("//*[text()='Register']");
	
	public void UserRegister ( String gender , String fName ,String lName, String password, String address , String city, String state, String postalCode,String country, String mobilePhone) throws InterruptedException 
	{
		
		waitUntilvisibilityOf(drvier, femaleChkBtn);
		clickBasedOnGender(gender);
		setTextElementText(drvier, firstNameTxtBox, fName);
		setTextElementText(drvier, lastNameTxtBox, lName);
		setTextElementText(drvier, passwordTxtBox, password);
		setTextElementText(drvier, addressTxtBox, address);
		setTextElementText(drvier, cityTxtBox, city);
		selectByVisibleText(drvier, stateTxtBox, state);
		setTextElementText(drvier,postalCodeTxtBox, postalCode);
		selectByVisibleText(drvier, countryTxtBox, country);
		setTextElementText(drvier, mobilePhoneTxtBox, mobilePhone);
		clickButton(drvier,  registerBtn);
		
	}
	
	public void clickBasedOnGender (String Gender)
	{
		if (Gender=="Male")
		{
			clickButton(drvier, maleChkBtn);
		}
		else
		{
			clickButton(drvier, femaleChkBtn);
			
		}
		
	
	}
	
	
	
}
