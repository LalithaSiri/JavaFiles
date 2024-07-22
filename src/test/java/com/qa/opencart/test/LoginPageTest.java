package com.qa.opencart.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.utilities.TimeWait;
import com.qa.opencart.utilities.WebElementUtility;
public class LoginPageTest extends BaseTest{
	//AccountPage accountPage;
	protected By headerElements= By.cssSelector("#content h2");
	@Test
	public void validateLoginPageTileTest( ) {
		Assert.assertEquals(loginPage.getLoginPageTitle(), AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void validateLoginSuccessfulTest() {
		loginPage.loginToAccount(prop.getProperty("userName"), prop.getProperty("password"));
		elementUtility.findWebElementWithWait(headerElements, TimeWait.WAIT5000SECONDS);
		
		
		//Assert.assertEquals(accountPage.getPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
		Assert.assertEquals(accountPage.getPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
		
	}
	@Test(dependsOnMethods ="validateLoginSuccessfulTest" )
	
	public void validateLogtOutTest() {
		
		loginPage.logout();
		Assert.assertEquals(accountPage.getPageTitle(), AppConstants.LOGOUT_PAGE_TITLE);
		//Assert.assertEquals(accountPage.getAccountPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
		
	}
	
	
	
}
