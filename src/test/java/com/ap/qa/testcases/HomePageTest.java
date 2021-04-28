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

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		// addToCartPage = new AddToCartPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	@Parameters("browser")
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "My account - My Store");
	}

	@Test(priority = 2)
	public void verifytshirtLinkTest() {
		addToCartPage = homePage.clickOnTshirtLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
