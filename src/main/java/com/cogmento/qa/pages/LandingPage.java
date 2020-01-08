package com.cogmento.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.qa.base.CogmentoTestBase;

public class LandingPage extends CogmentoTestBase{

	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy (xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsPage;
	
	@FindBy (xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsPage;
	
	
	//initialize all elements with constructor
		public LandingPage() {
			PageFactory.initElements(driver, this); //this means pointing to current class objects (all variables above)
		}
		
		public String verifyLandingPageTitle() {
			return driver.getTitle();
		}

		public ContactsPage clickOnContactsLink() {
			contactsPage.click();
			return new ContactsPage();
		}

		public DealsPage clickOnDealsLink() {
			dealsPage.click();
			return new DealsPage();
		}

		public boolean verifyCorrectUserName() {
			return userNameLabel.isDisplayed();
		}

		
}
