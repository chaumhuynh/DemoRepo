package com.cogmento.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.qa.base.CogmentoTestBase;

public class LoginPage extends CogmentoTestBase{

	//Page Factory - object repository
	//custom xpath = //tagname[@attribute='value']
	@FindBy(xpath = "//input[@name='email']") 
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPasswordLink;
	
/*	@FindBy(id = "reg_email")
	WebElement registerEmail;
	
	@FindBy(xpath = "//button[@name='register']")
	WebElement registerBtn;
	
	@FindBy(xpath = "//img[contains(@class, 'custom-logo')]")
	WebElement logo; 
	
*/
	
	//initialize all elements with constructor
	
	public LoginPage() {
		PageFactory.initElements(driver, this); //this means pointing to current class objects (all variables above)
	}
	
	//Actions (available features in login page)
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
//	public boolean validateLogo() {
//		return logo.isDisplayed();
//	}
	
	public LandingPage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new LandingPage();  //once logged in, should return landing page class object
	}
	
	public boolean validateForgotPwLink() {
		return forgotPasswordLink.isDisplayed();
	}
	
	
	
}
