package com.ap.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ap.qa.base.TestBase;


public class LoginPage extends TestBase{
	//Object repository for login page
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement SignIn;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(name="SubmitLogin")
	WebElement signinBtn;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public HomePage login(String un, String pwd){
		SignIn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signinBtn.click();
		return new HomePage();
	}
}
