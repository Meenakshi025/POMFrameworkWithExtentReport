package com.ap.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class AddToCartPage extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement product;
	
	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	WebElement addToCartButton;
	                  
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement productAddedSuccessfullyText;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	WebElement proceedToCheckout;

	
	// Initializing the Page Objects:
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnProduct(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", product);
		//product.click();
	}
	
	public boolean addToCartButtonIsDisplayed() {
		return addToCartButton.isDisplayed();
	}
	
	public void clickOnAddToCartButton(){
		addToCartButton.click();
	}
	
	public String productSuccesfullyAddedText(){
		return productAddedSuccessfullyText.getText();
	}
	
	public OrderPage clickOnProceedToCheckoutBtn(){
		proceedToCheckout.click();
		return new OrderPage();
	}
	

}
