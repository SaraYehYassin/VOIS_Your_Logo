package test.Cases;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import your.Logo.Base.TestBase;
import your.Logo.Pages.CheckOutPage;
import your.Logo.Pages.HistoryPage;
import your.Logo.Pages.HomePage;
import your.Logo.Pages.RegisterPage;
import your.Logo.Pages.ShoppingPage;
import your.Logo.TestData.TestData;

public class CheckOutAndConfirmOrderTest extends TestBase{
	

	String url= userdata.getProperty("url");
	HomePage homeObject;
	ShoppingPage shoppingObject;
	RegisterPage registerObject;
	HistoryPage historyObject;
	CheckOutPage checkOutObject;
	Faker fakeData = new Faker ();
	String email = fakeData.internet().emailAddress();
	
		   
	@BeforeClass
	public void OpenURL ()
	{
	openBrowser(url);
	homeObject = new HomePage(driver); 
	registerObject = new RegisterPage(driver);
	shoppingObject= new ShoppingPage(driver);
	historyObject= new HistoryPage(driver);
	checkOutObject= new CheckOutPage(driver);
	

	}
  @Test (priority = 1,dataProvider= "RegisterNewUser")
  public void RegisterNewUser(String gender,String fName,String lName,String password,String address,String city,String state,String postalCode,String country,String mobilePhone) throws InterruptedException 
  {
	  homeObject.CreateNewAccount(email);
	 registerObject.UserRegister(gender, fName, lName, password, address, city, state, postalCode, country, mobilePhone);
	Assert.assertTrue(homeObject.checkUserIsRegisteredSuccessfully());
	 

}
  
  @Test (priority = 2,dataProvider= "ShppItemData")
  public void ShopItem(String shopCategoty, String shopSubCategory, String item_index, String itemType) throws InterruptedException 
  {
	homeObject.selectSpecificSubCategory(shopCategoty,shopSubCategory );
	assertTrue(homeObject.VerifySubCategorySelectedSuccessfully(shopSubCategory));
	shoppingObject.addToCart_ByIndex(item_index);
	assertTrue(checkOutObject.isProductAppearsOnSummary(itemType));
	checkOutObject.CheckOut_Procedure();
	checkOutObject.backToOrder();
	assertTrue(historyObject.CheckPaymentMethod());

	
}
  
  @DataProvider(name="ShppItemData")
  public Object[][] ShppItemData () throws InvalidFormatException, IOException 
  {
         Object[][] data = TestData.fetchData(System.getProperty("user.dir")+"\\UsserData.xlsx", "ShopItem");
      		   
         return data;
  }  
  
  @DataProvider(name="RegisterNewUser")
  public Object[][] RegisterNewUser () throws InvalidFormatException, IOException 
  {
         Object[][] data = TestData.fetchData(System.getProperty("user.dir")+"\\UsserData.xlsx", "RegisterNewUser");
      		   
         return data;
  }  
   
  @AfterClass
  
	public void stopDriver() 
	{
		driver.quit();
	}
	
}
