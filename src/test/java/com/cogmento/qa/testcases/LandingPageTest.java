package com.cogmento.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cogmento.qa.base.CogmentoTestBase;
import com.cogmento.qa.pages.ContactsPage;
import com.cogmento.qa.pages.LandingPage;
import com.cogmento.qa.pages.LoginPage;
import com.cogmento.qa.pages.DealsPage;

//shortcut for import: Ctrl + Shift + O
public class LandingPageTest extends CogmentoTestBase{
	LoginPage loginPage;
	LandingPage landingPage;
//	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	//create constructor and call super class TestBase constructor
	public LandingPageTest() {
		super();
	}
	
	//good practice: test cases should be separated / independent from each other (avoid dependency between 2 tc)
	//before each tc, launch browser and login, after each tc quit browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); //to access LoginPage methods
		landingPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); 
//		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
	}
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String homePageTitle = landingPage.verifyLandingPageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CR", "Landing Page title is not matched"); //last message is printed only when tc failed
	}
	
	@Test (priority = 2)
	public void validateUserNameTest() {
//		testUtil.switchToFrame();  --switch to frame then search for element
		Assert.assertTrue (landingPage.verifyCorrectUserName());
	}
	
	@Test (priority = 3)
	public void verifyContactsLink() {
//		testUtil.switchToFrame();  --switch to frame then search for element
		contactsPage = landingPage.clickOnContactsLink();
	}
	
	@Test (priority = 4)
	public void verifyDealsLink() {
		dealsPage = landingPage.clickOnDealsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
