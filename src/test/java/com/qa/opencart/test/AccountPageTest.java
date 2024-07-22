package com.qa.opencart.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountPageTest extends BaseTest {

	WebDriver driver;
	@Test
	public void validateHeaderTile() {
		accountPage=loginPage.loginToAccount(prop.getProperty("userName"), prop.getProperty("password"));
		Assert.assertEquals(accountPage.getHeaderElements(), AppConstants.ACCOUNTS_PAGE_TITLE);
		
		
		
	}
	
}
