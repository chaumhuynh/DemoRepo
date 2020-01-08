package com.cogmento.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cogmento.qa.base.CogmentoTestBase;
import com.cogmento.qa.pages.LandingPage;
import com.cogmento.qa.pages.LoginPage;

public class LoginPageTest extends CogmentoTestBase {
	LoginPage loginPage;
	LandingPage landingPage;
	
	//create constructor
	public LoginPageTest() {
		super(); //call super class TestBase constructor		
	}
		
	@BeforeMethod
	public void setUp() {
		// call initialization method from TestBase class
		initialization();
		loginPage = new LoginPage(); //invoke constructor > initialization; also have to create obj ref to access methods from LoginPage class		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM"); 
	}
	
//	@Test(priority=2)
//	public void validateLogoTest() {
//		boolean flag = loginPage.validateLogo();
//		Assert.assertTrue(flag);
//	}
	
	@Test (priority=2)
	public void loginTest() {
		landingPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //method returns new landingpage class obj so we can store it in landingpage obj ref
	}
	
	@Test (priority=3)
	public void forgotPwLinkTest() {
		boolean flag = loginPage.validateForgotPwLink();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
