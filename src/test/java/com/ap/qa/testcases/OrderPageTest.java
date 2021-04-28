package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.AddToCartPage;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;
import com.ap.qa.pages.OrderPage;

public class OrderPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	public OrderPageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		orderPage = new OrderPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		addToCartPage = homePage.clickOnTshirtLink();
		addToCartPage.clickOnProduct();
		Thread.sleep(2000);
		addToCartPage.clickOnAddToCartButton();
		Thread.sleep(2000);
		orderPage = addToCartPage.clickOnProceedToCheckoutBtn();
	}
	
	@Test(priority=1)
	public void verifyProductNameTest(){
		Assert.assertEquals(orderPage.getProductName(), "Faded Short Sleeve T-shirts");
	}
	
	/*@Test(priority=2)
	public void verifyProductSizeAndColor(){
		
		Assert.assertEquals(orderPage.getProductSizeAndColor(), "Color : Orange, Size : S");
	}
	
	@Test(priority=3)
	public void verifyProductQty(){
		Assert.assertEquals(orderPage.getProductQty(), "1");
	}
	
	@Test(priority=4)
	public void verifyProductCost(){
		Assert.assertEquals(orderPage.getProductQty(), "$16.51");
	}*/

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
