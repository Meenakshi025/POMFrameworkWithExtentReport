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

public class AddToCartPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	public AddToCartPageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		addToCartPage = new AddToCartPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		addToCartPage = homePage.clickOnTshirtLink();
		
	}
	
	
	@Test(priority=1)
	public void verifyAddToCartButtonTest() throws InterruptedException{
		addToCartPage.clickOnProduct();
		Assert.assertTrue(addToCartPage.addToCartButtonIsDisplayed());
		addToCartPage.clickOnAddToCartButton();
		Thread.sleep(2000);
		Assert.assertEquals(addToCartPage.productSuccesfullyAddedText(), "Product successfully added to your shopping cart");
		orderPage = addToCartPage.clickOnProceedToCheckoutBtn();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
