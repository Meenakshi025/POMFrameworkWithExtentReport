package com.ap.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class OrderPage extends TestBase{

	@FindBy(linkText = "Faded Short Sleeve T-shirts")
	WebElement productName;
	
	
	@FindBy(xpath = "//*[@id=\"product_1_1_0_137706\"]/td[2]/small[2]/a")
	WebElement productSizeAndColour;
	
	@FindBy(xpath = "//*[@id=\"product_1_1_0_0\"]/td[5]/input[2]")
	WebElement productQuantity;
	
	@FindBy(xpath = "//*[@id=\"product_price_1_1_0\"]/span")
	WebElement Total;
	
	
	public WebElement getCartProductsQty(int numOfProduct) {
		return driver.findElement(By.xpath("//dt[" + numOfProduct + "]//span[@class=\"quantity\"]"));
	}
	
	public WebElement getCartProductPrice(int numOfProduct) {
		return driver.findElement(By.xpath("//dt[" + numOfProduct + "]//span[@class=\"price\"]"));
	}
	// Initializing the Page Objects:
		public OrderPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String getProductName(){
			return productName.getText();
		}
		
		public String getProductSizeAndColor(){
			return productSizeAndColour.getText();
		}
		
		public String getProductQty(){

			return productQuantity.getText();
		
		}
		
		public String getProductTotalCost(){
			return Total.getText();
		}
		
		
}
