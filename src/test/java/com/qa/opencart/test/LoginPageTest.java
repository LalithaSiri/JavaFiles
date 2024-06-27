package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountPage;
public class LoginPageTest extends BaseTest{
	AccountPage accountPage;
	@Test
	public void validateLoginPageTileTest( ) {
		Assert.assertEquals(loginPage.getLoginPageTitle(), AppConstants.LOGIN_PAGE_TITLE);
		
	}
	@Test
	public void validateLoginSuccessfulTest() {
		loginPage.loginToAccount(prop.getProperty("userName"), "password");
		Assert.assertEquals(accountPage.getAccountPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
		
	}
	@Test(dependsOnMethods ="validateLoginSuccessfulTest" )
	
	public void validateLogtOutTest() {
		
		Assert.assertEquals(accountPage.getAccountPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
		
	}
	
	
	
}
